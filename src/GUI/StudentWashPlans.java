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

public class StudentWashPlans extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(41, 41, 87, 25);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(41, 102, 87, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(41, 164, 87, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JRadioButton plan1 = new JRadioButton("Plan 1");
		buttonGroup.add(plan1);
		plan1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		plan1.setBounds(213, 41, 138, 21);
		contentPane.add(plan1);
		
		JRadioButton plan2 = new JRadioButton("Plan 2");
		buttonGroup.add(plan2);
		plan2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		plan2.setBounds(213, 102, 138, 21);
		contentPane.add(plan2);
		
		JRadioButton plan3 = new JRadioButton("Plan 3");
		buttonGroup.add(plan3);
		plan3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		plan3.setBounds(213, 164, 138, 21);
		contentPane.add(plan3);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(plan1.isSelected()) {
//					methods/code
				}
				else if(plan2.isSelected()) {
//					method/code
				}
				else if(plan3.isSelected()) {
//					method/code
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(145, 216, 103, 37);
		contentPane.add(btnNewButton);
	}
}
