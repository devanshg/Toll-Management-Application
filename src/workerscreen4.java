import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class workerscreen4 {

	private JFrame frame;
	private JTextField ReceiptNumberText;
	private JTextField UserText;
	private JTextField VehicleTypeText;
	private JTextField LaneText;
	private JTextField JourneyTypeText;
	private JTextField FareText;
	private JTextField VehicleNumberText;
	private JTextField Date;
	private JTextField Time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					workerscreen4 window = new workerscreen4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public workerscreen4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel WorkerScreen4 = new JPanel();
		WorkerScreen4.setBorder(null);
		WorkerScreen4.setBackground(Color.WHITE);
		WorkerScreen4.setBounds(46, 38, 431, 456);
		frame.getContentPane().add(WorkerScreen4);
		WorkerScreen4.setLayout(null);
		
		JLabel WelcomeToTollPlaza = new JLabel("Welcome To Toll Plaza");
		WelcomeToTollPlaza.setBounds(131, 5, 162, 20);
		WelcomeToTollPlaza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		WorkerScreen4.add(WelcomeToTollPlaza);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(298, 14, 1, 1);
		WorkerScreen4.add(layeredPane);
		
		JLabel label = new JLabel("-----------------------------------------------------------------------------------------------------------\r\n\r\n");
		label.setBounds(0, 35, 431, 13);
		WorkerScreen4.add(label);
		
		JLabel ReceiptNumber = new JLabel("Receipt Number: ");
		ReceiptNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ReceiptNumber.setBounds(37, 58, 93, 13);
		WorkerScreen4.add(ReceiptNumber);
		
		ReceiptNumberText = new JTextField();
		ReceiptNumberText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ReceiptNumberText.setBounds(131, 56, 96, 19);
		WorkerScreen4.add(ReceiptNumberText);
		ReceiptNumberText.setColumns(10);
		
		JLabel User = new JLabel("User:");
		User.setFont(new Font("Tahoma", Font.PLAIN, 12));
		User.setBounds(273, 58, 45, 13);
		WorkerScreen4.add(User);
		
		UserText = new JTextField();
		UserText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		UserText.setBounds(303, 56, 96, 19);
		WorkerScreen4.add(UserText);
		UserText.setColumns(10);
		
		JLabel VehicleType = new JLabel("Vehicle Type:");
		VehicleType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		VehicleType.setBounds(37, 104, 93, 13);
		WorkerScreen4.add(VehicleType);
		
		VehicleTypeText = new JTextField();
		VehicleTypeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		VehicleTypeText.setBounds(131, 102, 96, 19);
		WorkerScreen4.add(VehicleTypeText);
		VehicleTypeText.setColumns(10);
		
		JLabel Lane = new JLabel("Lane: ");
		Lane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Lane.setBounds(273, 104, 76, 25);
		WorkerScreen4.add(Lane);
		
		LaneText = new JTextField();
		LaneText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LaneText.setBounds(303, 108, 96, 19);
		WorkerScreen4.add(LaneText);
		LaneText.setColumns(10);
		
		JLabel JourneyType = new JLabel("Journey Type:");
		JourneyType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JourneyType.setBounds(37, 147, 93, 13);
		WorkerScreen4.add(JourneyType);
		
		JourneyTypeText = new JTextField();
		JourneyTypeText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JourneyTypeText.setBounds(131, 145, 96, 19);
		WorkerScreen4.add(JourneyTypeText);
		JourneyTypeText.setColumns(10);
		
		FareText = new JTextField();
		FareText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		FareText.setBounds(303, 145, 96, 19);
		WorkerScreen4.add(FareText);
		FareText.setColumns(10);
		
		JLabel Fare = new JLabel("Fare:");
		Fare.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Fare.setBounds(273, 148, 76, 13);
		WorkerScreen4.add(Fare);
		
		JLabel VehicleNumber = new JLabel("Vehicle Number:");
		VehicleNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		VehicleNumber.setBounds(37, 192, 93, 13);
		WorkerScreen4.add(VehicleNumber);
		
		VehicleNumberText = new JTextField();
		VehicleNumberText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		VehicleNumberText.setBounds(131, 190, 267, 19);
		WorkerScreen4.add(VehicleNumberText);
		VehicleNumberText.setColumns(10);
		
		JLabel IssuedOn = new JLabel("ISSUED ON: ");
		IssuedOn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		IssuedOn.setBounds(66, 235, 93, 20);
		WorkerScreen4.add(IssuedOn);
		
		Date = new JTextField();
		Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Date.setBounds(178, 234, 96, 22);
		WorkerScreen4.add(Date);
		Date.setColumns(10);
		
		Time = new JTextField();
		Time.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Time.setBounds(283, 234, 96, 22);
		WorkerScreen4.add(Time);
		Time.setColumns(10);
		
		JLabel HappyJourney = new JLabel("Have a Happy and Safe Journey");
		HappyJourney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		HappyJourney.setBounds(104, 291, 234, 20);
		WorkerScreen4.add(HappyJourney);
		
		JLabel xxx = new JLabel("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		xxx.setBounds(0, 325, 431, 13);
		WorkerScreen4.add(xxx);
	}
}
