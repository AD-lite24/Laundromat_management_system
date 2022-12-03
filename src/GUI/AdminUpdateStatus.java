package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUpdateStatus extends JFrame {

	private JPanel contentPane;
	private JTextField IdField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdateStatus frame = new AdminUpdateStatus();
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
	public AdminUpdateStatus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID No");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(60, 29, 75, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(60, 86, 75, 25);
		contentPane.add(lblDate);
		
		IdField = new JTextField();
		IdField.setBounds(190, 29, 151, 25);
		contentPane.add(IdField);
		IdField.setColumns(10);
		
		JLabel lblDate_1 = new JLabel("Status");
		lblDate_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate_1.setBounds(60, 144, 75, 25);
		contentPane.add(lblDate_1);
		
		JLabel statusField = new JLabel("No Status");
		statusField.setHorizontalAlignment(SwingConstants.CENTER);
		statusField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		statusField.setBounds(190, 144, 151, 25);
		contentPane.add(statusField);
		
		JButton btnNewButton = new JButton("Check Status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = IdField.getText();
				
				String status = "some status";
				statusField.setText(status);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(130, 214, 165, 39);
		contentPane.add(btnNewButton);
	}
}
