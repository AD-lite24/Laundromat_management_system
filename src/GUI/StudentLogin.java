package GUI;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.LaundroSystem;
import Main.Student;
import hostel.Hostel;
import plans.Plan;

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
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 480);
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
		lblPhoneNo.setBounds(62, 238, 93, 25);
		contentPane.add(lblPhoneNo);
		
		message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.PLAIN, 20));
		message.setBounds(521, 297, 105, 29);
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
		phone.setBounds(209, 238, 203, 26);
		contentPane.add(phone);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Plan 1", "Plan 2", "Plan 3"}));
		comboBox.setBounds(209, 301, 203, 25);
		contentPane.add(comboBox);
		
		JComboBox<String> hostelBox = new JComboBox<>();
		hostelBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Krishna", "Meera", "Gandhi", "Vyas", "Shankar"}));
		hostelBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		hostelBox.setBounds(209, 180, 203, 25);
		contentPane.add(hostelBox);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Sname = name.getText();
				String Sid = id.getText();
				String Sphone = phone.getText();
				
				String planString = comboBox.getSelectedItem().toString();
				String hostel = hostelBox.getSelectedItem().toString();
				int planIndex = Integer.parseInt(planString.split(" ")[1]);
				Hostel hostelObj = null;

				for (Hostel hostelL : LaundroSystem.hostelList){
					if (hostelL.getName().equals(hostel)){
						hostelObj = hostelL;
					}
				}
				
				Plan planObj = null;
				try {
					switch(planIndex){
						case 1:
						planObj = LaundroSystem.planList.get(0);
						break;
						case 2:
						planObj = LaundroSystem.planList.get(1);
						break;
						case 3:
						planObj = LaundroSystem.planList.get(2);
						break;
					}

					Student student = new Student(Sid, Sname, Sphone, planObj, hostelObj);
					student.registerForLaundro();
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(237, 378, 103, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblPhoneNo_1 = new JLabel("Plan");
		lblPhoneNo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhoneNo_1.setBounds(62, 301, 93, 25);
		contentPane.add(lblPhoneNo_1);
		
		JButton btnPlans = new JButton("Plans");
		btnPlans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentWashPlans swp = new StudentWashPlans();
				swp.setVisible(true);
				dispose();
			}
		});
		btnPlans.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPlans.setBounds(544, 378, 103, 37);
		contentPane.add(btnPlans);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentWindow sw = new StudentWindow();
				sw.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(76, 378, 103, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblHostel = new JLabel("Hostel");
		lblHostel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHostel.setBounds(62, 174, 58, 25);
		contentPane.add(lblHostel);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				id.setText("");
				phone.setText("");
				String someId = "smomid";
				
				String day = comboBox.getSelectedItem().toString();
				String hostel = hostelBox.getSelectedItem().toString();
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.setBounds(393, 378, 103, 37);
		contentPane.add(btnClear);
		
		
		
		
		
		
	}
}
