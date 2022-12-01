package Main;
import java.io.Serializable;
import java.util.*;

import hostel.Hostel;
import plans.Plan;


public class LaundroSystem implements Serializable{

	public LaundroSystem(){
		Admin admin = new Admin();

		//Hostels
		Hostel krishna = new Hostel("Krishna");
		Hostel vyas = new Hostel("Vyas");
		Hostel meera = new Hostel("Meera");
		Hostel gandhi = new Hostel("Gandhi");
		Hostel ram = new Hostel("Ram");
		Hostel budh = new Hostel("Budh");
		Hostel shankar = new Hostel("Shankar");


		//Plans
		Plan plan1 = new Plan(0, 0, null, 0);
		
	}
	
	private static Map<Integer, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {

		dataBase.put(student.id, student);
		student.getHostel().setHostelRevenue(student.getPlan().getCost());

	}
	
	public static Map<Integer, Student> getDataBase() {

		return dataBase; 
	}
	
}
