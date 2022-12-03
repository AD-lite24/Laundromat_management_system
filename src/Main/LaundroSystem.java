package Main;
import java.io.Serializable;
import java.util.*;

import hostel.Hostel;
import plans.Plan;


public class LaundroSystem implements Serializable{

	public static ArrayList<Hostel> hostelList = new ArrayList<>();
	public static ArrayList<Plan> planList = new ArrayList<>();
	public static Admin admin;
	public LaundroSystem(){
		admin = new Admin();
		//Hostels
		Hostel krishna = new Hostel("Krishna");
		hostelList.add(krishna);
		Hostel vyas = new Hostel("Vyas");
		hostelList.add(vyas);
		Hostel meera = new Hostel("Meera");
		hostelList.add(meera);
		Hostel gandhi = new Hostel("Gandhi");
		hostelList.add(gandhi);
		Hostel ram = new Hostel("Ram");
		hostelList.add(ram);
		Hostel budh = new Hostel("Budh");
		hostelList.add(budh);
		Hostel shankar = new Hostel("Shankar");
		hostelList.add(shankar);


		//Plans
		Plan plan1 = new Plan(1000, 10, "plan1", 20);
		planList.add(plan1);
		Plan plan2 = new Plan(1500, 15, "plan2", 25);
		planList.add(plan2);
		Plan plan3 = new Plan(2000, 20, "plan3", 30);
		planList.add(plan3);
	}
	
	private static Map<String, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {

		dataBase.put(student.id, student);
		student.getHostel().setHostelRevenue(student.getPlan().getCost());

	}

	public static Student getStudentFromDataBase(String id){
		return getDataBase().get(id);
	}
	
	public static Map<String, Student> getDataBase() {
		return dataBase; 
	}
	
}
