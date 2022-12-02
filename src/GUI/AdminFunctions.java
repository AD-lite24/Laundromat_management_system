package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFunctions extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFunctions frame = new AdminFunctions();
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
	public AdminFunctions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton button1 = new JRadioButton("Print Details of all Students");
		buttonGroup.add(button1);
		button1.setBounds(51, 24, 179, 33);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(button1);
		
		JRadioButton button2 = new JRadioButton("Check Laundry Status of Student");
		buttonGroup.add(button2);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button2.setBounds(51, 75, 179, 33);
		contentPane.add(button2);
		
		JRadioButton button3 = new JRadioButton("Update Laundry Status");
		buttonGroup.add(button3);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button3.setBounds(51, 132, 179, 33);
		contentPane.add(button3);
		
		JRadioButton button4 = new JRadioButton("Schedule Delivery Time");
		buttonGroup.add(button4);
		button4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button4.setBounds(51, 191, 179, 33);
		contentPane.add(button4);
		
		JRadioButton button5 = new JRadioButton("Total Revenue");
		buttonGroup.add(button5);
		button5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button5.setBounds(51, 248, 179, 33);
		contentPane.add(button5);
		
		JRadioButton button6 = new JRadioButton("Log Out");
		buttonGroup.add(button6);
		button6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button6.setBounds(51, 308, 179, 33);
		contentPane.add(button6);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(button1.isSelected()) {
					AdminPrintAllDetails ac = new AdminPrintAllDetails();
					ac.setVisible(true);
					dispose();
				}
				else if(button2.isSelected()){
					AdminCheckLaundryStatus t = new AdminCheckLaundryStatus();
					t.setVisible(true);
					dispose();
				}
				
				else if(button3.isSelected()){
					AdminUpdateStatus u = new AdminUpdateStatus();
					u.setVisible(true);
					dispose();
				}
				
				else if(button4.isSelected()){
					AdminScheduleHostel sa = new AdminScheduleHostel();
					sa.setVisible(true);
					dispose();
				}
				
				else if(button5.isSelected()){
					AdminTotalRevenue ra = new AdminTotalRevenue();
					ra.setVisible(true);
					dispose();
				}
				
				else if(button6.isSelected()){
					AdminLogout l2 = new AdminLogout();
					l2.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(320, 132, 135, 43);
		contentPane.add(btnNewButton);
	}

}
