package GUI;

import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField pass;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(47, 48, 108, 25);
		contentPane.add(lblNewLabel);
		
		userName = new JTextField();
		userName.setBounds(204, 53, 151, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(47, 126, 108, 25);
		contentPane.add(lblPassword);
		
		HashMap<Integer, String> adminUserName = new HashMap<Integer, String>();
		adminUserName.put(1, "D");
		adminUserName.put(2, "De");
		adminUserName.put(3, "Dev");
		adminUserName.put(4, "Deva");
		adminUserName.put(5, "Devan");
		adminUserName.put(6, "Devank");
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean a=true;
				String username = userName.getText();
				String password = pass.getText();
				
				a = adminUserName.containsValue(username);
				
				if(a) {
					AdminFunctions af = new AdminFunctions();
					af.setVisible(true);
					dispose();
				}
				else {
					lblNewLabel_1.setText("Wrong Credentials");
					userName.setText("");
					pass.setText("");
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(143, 220, 117, 33);
		contentPane.add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(204, 130, 151, 25);
		contentPane.add(pass);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(152, 173, 108, 25);
		contentPane.add(lblNewLabel_1);
	}
}
