package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Student extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"S", "D", "C", "B", "R"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setBounds(58, 94, 137, 31);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String choice = comboBox.getSelectedItem().toString();
				
//				choice is what selected by user
				switch(choice){
					
				case "S" :
					StudentS s = new StudentS();
					s.setVisible(true);
					dispose();
					break;
				case "D" :
					StudentD d = new StudentD();
					d.setVisible(true);
					dispose();
					break;
				case "C" :
					StudentC c = new StudentC();
					c.setVisible(true);
					dispose();
					break;
				case "B" :
					StudentB b = new StudentB();
					b.setVisible(true);
					dispose();
					break;
				case "R" :
					StudentR r = new StudentR();
					r.setVisible(true);
					dispose();
					break;
				}
//				wc.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(264, 94, 137, 31);
		contentPane.add(btnNewButton);
		
		
	}
}
