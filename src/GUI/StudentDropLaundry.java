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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StudentDropLaundry extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JTextField weightField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDropLaundry frame = new StudentDropLaundry();
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
	public StudentDropLaundry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ID No");
		lblNewLabel.setBounds(49, 50, 52, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);

		idField = new JTextField();
		idField.setBounds(265, 54, 127, 25);
		contentPane.add(idField);
		idField.setColumns(10);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(49, 121, 52, 25);
		contentPane.add(lblDate);

		JComboBox<String> yearBox = new JComboBox<>();
		yearBox.setModel(new DefaultComboBoxModel<>(new String[] {"2021", "2022", "2023", "2024"}));
		yearBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		yearBox.setBounds(265, 121, 76, 25);
		contentPane.add(yearBox);
		
		JComboBox<String> monthBox = new JComboBox<String>();
		monthBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		monthBox.setBounds(374, 121, 70, 25);
		contentPane.add(monthBox);
		
		JComboBox<String> dateBox = new JComboBox<String>();
		dateBox.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateBox.setBounds(503, 121, 52, 25);
		contentPane.add(dateBox);

		JLabel lblDrpoWeight = new JLabel("Drpo Weight (kg)");
		lblDrpoWeight.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDrpoWeight.setBounds(49, 243, 155, 25);
		contentPane.add(lblDrpoWeight);
		
		weightField = new JTextField();
		weightField.setColumns(10);
		weightField.setBounds(265, 247, 127, 25);
		contentPane.add(weightField);

		JButton btnNewButton = new JButton("Drop");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idInput = idField.getText();
				int year = Integer.parseInt(yearBox.getSelectedItem().toString());
				int month = Integer.parseInt(monthBox.getSelectedItem().toString());
				int dateEntered = Integer.parseInt(dateBox.getSelectedItem().toString());
				
				LocalDate date = LocalDate.of(year, month, dateEntered);
				float weight = Float.parseFloat(weightField.getText());

				System.out.println(idInput);
				
				try {
					LaundroSystem.getStudentFromDataBase(idInput).dropClothes(5, weight, date);
				} 
				catch (WeightLimitExceededException e1){
					System.out.println(e1.getMessage());
					System.out.println("Continuing with extra charges");
					LaundroSystem.getStudentFromDataBase(idInput).dropClothesWithExtraCharges(0, 0, date);
				}
				catch (ClothesAlreadyDroppedException e1){
					System.out.println(e1.getMessage());
				}
				catch (ClothesDroppedOnWrongDayException e1){
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(342, 314, 103, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentWindow sw = new StudentWindow();
				sw.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(150, 314, 103, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYear.setBounds(262, 175, 76, 25);
		contentPane.add(lblYear);
		
		JLabel lblDate_1_1 = new JLabel("Month");
		lblDate_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1_1.setBounds(374, 175, 76, 25);
		contentPane.add(lblDate_1_1);
		
		JLabel lblDate_1_1_1 = new JLabel("Date");
		lblDate_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1_1_1.setBounds(503, 175, 57, 25);
		contentPane.add(lblDate_1_1_1);
		
		
		
		

	}
}
