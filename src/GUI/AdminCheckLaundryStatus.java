package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Exceptions.ClothesNotDroppedException;
import Main.LaundroSystem;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AdminCheckLaundryStatus extends JFrame {

	private JPanel contentPane;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCheckLaundryStatus frame = new AdminCheckLaundryStatus();
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
	public AdminCheckLaundryStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID No");
		lblNewLabel.setBounds(50, 46, 52, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(226, 46, 136, 26);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(50, 116, 52, 25);
		contentPane.add(lblDate);
		
		JComboBox<String> yearBox = new JComboBox<String>();
		yearBox.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024"}));
		yearBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yearBox.setBounds(226, 116, 76, 25);
		contentPane.add(yearBox);
		
		JComboBox<String> monthBox = new JComboBox<String>();
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		monthBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthBox.setBounds(338, 116, 103, 25);
		contentPane.add(monthBox);
		
		JComboBox<String> dateBox = new JComboBox<String>();
		dateBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateBox.setBounds(462, 116, 52, 25);
		contentPane.add(dateBox);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				
				String year = yearBox.getSelectedItem().toString();
				String month = monthBox.getSelectedItem().toString();
				String dateEntered = dateBox.getSelectedItem().toString();
				
				LocalDate date = LocalDate.of(2022, 1, 2);

				try {
					System.out.println(LaundroSystem.getStudentFromDataBase(id).getClothesStatus(date));
				} catch (ClothesNotDroppedException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(303, 258, 123, 33);
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
		btnNewButton_1.setBounds(117, 256, 103, 37);
		contentPane.add(btnNewButton_1);
		
		
	}
}
