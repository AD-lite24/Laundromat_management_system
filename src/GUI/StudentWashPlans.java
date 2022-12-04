package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Main.LaundroSystem;
import Main.Student;
import plans.Plan;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 630, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentLogin sl = new StudentLogin();
				sl.setVisible(true);
				dispose();
				
//				String planString = comboBox.getSelectedItem().toString();
				
//				int planIndex = Integer.parseInt(planString.split(" ")[2]);
//				switch(planIndex){
//					case 1:
//						Plan plan = LaundroSystem.planList.get(0);
//						LaundroSystem.addStudent(new Student(planString, planString, planIndex, plan, null));
//				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(226, 316, 103, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Plan");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 29, 90, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblWashes = new JLabel("Washes");
		lblWashes.setHorizontalAlignment(SwingConstants.CENTER);
		lblWashes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWashes.setBounds(226, 29, 90, 25);
		contentPane.add(lblWashes);
		
		JLabel lblPrice = new JLabel("Price (Rs)");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(424, 29, 90, 25);
		contentPane.add(lblPrice);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(46, 83, 90, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(46, 135, 90, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("3");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(46, 185, 90, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("10");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(226, 83, 90, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("15");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(226, 135, 90, 25);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("20");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(226, 185, 90, 25);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("1000");
		lblNewLabel_1_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_5.setBounds(424, 83, 90, 25);
		contentPane.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_5_1 = new JLabel("1500");
		lblNewLabel_1_2_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_5_1.setBounds(424, 135, 90, 25);
		contentPane.add(lblNewLabel_1_2_5_1);
		
		JLabel lblNewLabel_1_2_5_2 = new JLabel("2000");
		lblNewLabel_1_2_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_5_2.setBounds(424, 185, 90, 25);
		contentPane.add(lblNewLabel_1_2_5_2);
		
		
	}
}
