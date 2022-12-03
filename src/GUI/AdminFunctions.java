package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class AdminFunctions extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 551, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton button1 = new JRadioButton("Print Details of all Students");
		button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button1.setBounds(24, 17, 382, 21);
		contentPane.add(button1);
		
		JRadioButton button2 = new JRadioButton("Check Laundry Status of Student");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button2.setBounds(24, 56, 382, 21);
		contentPane.add(button2);
		
		JRadioButton button3 = new JRadioButton("Update Laundry Status");
		button3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button3.setBounds(24, 95, 382, 21);
		contentPane.add(button3);
		
		JRadioButton button4 = new JRadioButton("Schedule Delivery Time");
		button4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button4.setBounds(24, 136, 382, 21);
		contentPane.add(button4);
		
		JRadioButton button5 = new JRadioButton("Total Revenue");
		button5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button5.setBounds(24, 175, 382, 21);
		contentPane.add(button5);
		
		JRadioButton button6 = new JRadioButton("Log Out");
		button6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button6.setBounds(24, 216, 382, 21);
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
					AdminWindow aw = new AdminWindow();
					aw.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(385, 122, 142, 33);
		contentPane.add(btnNewButton);
		
		
	}
}
