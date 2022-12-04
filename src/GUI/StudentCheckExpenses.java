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
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StudentCheckExpenses extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel lblExpenses;
	private JLabel expenseField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCheckExpenses frame = new StudentCheckExpenses();
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
	public StudentCheckExpenses() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID No");
		lblNewLabel.setBounds(66, 63, 52, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(215, 63, 122, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		expenseField = new JLabel("0");
		expenseField.setHorizontalAlignment(SwingConstants.CENTER);
		expenseField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		expenseField.setBounds(215, 118, 89, 25);
		contentPane.add(expenseField);
		
		JButton btnNewButton = new JButton("Expenses");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				expenseField.setText("expenses");
				LaundroSystem.getStudentFromDataBase(id).getStudentInfo();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(303, 256, 122, 33);
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
		btnNewButton_1.setBounds(101, 254, 103, 37);
		contentPane.add(btnNewButton_1);
		
		lblExpenses = new JLabel("Expenses");
		lblExpenses.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpenses.setBounds(66, 118, 89, 25);
		contentPane.add(lblExpenses);
		
		
	}

}
