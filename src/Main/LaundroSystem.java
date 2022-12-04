package Main;
import java.io.*;
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
	
	private static HashMap<String, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {

		dataBase.put(student.getId(), student);
		student.getHostel().setHostelRevenue(student.getPlan().getCost());
		LaundroSystem.writeToDatabaseFile();

	}

	public static Hostel returnHostelObj(String hostelName){
		Hostel hostelObj = null;
		for (Hostel hostels : hostelList){
			if (hostels.getName().equals(hostelName)){
				hostelObj = hostels;
				break;
			}
		}
		return hostelObj;
	}

	public static Student getStudentFromDataBase(String id){
		return getDataBase().get(id);
	}
	
	public static Map<String, Student> getDataBase() {
		return dataBase; 
	}

	public static void writeToDatabaseFile(){
		try {
			FileOutputStream fileOut = new FileOutputStream("src/Data/database.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(dataBase);
			objectOut.close();
			System.out.println("The Object  was succesfully written to a file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeToHostelFile(){
		try {
			FileOutputStream fileOut = new FileOutputStream("src/Data/hostelInfo.dat");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(hostelList);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFromFile(){
		try {
			ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("src/Data/database.dat"));
			//ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("src/Data/hostelInfo.dat"));
			try {
				dataBase = (HashMap<String, Student>) input1.readObject();
				//hostelList = (ArrayList<Hostel>) input2.readObject();
				input1.close();
				//input2.close();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
}
