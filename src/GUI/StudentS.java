package GUI;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentS extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField phone;
	private JLabel message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentS frame = new StudentS();
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
	public StudentS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID No.");
		lblNewLabel.setBounds(62, 56, 58, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(62, 118, 58, 25);
		contentPane.add(lblName);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo.setBounds(62, 182, 93, 25);
		contentPane.add(lblPhoneNo);
		
		message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.PLAIN, 20));
		message.setBounds(413, 271, 105, 29);
		contentPane.add(message);
		
		id = new JTextField();
		id.setBounds(209, 56, 203, 26);
		contentPane.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(209, 118, 203, 26);
		contentPane.add(name);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(209, 182, 203, 26);
		contentPane.add(phone);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sname = name.getText();
				String Sid = id.getText();
				String Sphone = phone.getText();
				
				try {
					FileWriter fw = new FileWriter("src/Data/"+Sid+".txt",true);
					fw.write(Sid+" "+Sname+" "+Sphone);
					fw.write(System.getProperty("line.separator"));
					fw.close();
					
					message.setText("Success");
					
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(228, 271, 120, 33);
		contentPane.add(btnNewButton);
		
		
	}
}
