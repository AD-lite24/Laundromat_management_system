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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StudentLogin extends JFrame {

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
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
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
		message.setBounds(410, 318, 105, 29);
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
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Plan 1", "Plan 2", "Plan 3", "Plan 4", "Plan 5"}));
		comboBox.setBounds(209, 245, 203, 25);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sname = name.getText();
				String Sid = id.getText();
				String Sphone = phone.getText();
				
				String planString = comboBox.getSelectedItem().toString();
				int planIndex = Integer.parseInt(planString.split(" ")[2]);
				
				try {
					
					if() {
						
					}
					
					else {
						FileWriter fw = new FileWriter("src/Data/"+Sid+".txt",true);
						fw.write(Sid+" "+Sname+" "+Sphone);
						fw.write(System.getProperty("line.separator"));
						fw.close();
						
						message.setText("Success");
						StudentWashPlans swp = new StudentWashPlans();
						swp.setVisible(true);
						dispose();
					}
					
					
					
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(188, 314, 120, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblPhoneNo_1 = new JLabel("Plan");
		lblPhoneNo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo_1.setBounds(62, 245, 93, 25);
		contentPane.add(lblPhoneNo_1);
		
		
		
		
	}
}
