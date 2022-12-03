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
	
	private static Map<String, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {

		dataBase.put(student.getId(), student);
		student.getHostel().setHostelRevenue(student.getPlan().getCost());
		LaundroSystem.fillDatabase();
	}

	public static Student getStudentFromDataBase(String id){
		return getDataBase().get(id);
	}
	
	public static Map<String, Student> getDataBase() {
		return dataBase; 
	}

	public static void fillDatabase(){
		try{
			FileWriter fw = new FileWriter("Students.txt",false);
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String,Student> student : LaundroSystem.dataBase.entrySet()){
				StringJoiner sj = new StringJoiner(";");
				sj.add(student.getValue().getId());
				sj.add(student.getValue().getName());
				sj.add(student.getValue().getPhoneNumber());
				sj.add(student.getValue().getPlan().toString());
				sj.add(Float.toString(student.getValue().getMoneyCharged()));
				sj.add(Integer.toString(student.getValue().getNumOfWashes()));
				sj.add(student.getValue().getClothes().toString());
				sj.add(student.getValue().getHostel().getName());
				pw.println(sj);
			}
				pw.close();

		} catch (FileNotFoundException e){
			System.out.println("File not found.");
		}
		catch (IOException e){
			System.out.println("Text not stored.");
		}
	}

	public static void fillHostelDetails(ArrayList<Hostel> hostelList){
		try{
			FileWriter fw=new FileWriter("Hostel.txt",false);
			PrintWriter pw = new PrintWriter(fw);
			for(int i=0;i<hostelList.size();i++){
				StringJoiner sj = new StringJoiner(";");
				sj.add(hostelList.get(i).getName());
				sj.add(hostelList.get(i).getDeliveryDay());
				sj.add(hostelList.get(i).getDropDay());
				sj.add(hostelList.get(i).getDeliveryTime().toString());
				sj.add(Float.toString(hostelList.get(i).getRevenue()));
				pw.println(sj);
			}
				pw.close();
			}catch (FileNotFoundException e){
				System.out.println("File not found.");
			}
			catch (IOException e){
				System.out.println("Text not stored.");
			}		
	}

	public static ArrayList<Hostel> reloadHostel(){
	
		ArrayList<Hostel> hostels= new ArrayList<>();
		try{
			Scanner sc = new Scanner(new File("Hostel.txt"));
			String line;
			while(sc.hasNextLine()){
				line=sc.nextLine();
				String[] hvalues= line.split(";");
				String[] time = hvalues[3].split(",");
				Hostel h = new Hostel(hvalues[1],hvalues[2], LocalTime.of(Integer.parseInt(time[0]),Integer.parseInt(time[1])),hvalues[4]);
				h.setHostelRevenue(Float.valueOf(hvalues[5]));
				hostels.add(h);		
			}
		} catch(FileNotFoundException e){
			System.out.println("File");
		}

		return hostels; 
	}

	public static Map<String, Student> reloadStudentData(){
		HashMap<String, Student> sm= new HashMap<>();

		try{
			Scanner sc = new Scanner(new File("Students.txt"));
			String line;
			while(sc.hasNextLine()){
				line=sc.nextLine();
				String[] values= line.split(";");
				String[] planValues = values[3].split(",");
				String[] clothesVal = values[6].split(",");
				Hostel host=null;;
				for(int i=0;i<LaundroSystem.hostelList.size();i++){
					if(LaundroSystem.hostelList.get(i).getName().equals(values[7])){
						host = LaundroSystem.hostelList.get(i);
						break;
					}
				}
				Student s1 = new Student(values[0],values[1], values[2],new Plan(Integer.valueOf(planValues[0]),Integer.valueOf(planValues[1]),planValues[2],Integer.valueOf(planValues[3])),host);
				s1.getClothes().setAlreadyDropped(Boolean.parseBoolean(clothesVal[3]));
				s1.getClothes().setStatus(clothesVal[0]);
				s1.getClothes().setQuantity(Integer.parseInt(clothesVal[1]));
				s1.getClothes().setWeight(Float.valueOf(clothesVal[2]));		
				sm.put(values[0],s1);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File");
		}
		return sm; 
		}

}
