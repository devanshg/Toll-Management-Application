
package trial1;

import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;





public class Login {
    JFrame frame;
    JPanel one, Statistics, two, spare, three, four, spare2, five, six;
    JPanel WorkerScreen2, WorkerScreen3, WorkerScreen4;
    
    public String usernameForJPanel, carCityForJPanel, carNumberForJPanel, typeOfVehicle, typeOfJourney;
    int laneNumber;
    
    static String loginUsr, carCityValue, carNumberValue;
    int fare = 0, totalFare = 0, receiptNo = 0;
    JLabel title; 
    
    
    public UserData1 userdata = new UserData1();
    
    
    Login(){
    	trial1 t = new trial1();
        frame = new JFrame();
         
        
        /* -------LOGIN PAGE--------*/
        
        one = new JPanel();
        one.setLayout(null);
        frame.setLocationRelativeTo(null);
        one.setPreferredSize(new Dimension(500, 300));
        
        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(100,50,80,25);
        
        JTextField userText = new JTextField(20);
        userText.setBounds(200,50,165,25);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100,100,80,25);
        
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(200,100,165,25);
        
        JButton LoginButton = new JButton("Login as Admin");
        LoginButton.setBounds(330, 230, 150, 25);
                
        LoginButton.addActionListener( new ActionListener() 
        {
             
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
            	loginUsr = userText.getText();
            	char[] s1 = passwordText.getPassword();
            	String pass = new String(s1);
            	int c = 0;
				try {
					c= t.adminLogin(loginUsr, pass);
					if(c == 1)
	            	{
					frame.setContentPane(two);
	            	frame.revalidate(); frame.repaint();
	            	}
	            	else
	            	{
	            		JLabel error = new JLabel("Error");
	            		error.setBounds(100, 180, 200,25);

	                    one.add(error);
	            	}
				}
				
				catch(Exception e) {
					System.out.println(e);
				}
            	
	            	
                }
           
        });
        
        /* ---------WORKER LOGIN--------- */
        
        JButton WorkerLoginButton = new JButton("Login");
        WorkerLoginButton.setBounds(150,150,200,25);
        WorkerLoginButton.addActionListener( new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
            	loginUsr = userText.getText();
            	
            	userdata.setName(loginUsr);
            	usernameForJPanel = userdata.getName();
            	
            	char[] s1 = passwordText.getPassword();
            	String pass = new String(s1);
            	int c = 0;
				try {
					c= t.workerLogin(loginUsr, pass);
					if(c == 1)
					{

		            frame.setContentPane(WorkerScreen2);
	            	frame.revalidate(); frame.repaint();
	            	one.repaint();
	            	
	            	
	                title = new JLabel("Welcome, " + usernameForJPanel);
	                title.setBounds(190, 10, 250, 15);
	                
	                WorkerScreen2.add(title);
	            	}
	            	else
	            	{
	            		JLabel error = new JLabel("Error");
	            		error.setBounds(100, 180, 200,25);
	                    one.add(error);
	            	}
				}
				
				catch(Exception e) {
					System.out.println(e);
				}
            	// System.out.println(s);
            	
            }
        });
        
        //System.out.println(loginUsr);
        
        
    	
        one.add(userLabel);
        one.add(userText);
        one.add(passwordLabel);
        one.add(passwordText);
        one.add(LoginButton);
        one.add(WorkerLoginButton);
        
        
        
        
        
        /* -------WORKER WINDOW - LANE SELECTION--------*/
        
        
        WorkerScreen2 = new JPanel();
        WorkerScreen2.setLayout(null);
        
        //System.out.println("Worker window username: " + loginUsr);
        //usernameForJPanel = userdata.getName();
        //System.out.println("Value stored in usernameForJPanel: " + usernameForJPanel);
        
        
        JButton Lane1, Lane2;
        Lane1 = new JButton("Lane 1");
        Lane1.setBounds(150, 50, 200, 50);
        
        int laneNo = 0;
        
        Lane1.addActionListener( new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent arg0) {
                userdata.setLane(1);
                laneNumber = userdata.getLane();
            	
            	try {
					
				}
				catch(Exception e) {
					System.out.println(e);
				}
            	
            	frame.setContentPane(WorkerScreen3);
                frame.revalidate(); frame.repaint();
                
                JLabel WorkerDetails = new JLabel(usernameForJPanel + " working on Lane " + laneNumber);
                WorkerDetails.setBounds(150, 10, 200, 25);
                WorkerScreen3.add(WorkerDetails);
                
            }
        });
        
        Lane2 = new JButton("Lane 2");
        Lane2.setBounds(150, 125, 200, 50);
        
        Lane2.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
            	
            	userdata.setLane(2);
            	laneNumber = userdata.getLane();
            	
                frame.setContentPane(WorkerScreen3);
                frame.revalidate(); frame.repaint();
                
                JLabel WorkerDetails = new JLabel(usernameForJPanel + " working on Lane " + laneNumber);
                WorkerDetails.setBounds(150, 10, 200, 25);
                WorkerScreen3.add(WorkerDetails);
            }
        });
        
        JButton LogoutButton = new JButton("Logout");
        LogoutButton.setBounds(390, 10, 80, 20);
        
        LogoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setContentPane(one);
				frame.revalidate(); frame.repaint();
				frame.repaint();
            	
			}
		});
        WorkerScreen2.add(Lane1);
        WorkerScreen2.add(Lane2);
        WorkerScreen2.add(LogoutButton);
        


        /* -------LANE RECEIPT FORM  FOR LANE 1--------*/

        WorkerScreen3 = new JPanel();

        WorkerScreen3.setLayout(null);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(390, 10, 80, 20);
        
        logoutButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setContentPane(one);
				frame.revalidate(); frame.repaint();
			}
		});
        
        JLabel ReceiptNumber = new JLabel("Receipt Number");
        ReceiptNumber.setBounds(50, 50, 200, 20);
        
        JLabel Vehicle = new JLabel("Choose Car Type");
        Vehicle.setBounds(50, 80, 200, 20);
        
        String VehicleType[] = {"Car","Bike","Truck", "Bus"};
        JComboBox cb = new JComboBox(VehicleType);
        cb.setBounds(250, 80, 200, 20);
        
        JLabel CarCity = new JLabel("Enter Car City");
        CarCity.setBounds(50, 110, 200, 20);
        
        JTextField CarCityText = new JTextField(20);
        CarCityText.setBounds(250, 110, 200, 20);
        carCityValue = CarCityText.getText();
        userdata.setCarCity(carCityValue);
        carCityForJPanel = userdata.getCarCity();
        
        JLabel CarNumber = new JLabel("Enter Vehicle Number");
        CarNumber.setBounds(50, 140, 200, 20);
        
        JTextField CarNumberText = new JTextField(20);
        CarNumberText.setBounds(250, 140, 200, 20);
       
        
        JLabel Trip = new JLabel("Trip");
        Trip.setBounds(50, 170, 200,20);
        
        String TripType[] = {"One Way","Two Way"};
        JComboBox tripcb = new JComboBox(TripType);
        tripcb.setBounds(250, 170, 200, 20);
        
        JButton PrintReceipt, checkSales;
        
        PrintReceipt = new JButton("Print Receipt");
        PrintReceipt.setBounds(140, 220, 80, 25);
        
        PrintReceipt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				carNumberValue = CarNumberText.getText();
			    userdata.setCarNumber(carNumberValue);
			    carNumberForJPanel = userdata.getCarNumber();

			    String VehicleTypeMysql = (String) cb.getItemAt(cb.getSelectedIndex());
			    String JourneyTypeMysql = (String) tripcb.getItemAt(tripcb.getSelectedIndex());
				
			    userdata.setCarType(VehicleTypeMysql);
			    typeOfVehicle = userdata.getCarType();

			    
			    userdata.setTrip(JourneyTypeMysql);
			    typeOfJourney = userdata.getTrip();

			    frame.setContentPane(WorkerScreen4);
				frame.revalidate(); frame.repaint();
				
				
				try {
					

			        JLabel ReceiptNumberGenerated = new JLabel("" + receiptNo);
			        ReceiptNumberGenerated.setBounds(250, 50, 200, 20);        
			        //WorkerScreen3.add(ReceiptNumberGenerated);
			        
					fare = t.CheckJComboBoxValues(VehicleTypeMysql, JourneyTypeMysql);
					totalFare += fare;
					receiptNo++;
				    System.out.println(receiptNo);
					System.out.println(totalFare);

				}
				catch(Exception e) {
					System.out.println(e);
				}
				

				JFrame ReceiptGenerated = new JFrame();
				JDialog ReceiptGeneratedDialog = new JDialog(ReceiptGenerated, "Receipt", true);
				
				ReceiptGeneratedDialog.setLayout(null);
				
				JLabel WelcomeToTollPlaza = new JLabel("Welcome To Toll Plaza");
				WelcomeToTollPlaza.setBounds(131, 5, 162, 20);
				WelcomeToTollPlaza.setFont(new Font("Tahoma", Font.PLAIN, 16));
				ReceiptGeneratedDialog.add(WelcomeToTollPlaza);
				
				
				JLabel label = new JLabel("-----------------------------------------------------------------------------------------------------------\r\n\r\n");
				label.setBounds(0, 35, 431, 13);
				ReceiptGeneratedDialog.add(label);
				
				JLabel ReceiptNumberToBePrinted = new JLabel("Receipt Number: ");
				ReceiptNumberToBePrinted.setFont(new Font("Tahoma", Font.PLAIN, 12));
				ReceiptNumberToBePrinted.setBounds(37, 58, 93, 13);
				ReceiptGeneratedDialog.add(ReceiptNumberToBePrinted);
				
				
				
				JLabel User = new JLabel("User:");
				User.setFont(new Font("Tahoma", Font.PLAIN, 12));
				User.setBounds(273, 58, 45, 13);
				ReceiptGeneratedDialog.add(User);
				
				
				JLabel VehicleTypeForReceipt = new JLabel("Vehicle Type:");
				VehicleTypeForReceipt.setFont(new Font("Tahoma", Font.PLAIN, 12));
				VehicleTypeForReceipt.setBounds(37, 104, 93, 13);
				ReceiptGeneratedDialog.add(VehicleTypeForReceipt);
				

				JLabel FareText = new JLabel("" + fare);
				FareText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				FareText.setBounds(303, 145, 96, 19);
				ReceiptGeneratedDialog.add(FareText);
				
				
				JLabel ReceiptNumberText = new JLabel("" + receiptNo);
				ReceiptNumberText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				ReceiptNumberText.setBounds(131, 56, 96, 19);
				ReceiptGeneratedDialog.add(ReceiptNumberText);
				
				

				JLabel Lane = new JLabel("Lane: ");
				Lane.setFont(new Font("Tahoma", Font.PLAIN, 12));
				Lane.setBounds(273, 104, 76, 25);
				ReceiptGeneratedDialog.add(Lane);
				
				
				JLabel JourneyType = new JLabel("Journey Type:");
				JourneyType.setFont(new Font("Tahoma", Font.PLAIN, 12));
				JourneyType.setBounds(37, 147, 93, 13);
				ReceiptGeneratedDialog.add(JourneyType);
				
				
				JLabel Fare = new JLabel("Fare:");
				Fare.setFont(new Font("Tahoma", Font.PLAIN, 12));
				Fare.setBounds(273, 148, 76, 13);
				ReceiptGeneratedDialog.add(Fare);
				
				JLabel VehicleNumber = new JLabel("Vehicle Number:");
				VehicleNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
				VehicleNumber.setBounds(37, 192, 93, 13);
				ReceiptGeneratedDialog.add(VehicleNumber);
				
				JLabel IssuedOn = new JLabel("ISSUED ON: ");
				IssuedOn.setFont(new Font("Tahoma", Font.PLAIN, 16));
				IssuedOn.setBounds(66, 235, 93, 20);
				ReceiptGeneratedDialog.add(IssuedOn);
				
				

				JLabel UserText = new JLabel(usernameForJPanel);
				UserText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				UserText.setBounds(303, 56, 96, 19);
				ReceiptGeneratedDialog.add(UserText);
				
				
				JLabel VehicleTypeText = new JLabel(typeOfVehicle);
				VehicleTypeText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				VehicleTypeText.setBounds(131, 102, 96, 19);
				ReceiptGeneratedDialog.add(VehicleTypeText);
				
				
				JLabel JourneyTypeText = new JLabel(typeOfJourney);
				JourneyTypeText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				JourneyTypeText.setBounds(131, 145, 96, 19);
				ReceiptGeneratedDialog.add(JourneyTypeText);
				
				
				JLabel LaneText = new JLabel(laneNumber + "");
				LaneText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				LaneText.setBounds(303, 108, 96, 19);
				ReceiptGeneratedDialog.add(LaneText);
				

				JLabel VehicleNumberText = new JLabel(carNumberForJPanel);
				VehicleNumberText.setFont(new Font("Tahoma", Font.PLAIN, 15));
				VehicleNumberText.setBounds(131, 190, 267, 19);
				ReceiptGeneratedDialog.add(VehicleNumberText);
				
				
				
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date date = new Date();
				
				JLabel Date = new JLabel(dateFormat.format(date));
				Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
				Date.setBounds(178, 234, 200, 22);
				ReceiptGeneratedDialog.add(Date);

				JLabel HappyJourney = new JLabel("Have a Happy and Safe Journey");
				HappyJourney.setFont(new Font("Tahoma", Font.PLAIN, 16));
				HappyJourney.setBounds(104, 291, 234, 20);
				ReceiptGeneratedDialog.add(HappyJourney);
				
				JLabel xxx = new JLabel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
				xxx.setBounds(0, 325, 431, 13);
				ReceiptGeneratedDialog.add(xxx);
		       
				
		       
				ReceiptGeneratedDialog.setSize(450,500);
				ReceiptGeneratedDialog.setVisible(true);
				
			    
				
			}
		});
        
        
        checkSales = new JButton("Check Sales");
        checkSales.setBounds(260, 220, 150, 25);
        checkSales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(receiptNo);
				System.out.println(totalFare);
				

				JFrame SalesGenerated = new JFrame();
				JDialog SalesGeneratedDialog = new JDialog(SalesGenerated, "Sales", true);
				
				SalesGeneratedDialog.setLayout(null);
				
				JLabel TotalReceiptsGenerated = new JLabel("Total Receipts Generated: " + receiptNo);
				TotalReceiptsGenerated.setBounds(37, 58, 350, 13);
				TotalReceiptsGenerated.setFont(new Font("Tahoma", Font.PLAIN, 16));
				SalesGeneratedDialog.add(TotalReceiptsGenerated);
				
				
				JLabel TotalSalesGenerated = new JLabel("Total Sales Generated: " + totalFare);
				TotalSalesGenerated.setFont(new Font("Tahoma", Font.PLAIN, 16));
				TotalSalesGenerated.setBounds(37, 128, 350, 13);
				SalesGeneratedDialog.add(TotalSalesGenerated);
				
				
		       
				SalesGeneratedDialog.setSize(500, 250);
				SalesGeneratedDialog.setVisible(true);
				
		        
			}
		});
        
        
        
        WorkerScreen3.add(logoutButton);
        WorkerScreen3.add(ReceiptNumber);
        WorkerScreen3.add(Vehicle);
        WorkerScreen3.add(cb);
        WorkerScreen3.add(CarCity);
        WorkerScreen3.add(CarCityText);
        WorkerScreen3.add(CarNumber);
        WorkerScreen3.add(CarNumberText);
        WorkerScreen3.add(Trip);
        WorkerScreen3.add(tripcb);
        WorkerScreen3.add(PrintReceipt);
        WorkerScreen3.add(checkSales);
        
        
        
        
        /* ----------GENERATE RECEIPT----------- */
        
    	
    	
    	WorkerScreen4 = new JPanel();
    	WorkerScreen4.setLayout(null);
		
		
		JButton newReceipt = new JButton("Print another receipt");
        newReceipt.setBounds(150, 1, 175, 25);
       
        newReceipt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setContentPane(WorkerScreen3);
				frame.revalidate(); frame.repaint();
			}
		});
        
        
        WorkerScreen4.add(newReceipt);
        
        /* ------- ADMIN NAVIGATION PANEL --------*/
        
        two = new JPanel();
        two.setLayout(null);
        
        JLabel l2 = new JLabel("Welcome");
        l2.setBounds(220, 10, 60, 10);
       
        
        JButton AddRemoveEmployee,AddModifyVehicle, checkStats;
        AddRemoveEmployee = new JButton("Add/Remove Employee");
        AddRemoveEmployee.setBounds(150, 50, 200, 50);
        
        AddRemoveEmployee.addActionListener( new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(spare);
                frame.revalidate(); frame.repaint();
            }
        });
        
        AddModifyVehicle = new JButton("Add/Modify Vehicle");
        AddModifyVehicle.setBounds(150, 125, 200, 50);
        
        AddModifyVehicle.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(spare2);
                frame.revalidate(); frame.repaint();
            }
        });
       
        
        JButton Logout = new JButton("Logout");
        Logout.setBounds(390, 10, 80, 20);
        
        Logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setContentPane(one);
				one.validate();
				one.repaint();
			}
		});
        
        two.add(l2);
        two.add(AddRemoveEmployee);
        two.add(AddModifyVehicle);
        two.add(Logout);
        
        
        

          
        /* -------ADD/REMOVE EMPLOYEE--------*/
        
        spare = new JPanel();
        spare.setLayout(null);
        JLabel ChooseEmployeeFunction = new JLabel("Choose Any 1 of the Following");
        ChooseEmployeeFunction.setBounds(150, 10, 200, 20);
        JButton AddEmployee = new JButton("Add Employee");
        AddEmployee.setBounds(150, 50, 200, 50);
        JButton RemoveEmpoloyee = new JButton("Remove Emplouee");
        RemoveEmpoloyee.setBounds(150, 125, 200, 50);
        AddEmployee.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(three);
                frame.revalidate(); frame.repaint();
            }
        });
        
        RemoveEmpoloyee.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(four);
                frame.revalidate(); frame.repaint();
            }
        });

        spare.add(ChooseEmployeeFunction);
        spare.add(AddEmployee);
        spare.add(RemoveEmpoloyee);
        
        
        /* -------ADD EMPLOYEE--------*/
        three = new JPanel();
        three.setLayout(null);
        
        JLabel AddNewEmployee = new JLabel("Add new Employee");
        AddNewEmployee.setBounds(200, 10, 200, 20);
        
        JLabel EmployeeNameToBeAdded = new JLabel("Enter name of Employee");
        EmployeeNameToBeAdded.setBounds(50, 50, 200, 20);
        
        JTextField EmpNameText = new JTextField(20);
        EmpNameText.setBounds(250, 50, 200, 20);        
        
        JLabel EmpPass = new JLabel("Enter Password of Employee");
        EmpPass.setBounds(50, 80, 200, 20);
        
        JTextField EmpPassText = new JTextField(20);
        EmpPassText.setBounds(250, 80, 200, 20);
        
        JLabel EmpAddress = new JLabel("Enter Address of Employee");
        EmpAddress.setBounds(50, 110, 200, 20);
        
        JTextField EmpAddressText = new JTextField(20);
        EmpAddressText.setBounds(250, 110, 200, 20);
        
        JLabel EmpFatherForAddEmployee = new JLabel("Enter Father's name");
        EmpFatherForAddEmployee.setBounds(50, 140, 200,20);
        
        JTextField EmpFatherText = new JTextField(20);
        EmpFatherText.setBounds(250, 140, 200, 20);
        
        JButton SaveEmployee, CancelEmployee;
        
        SaveEmployee = new JButton("Save");
        SaveEmployee.setBounds(140, 220, 80, 25);
        
        SaveEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String EmpNameTextMysql = EmpNameText.getText();
				String EmpPassTextMysql = EmpPassText.getText();
				String EmpAddressTextMysql = EmpAddressText.getText();
				String EmpFatherTextMysql = EmpFatherText.getText();
				
				try {
					t.AddEmployeeSql(EmpNameTextMysql, EmpPassTextMysql, EmpAddressTextMysql, EmpFatherTextMysql);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				
				JFrame EmployeeAdded = new JFrame();
				JDialog EmployeeSavedDialog = new JDialog(EmployeeAdded, "Notification", true);
				EmployeeSavedDialog.setLayout(new FlowLayout());
				JButton EmployeeAddedOK = new JButton("OK");
				EmployeeAddedOK.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						EmployeeSavedDialog.setVisible(false);
					}
				});
				EmployeeSavedDialog.add(new JLabel("Employee Added!"));
				EmployeeSavedDialog.add(EmployeeAddedOK);
				EmployeeSavedDialog.setSize(300,300);
				EmployeeSavedDialog.setVisible(true);
				
			}
		});
        
        CancelEmployee = new JButton("Cancel");
        CancelEmployee.setBounds(300, 220, 80, 25);
        
       
        CancelEmployee.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(two);
                frame.revalidate(); frame.repaint();
            }
        });
        
        three.add(AddNewEmployee);
        three.add(EmployeeNameToBeAdded);
        three.add(EmpNameText);
        three.add(EmpPass);
        three.add(EmpPassText);
        three.add(EmpAddress);
        three.add(EmpAddressText);
        three.add(EmpFatherForAddEmployee);
        three.add(EmpFatherText);
        three.add(SaveEmployee);
        three.add(CancelEmployee);
        
        
        /* -------REMOVE EMPLOYEE--------*/
        
        
        four = new JPanel();
        four.setLayout(null);
        
        JLabel RemoveEmployee = new JLabel("Remove Employee");
        RemoveEmployee.setBounds(200, 10, 200, 20);
        
        JLabel EmployeeNameToBeRemoved = new JLabel("Enter name of Employee");
        EmployeeNameToBeRemoved.setBounds(50, 50, 200, 20);
        
        JTextField EmpNameRemove = new JTextField(20);
        EmpNameRemove.setBounds(250, 50, 200, 20); 
        
        JLabel EmpFatherForRemoveEmployee = new JLabel("Enter Father's name");
        EmpFatherForRemoveEmployee.setBounds(50, 80, 200, 20);
        
        JTextField EmpNameRemoveFather = new JTextField(20);
        EmpNameRemoveFather.setBounds(250, 80, 200, 20);
        
        
        JButton RemoveAnEmployee, CancelRemovingAnEmployee;
        RemoveAnEmployee = new JButton("Remove");
        RemoveAnEmployee.setBounds(140, 220, 100, 25);
        
        RemoveAnEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String EmpNameRemoveMysql = EmpNameRemove.getText();
				String EmpNameRemoveFatherMysql = EmpNameRemoveFather.getText();
				
				try {
					t.RemoveEmployeeSql(EmpNameRemoveMysql, EmpNameRemoveFatherMysql);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				JFrame EmployeeRemoved = new JFrame();
				JDialog EmployeeRemovedDialog = new JDialog(EmployeeRemoved, "Notification", true);
				EmployeeRemovedDialog.setLayout(new FlowLayout());
				JButton EmployeeRemovedOK = new JButton("OK");
				EmployeeRemovedOK.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						EmployeeRemovedDialog.setVisible(false);
					}
				});
				EmployeeRemovedDialog.add(new JLabel("Employee Removed!"));
				EmployeeRemovedDialog.add(EmployeeRemovedOK);
				EmployeeRemovedDialog.setSize(300,300);
				EmployeeRemovedDialog.setVisible(true);
				
			}
		});
        CancelRemovingAnEmployee = new JButton("Cancel");
        CancelRemovingAnEmployee.setBounds(300, 220, 80, 25);
        
        CancelRemovingAnEmployee.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(two);
                frame.revalidate(); frame.repaint();
            }
        });
        
        

        four.add(RemoveEmployee);
        four.add(EmployeeNameToBeRemoved);
        four.add(EmpNameRemove);
        four.add(EmpFatherForRemoveEmployee);
        four.add(EmpNameRemoveFather);
        four.add(RemoveAnEmployee);
        four.add(CancelRemovingAnEmployee);
        
        
        
        /* -------ADD/MODIFY VEHICLE--------*/
        
        
        spare2 = new JPanel();
        spare2.setLayout(null);
        JLabel ChooseVehicleFunction = new JLabel("Choose Any 1 of the Following");
        ChooseVehicleFunction.setBounds(150, 10, 200, 20);
        JButton AddVehicle = new JButton("Add Vehicle");
        AddVehicle.setBounds(150, 50, 200, 50);
        JButton UpdateVehicle = new JButton("Update Vehicle Info");
        UpdateVehicle.setBounds(150, 125, 200, 50);
        AddVehicle.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(five);
                frame.revalidate(); frame.repaint();
            }
        });
        
        UpdateVehicle.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(six);
                frame.revalidate(); frame.repaint();
            }
        });

        spare2.add(ChooseVehicleFunction);
        spare2.add(AddVehicle);
        spare2.add(UpdateVehicle);
        
        
        
        /* -------ADD NEW VEHICLE--------*/
        
        five = new JPanel();
        five.setLayout(null);
        
        JLabel AddNewVehicle = new JLabel("Add new Vehicle");
        AddNewVehicle.setBounds(200, 10, 200, 20);
        
        JLabel VehicleNameToBeAdded = new JLabel("Enter name of Vehicle");
        VehicleNameToBeAdded.setBounds(50, 50, 200, 20);
        
        JTextField VehicleNameText = new JTextField(20);
        VehicleNameText.setBounds(250, 50, 200, 20);        
        
        JLabel VehicleRateOneWay = new JLabel("Enter Rate of Vehicle (one way)");
        VehicleRateOneWay.setBounds(50, 80, 200, 20);
        
        JTextField VehicleRateOneWayText = new JTextField(20);
        VehicleRateOneWayText.setBounds(250, 80, 200, 20);
        
        JLabel VehicleRateTwoWay = new JLabel("Enter Rate of Vehicle (two way)");
        VehicleRateTwoWay.setBounds(50, 110, 200, 20);
        
        JTextField VehicleRateTwoWayText = new JTextField(20);
        VehicleRateTwoWayText.setBounds(250, 110, 200, 20);
        
        JLabel VehiclePassRate = new JLabel("Enter Pass Rate of Vehicle");
        VehiclePassRate.setBounds(50, 140, 200,20);
        
        JTextField VehiclePassRateText = new JTextField(20);
        VehiclePassRateText.setBounds(250, 140, 200, 20);
        
        JButton SaveVehicle, CancelVehicle;
        
        SaveVehicle = new JButton("Save");
        SaveVehicle.setBounds(140, 220, 80, 25);
        
        SaveVehicle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String VehicleNameMysql = VehicleNameText.getText();
				String OneWayRateMysql = VehicleRateOneWayText.getText();
				String TwoWayRateMysql = VehicleRateTwoWayText.getText();
				String PassRateMysql = VehiclePassRateText.getText();
				
				try {
					t.AddVehicleSql(VehicleNameMysql, OneWayRateMysql, TwoWayRateMysql, PassRateMysql);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				
				
				JFrame VehicleAdded = new JFrame();
				JDialog VehicleSavedDialog = new JDialog(VehicleAdded, "Notification", true);
				VehicleSavedDialog.setLayout(new FlowLayout());
				JButton VehicleAddedOK = new JButton("OK");
				VehicleAddedOK.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						VehicleSavedDialog.setVisible(false);
					}
				});
				VehicleSavedDialog.add(new JLabel("Vehicle Added!"));
				VehicleSavedDialog.add(VehicleAddedOK);
				VehicleSavedDialog.setSize(300,300);
				VehicleSavedDialog.setVisible(true);
				
			}
		});
        
        CancelVehicle = new JButton("Cancel");
        CancelVehicle.setBounds(300, 220, 80, 25);
        
       
        CancelVehicle.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(two);
                frame.revalidate(); frame.repaint();
            }
        });
        
        five.add(AddNewVehicle);
        five.add(VehicleNameToBeAdded);
        five.add(VehicleNameText);
        five.add(VehicleRateOneWay);
        five.add(VehicleRateOneWayText);
        five.add(VehicleRateTwoWay);
        five.add(VehicleRateTwoWayText);
        five.add(VehiclePassRate);
        five.add(VehiclePassRateText);
        five.add(SaveVehicle);
        five.add(CancelVehicle);
        
        
        

        
        /* -------UPDATE VEHICLE INFO--------*/
        
        six = new JPanel();
        six.setLayout(null);
        
        JLabel UpdateVehicleInfo = new JLabel("Update Vehicle Info");
        UpdateVehicleInfo.setBounds(200, 10, 200, 20);
        
        JLabel VehicleNameToBeUpdated = new JLabel("Enter name of Vehicle");
        VehicleNameToBeUpdated.setBounds(50, 50, 200, 20);
        
        JTextField VehicleNameToBeUpdatedText = new JTextField(20);
        VehicleNameToBeUpdatedText.setBounds(250, 50, 200, 20);        
        
        JLabel VehicleRateOneWayUpdate = new JLabel("One Way Cost");
        VehicleRateOneWayUpdate.setBounds(50, 80, 200, 20);
        
        JTextField VehicleRateOneWayUpdateText = new JTextField(20);
        VehicleRateOneWayUpdateText.setBounds(250, 80, 200, 20);
        
        JLabel VehicleRateTwoWayUpdate = new JLabel("Two Way Cost");
        VehicleRateTwoWayUpdate.setBounds(50, 110, 200, 20);
        
        JTextField VehicleRateTwoWayUpdateText = new JTextField(20);
        VehicleRateTwoWayUpdateText.setBounds(250, 110, 200, 20);
        
        JLabel VehiclePassRateUpdate = new JLabel("Pass Cost");
        VehiclePassRateUpdate.setBounds(50, 140, 200,20);
        
        JTextField VehiclePassRateUpdateText = new JTextField(20);
        VehiclePassRateUpdateText.setBounds(250, 140, 200, 20);
        
        JButton SaveUpdate, CancelUpdate;
        
        SaveUpdate = new JButton("Save");
        SaveUpdate.setBounds(140, 220, 80, 25);
        
        SaveUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String VehicleNameToBeUpdatedTextMysql = VehicleNameToBeUpdatedText.getText();
				String VehicleRateOneWayUpdateTextMysql = VehicleRateOneWayUpdateText.getText();
				String VehicleRateTwoWayUpdateTextMysql = VehicleRateTwoWayUpdateText.getText();
				String VehiclePassRateUpdateTextMysql = VehiclePassRateUpdateText.getText();
				
				try {
					t.UpdateVehicleSql(VehicleNameToBeUpdatedTextMysql, VehicleRateOneWayUpdateTextMysql, VehicleRateTwoWayUpdateTextMysql, VehiclePassRateUpdateTextMysql);
				}
				catch(Exception e) {
					System.out.println(e);
				}
				
				JFrame VehicleUpdated = new JFrame();
				JDialog VehicleUpdatedDialog = new JDialog(VehicleUpdated, "Notification", true);
				VehicleUpdatedDialog.setLayout(new FlowLayout());
				JButton VehicleUpdatedOK = new JButton("OK");
				VehicleUpdatedOK.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						VehicleUpdatedDialog.setVisible(false);
					}
				});
				VehicleUpdatedDialog.add(new JLabel("Vehicle Updated!"));
				VehicleUpdatedDialog.add(VehicleUpdatedOK);
				VehicleUpdatedDialog.setSize(300,300);
				VehicleUpdatedDialog.setVisible(true);
				
			}
		});
        
        CancelUpdate = new JButton("Cancel");
        CancelUpdate.setBounds(300, 220, 80, 25);
        
       
        CancelUpdate.addActionListener( new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent arg0) {
                frame.setContentPane(two);
                frame.revalidate(); frame.repaint();
            }
        });
        
        six.add(UpdateVehicleInfo);
        six.add(VehicleNameToBeUpdated);
        six.add(VehicleNameToBeUpdatedText);
        six.add(VehicleRateOneWayUpdate);
        six.add(VehicleRateOneWayUpdateText);
        six.add(VehicleRateTwoWayUpdate);
        six.add(VehicleRateTwoWayUpdateText);
        six.add(VehiclePassRateUpdate);
        six.add(VehiclePassRateUpdateText);
        six.add(SaveUpdate);
        six.add(CancelUpdate);
        
       
        /* ------- CHECK STATISTICS --------*/
        
        Statistics = new JPanel();
        Statistics.setLayout(null);
        
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(100, 200, 100, 25);
        backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.setContentPane(WorkerScreen3);
				frame.revalidate(); frame.repaint();
			}
		});
        
        
        Statistics.add(backButton);
        
        //frame.pack();
		frame.setSize(500, 300);
        frame.setContentPane(one);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(null);
        
       
        
    }
     
    
  


	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Login();
            }
        });
 
    }
 
}