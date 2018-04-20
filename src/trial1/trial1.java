package trial1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class trial1 {
	public static void main(String[] args) throws Exception
	{
		Login l = new Login();
		
	}
	
	int adminLogin(String s, String pass)
	{
		int c = 0;
		try {
			
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			//2. Create a Statement
			String LoginForAdmin = "SELECT * FROM admin";
			Statement statement = myConn.createStatement();
			ResultSet result = statement.executeQuery(LoginForAdmin);
			while(result.next())
			{
				String adminuser = result.getString(1);
				String adminpass = result.getString(2);
				if(s.equals(adminuser) && pass.equals(adminpass))
				{
					c = 1;
				}
				
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	int workerLogin(String s, String pass)
	{
		int c = 0;
		try {
			
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			//2. Create a Statement
			String LoginForWorker = "SELECT * FROM user";
			Statement statement = myConn.createStatement();
			ResultSet result = statement.executeQuery(LoginForWorker);
			while(result.next())
			{
				String workeruser = result.getString(1);
				String workerpass = result.getString(2);
				if(s.equals(workeruser) && pass.equals(workerpass))
				{
					c = 1;
				}
				
			}
			myConn.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	
	void AddVehicleSql(String VehicleNameMysql, String OneWayRateMysql, String TwoWayRateMysql, String PassRateMysql) throws Exception
	{
		String trip="";
		

		try {
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			//2. Create a Statement
			String addVehicle1 = "insert into vehicle values ('"+VehicleNameMysql+"', 'One Way', '"+OneWayRateMysql+"', '"+PassRateMysql+"')";
			PreparedStatement vehicleAddition1= myConn.prepareStatement(addVehicle1);     //for query execution
			vehicleAddition1.execute();
		
			String addVehicle2 = "insert into vehicle values ('"+VehicleNameMysql+"', 'Two Way', '"+TwoWayRateMysql+"', '"+PassRateMysql+"')";
			PreparedStatement vehicleAddition2= myConn.prepareStatement(addVehicle2);     //for query execution
			vehicleAddition2.execute();

			myConn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	void UpdateVehicleSql(String VehicleNameToBeUpdatedTextMysql, String VehicleRateOneWayUpdateTextMysql, String VehicleRateTwoWayUpdateTextMysql, String VehiclePassRateUpdateTextMysql) throws Exception
	{

		try {
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			
			//2. Create a Statement create the java mysql update preparedstatement
			String updateVehicle1 = "UPDATE vehicle SET rate=?, pass_rate=? WHERE vehicle_name=? AND journey_type like 'One Way'";
			 
			PreparedStatement statement1 = myConn.prepareStatement(updateVehicle1);
			statement1.setString(1, VehicleRateOneWayUpdateTextMysql);
			statement1.setString(2, VehiclePassRateUpdateTextMysql);
			statement1.setString(3, VehicleNameToBeUpdatedTextMysql);
		      // execute the java preparedstatement
			statement1.executeUpdate();
			
			String updateVehicle2 = "UPDATE vehicle SET rate=?, pass_rate=? WHERE vehicle_name=? AND journey_type like 'Two Way'";
			 
			PreparedStatement statement2 = myConn.prepareStatement(updateVehicle2);
			statement2.setString(1, VehicleRateTwoWayUpdateTextMysql);
			statement2.setString(2, VehiclePassRateUpdateTextMysql);
			statement2.setString(3, VehicleNameToBeUpdatedTextMysql);
		      // execute the java preparedstatement
			statement2.executeUpdate();
			
			myConn.close();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	void AddEmployeeSql(String EmpNameTextMysql, String EmpPassTextMysql, String EmpAddressTextMysql, String EmpFatherTextMysql) throws Exception
	{

		try {
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			//2. Create a Statement
			String addEmployee = "insert into user values ('"+EmpNameTextMysql+"', '"+EmpPassTextMysql+"', '"+EmpAddressTextMysql+"', '"+EmpFatherTextMysql+"')";
			PreparedStatement psmt= myConn.prepareStatement(addEmployee);     //for query execution
	        psmt.execute();
	        
	        myConn.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	
	void RemoveEmployeeSql(String EmpNameRemoveMysql, String EmpNameRemoveFatherMysql)
	{

		try {
			//1. Get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			//2. Create a Statement
			String removeEmployee = "DELETE FROM user WHERE username=? AND fathers_name=?";
			PreparedStatement employeeRemoved= myConn.prepareStatement(removeEmployee);     //for query execution
			employeeRemoved.setString(1, EmpNameRemoveMysql);
			employeeRemoved.setString(2, EmpNameRemoveFatherMysql);
			employeeRemoved.executeUpdate();
			
			myConn.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int CheckJComboBoxValues(String VehicleTypeMysql, String JourneyTypeMysql)
	{
		
		int fare1 = 0;
		try {
			//1. Get a connection to the database
			Connection myConnFinal = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");
			//System.out.println(VehicleTypeMysql);
			//2. Create a Statement
			//String checkValues = ;
			PreparedStatement valuesChecked= myConnFinal.prepareStatement("SELECT * FROM vehicle WHERE vehicle_name =? AND journey_type=?");     //for query execution
			valuesChecked.setString(1, VehicleTypeMysql);
			valuesChecked.setString(2, JourneyTypeMysql);
			ResultSet valuesResult = valuesChecked.executeQuery();
			while(valuesResult.next())
			{
				fare1 = valuesResult.getInt(3);
			}		
			
			myConnFinal.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return fare1;
		
	}
	
	
	
	

	
}

