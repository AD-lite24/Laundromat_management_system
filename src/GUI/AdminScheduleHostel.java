package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.LaundroSystem;
import hostel.Hostel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminScheduleHostel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScheduleHostel frame = new AdminScheduleHostel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminScheduleHostel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Get proper date and time
		JLabel lblSa = new JLabel("Schedule Hostel Timings");
		lblSa.setBounds(109, 10, 218, 25);
		lblSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblSa);
		
		JLabel lblNewLabel = new JLabel("Hostel");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 67, 96, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblDay = new JLabel("Date");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDay.setBounds(37, 124, 96, 25);
		contentPane.add(lblDay);
		
		JLabel lblTime = new JLabel("Hour");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(37, 294, 85, 25);
		contentPane.add(lblTime);
		
		JComboBox<String> hostelCombo = new JComboBox<>();
		hostelCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Krishna", "Gandhi", "Meera", "Vyas", "Shankar", "Ram", "Budh"}));
		hostelCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hostelCombo.setBounds(206, 67, 151, 25);
		contentPane.add(hostelCombo);
		
		JComboBox<String> hourCombo = new JComboBox<>();
		hourCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hourCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hourCombo.setBounds(144, 294, 69, 25);
		contentPane.add(hourCombo);

		JLabel lblMinute = new JLabel("Minute");
		lblMinute.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMinute.setBounds(257, 294, 79, 25);
		contentPane.add(lblMinute);

		JComboBox<String> minCombo = new JComboBox<>();
		minCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		minCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		minCombo.setBounds(382, 294, 69, 25);
		contentPane.add(minCombo);
		
		JComboBox<String> yearBox = new JComboBox<String>();
		yearBox.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024"}));
		yearBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yearBox.setBounds(206, 124, 76, 25);
		contentPane.add(yearBox);
		
		JComboBox<String> monthBox = new JComboBox<String>();
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthBox.setBounds(338, 124, 76, 25);
		contentPane.add(monthBox);
		
		JComboBox<String> dateBox = new JComboBox<String>();
		dateBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateBox.setBounds(478, 124, 52, 25);
		contentPane.add(dateBox);
		
		JComboBox<String> hostelCombo_1 = new JComboBox<String>();
		hostelCombo_1.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		hostelCombo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hostelCombo_1.setBounds(206, 219, 151, 37);
		contentPane.add(hostelCombo_1);
		
		JButton btnNewButton = new JButton("Schedule");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostelName = hostelCombo.getSelectedItem().toString();

				int hour = Integer.parseInt(hourCombo.getSelectedItem().toString());
				int min = Integer.parseInt(minCombo.getSelectedItem().toString());
				
				String day = hostelCombo_1.getSelectedItem().toString();
				
				int year = Integer.parseInt(yearBox.getSelectedItem().toString());
				int month = Integer.parseInt(monthBox.getSelectedItem().toString());
				int dateEntered = Integer.parseInt(dateBox.getSelectedItem().toString());

				LaundroSystem.admin.scheduleDeliveryTime(LaundroSystem.returnHostelObj(hostelName), hour, min, day);
				System.out.println("Delivery time of " + hostelName + " updated");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(417, 387, 113, 31);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminFunctions af = new AdminFunctions();
				af.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(179, 384, 103, 37);
		contentPane.add(btnNewButton_1);
		
		
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYear.setBounds(206, 171, 76, 25);
		contentPane.add(lblYear);
		
		JLabel lblDate_1_1 = new JLabel("Month");
		lblDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1_1.setBounds(338, 171, 76, 25);
		contentPane.add(lblDate_1_1);
		
		JLabel lblDate_1_1_1 = new JLabel("Date");
		lblDate_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1_1_1.setBounds(476, 171, 57, 25);
		contentPane.add(lblDate_1_1_1);
		
		JLabel lblDay_2 = new JLabel("Day");
		lblDay_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDay_2.setBounds(37, 219, 96, 25);
		contentPane.add(lblDay_2);
		
		
		
		

		String deliveryDay = ""; //Fill value in this variable 
		String hostelName = "";
		int deliveryTimeHours = 0;
		int deliveryTImeMinutes = 0;

		for (Hostel hostel : LaundroSystem.hostelList){
			if (hostel.getName().equals(hostelName)){
				LaundroSystem.admin.scheduleDeliveryTime(hostel, deliveryTimeHours, deliveryTImeMinutes, deliveryDay);
				break;
			}
		}

		
	}
}
