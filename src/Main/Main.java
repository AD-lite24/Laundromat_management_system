package Main;

import java.io.*;

import GUI.MainWindow;
import java.awt.EventQueue;

public class Main {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		System.out.println("Welcome to Laundromat");
		LaundroSystem laundro = new LaundroSystem();
		LaundroSystem.readFromFile();

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
		
		
	}
}
