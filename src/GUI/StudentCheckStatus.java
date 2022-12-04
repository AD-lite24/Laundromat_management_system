package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.LaundroSystem;
import Exceptions.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class StudentCheckStatus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel date_1;
	private JLabel date_2;
	private JLabel statusField;
	private JLabel lblYear;
	private JLabel lblDate_1;
	private JLabel lblDate_1_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCheckStatus frame = new StudentCheckStatus();
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
	public StudentCheckStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("ID No");
		id.setBounds(75, 52, 52, 25);
		id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(id);
		
		textField = new JTextField();
		textField.setBounds(246, 52, 119, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox<String> yearBox = new JComboBox<String>();
		yearBox.setModel(new DefaultComboBoxModel<>(new String[] {"2021", "2022", "2023", "2024"}));
		yearBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yearBox.setBounds(246, 112, 76, 25);
		contentPane.add(yearBox);
		
		JComboBox<String> monthBox = new JComboBox<String>();
		monthBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthBox.setBounds(363, 112, 103, 25);
		contentPane.add(monthBox);
		
		JComboBox<String> dateBox = new JComboBox<String>();
		dateBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateBox.setBounds(501, 112, 52, 25);
		contentPane.add(dateBox);
		
		JButton btnNewButton = new JButton("Status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				
				int year = Integer.parseInt(yearBox.getSelectedItem().toString());
				int month = Integer.parseInt(monthBox.getSelectedItem().toString());
				int dateEntered = Integer.parseInt(dateBox.getSelectedItem().toString());
				
				LocalDate date = LocalDate.of(year, month, dateEntered);
				
				try{
				System.out.println(LaundroSystem.getStudentFromDataBase(id).getClothesStatus(date));
				String status = LaundroSystem.getStudentFromDataBase(id).getClothesStatus(date);
				statusField.setText(status);
				
				}
				catch(ClothesException er){
					System.out.println(er.getMessage());
				}				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(355, 321, 111, 33);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentWindow sw = new StudentWindow();
				sw.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(171, 319, 103, 37);
		contentPane.add(btnNewButton_1);
		
		date_1 = new JLabel("Date");
		date_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		date_1.setBounds(75, 112, 52, 25);
		contentPane.add(date_1);
		
		date_2 = new JLabel("Status");
		date_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		date_2.setBounds(75, 219, 74, 25);
		contentPane.add(date_2);
		
		statusField = new JLabel("No Status");
		statusField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		statusField.setBounds(246, 219, 119, 25);
		contentPane.add(statusField);
		
		lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYear.setBounds(246, 157, 76, 25);
		contentPane.add(lblYear);
		
		lblDate_1 = new JLabel("Month");
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1.setBounds(378, 157, 76, 25);
		contentPane.add(lblDate_1);
		
		lblDate_1_1 = new JLabel("Date");
		lblDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1_1.setBounds(501, 157, 57, 25);
		contentPane.add(lblDate_1_1);
		
		
	}
}
