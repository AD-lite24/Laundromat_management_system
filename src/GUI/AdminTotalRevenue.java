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

public class AdminTotalRevenue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTotalRevenue frame = new AdminTotalRevenue();
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
	public AdminTotalRevenue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRa = new JLabel("Total Revenue");
		lblRa.setBounds(154, 10, 127, 25);
		lblRa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblRa);
		
		JLabel lblHostel = new JLabel("Hostel");
		lblHostel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHostel.setBounds(55, 93, 70, 25);
		contentPane.add(lblHostel);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Krishna", "Gandhi", "Vyas", "Meera", "Shankar", "Budh"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(195, 93, 149, 25);
		contentPane.add(comboBox);
		
		JLabel lblRevenue = new JLabel("Revenue");
		lblRevenue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRevenue.setBounds(55, 153, 81, 25);
		contentPane.add(lblRevenue);
		
		JLabel revenueField = new JLabel("0");
		revenueField.setHorizontalAlignment(SwingConstants.CENTER);
		revenueField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		revenueField.setBounds(195, 153, 127, 25);
		contentPane.add(revenueField);
		
		JButton btnNewButton = new JButton("Revenue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hostel = comboBox.getSelectedItem().toString();
				float revenue = 0;
				for (Hostel hostelObj : LaundroSystem.hostelList){
					if (hostelObj.getName().equals(hostel)){
						revenue = hostelObj.getRevenue();
						break;
					}
				}
				
				revenueField.setText(String.valueOf(revenue));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(213, 210, 109, 33);
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
		btnNewButton_1.setBounds(61, 208, 103, 37);
		contentPane.add(btnNewButton_1);

		LaundroSystem.admin.getRevenuePerHostel(); //Printing on terminal (or file?)
	}
}
