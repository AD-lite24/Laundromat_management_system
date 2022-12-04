package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.LaundroSystem;

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

public class StudentReceiveLaundry extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JButton btnNewButton_1;
	private JComboBox<String> yearBox;
	private JComboBox<String> monthBox;
	private JComboBox<String> dateBox;
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
					StudentReceiveLaundry frame = new StudentReceiveLaundry();
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
	public StudentReceiveLaundry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("ID No");
		id.setBounds(56, 59, 52, 25);
		id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(id);
		
		idField = new JTextField();
		idField.setBounds(220, 59, 130, 25);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JLabel date = new JLabel("Date");
		date.setFont(new Font("Tahoma", Font.PLAIN, 20));
		date.setBounds(56, 128, 52, 25);
		contentPane.add(date);
		
		yearBox = new JComboBox<String>();
		yearBox.setModel(new DefaultComboBoxModel<>(new String[] {"2021", "2022", "2023", "2024"}));
		yearBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yearBox.setBounds(220, 128, 76, 25);
		contentPane.add(yearBox);
		
		monthBox = new JComboBox<String>();
		monthBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthBox.setBounds(333, 128, 103, 25);
		contentPane.add(monthBox);
		
		dateBox = new JComboBox<String>();
		dateBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateBox.setBounds(474, 128, 52, 25);
		contentPane.add(dateBox);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				show message 
				String id = idField.getText();
				
				int year = Integer.parseInt(yearBox.getSelectedItem().toString());
				int month = Integer.parseInt(monthBox.getSelectedItem().toString());
				int dateEntered = Integer.parseInt(dateBox.getSelectedItem().toString());
				
				
				LocalDate date = LocalDate.of(year, month, dateEntered);
				System.out.println(id);
				LaundroSystem.getStudentFromDataBase(id).recieveClothes(date);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(333, 295, 124, 33);
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
		btnNewButton_1.setBounds(132, 293, 103, 37);
		contentPane.add(btnNewButton_1);
		
		lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYear.setBounds(220, 182, 76, 25);
		contentPane.add(lblYear);
		
		lblDate_1 = new JLabel("Month");
		lblDate_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1.setBounds(352, 182, 76, 25);
		contentPane.add(lblDate_1);
		
		lblDate_1_1 = new JLabel("Date");
		lblDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1_1.setBounds(474, 182, 57, 25);
		contentPane.add(lblDate_1_1);
		
		
	}

}
