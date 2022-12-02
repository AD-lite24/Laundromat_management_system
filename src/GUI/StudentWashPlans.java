package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StudentWashPlans extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentWashPlans frame = new StudentWashPlans();
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
	public StudentWashPlans() {
		setTitle("Wash Plans");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox WashPlans = new JComboBox();
		WashPlans.setFont(new Font("Tahoma", Font.PLAIN, 20));
		WashPlans.setModel(new DefaultComboBoxModel(new String[] {"Plan 1", "Plan 2", "Plan 3", "Plan 4", "Plan 5"}));
		WashPlans.setBounds(134, 97, 147, 37);
		contentPane.add(WashPlans);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String plan = WashPlans.getSelectedItem().toString();
				
//				plan no stored in plan
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(155, 216, 103, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Required Wash Plan");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(118, 21, 184, 37);
		contentPane.add(lblNewLabel);
		
		
	}
}
