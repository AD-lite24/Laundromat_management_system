package Main;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.*;
import Exceptions.*;
import hostel.Hostel;
import plans.Plan;


public class LaundroSystem implements Serializable{

	public static ArrayList<Hostel> hostelList = new ArrayList<>();
	public static ArrayList<Plan> planList = new ArrayList<>();
	public static Admin admin;
	public LaundroSystem(){
		admin = new Admin();
		//Hostels
		Hostel krishna = new Hostel("Krishna", "Monday", LocalTime.of(0, 0), "Wednesday");
		hostelList.add(krishna);
		Hostel vyas = new Hostel("Vyas", "Tuesday", LocalTime.of(0, 0), "Thursday");
		hostelList.add(vyas);
		Hostel meera = new Hostel("Meera", "Tuesday", LocalTime.of(0, 0), "Thursday");
		hostelList.add(meera);
		Hostel gandhi = new Hostel("Gandhi", "Tuesday", LocalTime.of(0, 0), "Thursday");
		hostelList.add(gandhi);
		Hostel ram = new Hostel("Ram", "Tuesday", LocalTime.of(0, 0), "Thursday");
		hostelList.add(ram);
		Hostel budh = new Hostel("Budh", "Tuesday", LocalTime.of(0, 0), "Thursday");
		hostelList.add(budh);
		Hostel shankar = new Hostel("Shankar", "Tuesday", LocalTime.of(0, 0), "Thursday");
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

		dataBase.put(student.getId(), student);
		student.getHostel().setHostelRevenue(student.getPlan().getCost());

	}

	public static Student getStudentFromDataBase(String id){
		return getDataBase().get(id);
	}
	
	public static Map<String, Student> getDataBase() {
		return dataBase; 
	}
	
}
