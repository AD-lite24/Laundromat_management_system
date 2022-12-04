package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.LaundroSystem;
import Main.Student;
import Exceptions.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class StudentCheckStatus extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("ID No");
		id.setBounds(79, 73, 52, 25);
		id.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(id);
		
		textField = new JTextField();
		textField.setBounds(246, 73, 119, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = textField.getText();
				LocalDate date = LocalDate.of(2022, 1, 2);
				try{
				System.out.println(LaundroSystem.getStudentFromDataBase(id).getClothesStatus(date));
				}
				catch(ClothesException er){
					er.getMessage();
				}				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(254, 168, 111, 33);
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
		btnNewButton_1.setBounds(79, 166, 103, 37);
		contentPane.add(btnNewButton_1);
	}

}
