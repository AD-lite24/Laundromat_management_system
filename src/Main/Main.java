package Main;

import java.io.*;

import GUI.MainWindow;
import java.awt.EventQueue;

public class Main {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		//to be implemented alongside gui
		LaundroSystem laundro = new LaundroSystem();
		System.out.println(LaundroSystem.reloadStudentData());
		System.out.println(LaundroSystem.reloadHostel());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("test");
		
	}
}
