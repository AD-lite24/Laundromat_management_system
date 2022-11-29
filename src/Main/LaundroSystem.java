package Main;
import java.util.*;
import hostel.*;

public class LaundroSystem {

	public LaundroSystem(){
		
	}
	
	private static Map<Integer, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {
		dataBase.put(student.id, student);
		
	}
	
	public static Map<Integer, Student> getDataBase() {
		return dataBase; 
	}
	
}
