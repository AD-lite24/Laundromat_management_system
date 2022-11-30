package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import plans.Plan;

public class Main {
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		//to be implemented alongside gui
		
		LaundroSystem laundro = new LaundroSystem();
		Plan plan = new Plan(0, 0, null, 0);
		LaundroSystem.addStudent(new Student(0, "A", 0, plan, null));
		System.out.println("test");

		try {
			FileOutputStream fileOutputStream = new FileOutputStream("test_file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
			oos.writeObject(laundro);
			oos.close();

			FileInputStream fileInputStream = new FileInputStream("test_file.txt");
			try (ObjectInputStream ois = new ObjectInputStream(fileInputStream)) {
				LaundroSystem laundro2 = (LaundroSystem)ois.readObject();
				System.out.println("test " + LaundroSystem.getDataBase());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
