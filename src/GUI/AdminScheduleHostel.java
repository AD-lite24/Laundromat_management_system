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
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDay.setBounds(37, 116, 96, 25);
		contentPane.add(lblDay);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(37, 168, 96, 25);
		contentPane.add(lblTime);
		
		JComboBox hostelCombo = new JComboBox();
		hostelCombo.setModel(new DefaultComboBoxModel(new String[] {"H1", "H2", "H3", "H4", "H5"}));
		hostelCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hostelCombo.setBounds(206, 67, 151, 25);
		contentPane.add(hostelCombo);
		
		JComboBox dayCombo = new JComboBox();
		dayCombo.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		dayCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dayCombo.setBounds(206, 122, 151, 25);
		contentPane.add(dayCombo);
		
		JComboBox timeCombo = new JComboBox();
		timeCombo.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		timeCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeCombo.setBounds(206, 174, 59, 25);
		contentPane.add(timeCombo);
		
		JComboBox apCombo = new JComboBox();
		apCombo.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		apCombo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		apCombo.setBounds(298, 174, 59, 25);
		contentPane.add(apCombo);
		
		JButton btnNewButton = new JButton("Schedule");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostel = hostelCombo.getSelectedItem().toString();
				String day = dayCombo.getSelectedItem().toString();
				String time = timeCombo.getSelectedItem().toString();
				String ap = apCombo.getSelectedItem().toString();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(142, 222, 113, 31);
		contentPane.add(btnNewButton);
		
		

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
