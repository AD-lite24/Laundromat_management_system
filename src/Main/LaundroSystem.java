package Main;
import java.io.Serializable;
import java.util.*;

import hostel.Hostel;
import plans.Plan;


public class LaundroSystem implements Serializable{

	public LaundroSystem(){
		Admin admin = new Admin();

		//Hostel
		Hostel krishna = new Hostel("Krishna");

		//Plans
		Plan plan1 = new Plan(0, 0, null, 0);
		
	}
	
	private static Map<Integer, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {

		dataBase.put(student.id, student);

	}
	
	public static Map<Integer, Student> getDataBase() {

		return dataBase; 
	}
	
}
