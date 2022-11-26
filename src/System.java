import java.util.*;

public class System {
	
	private static Map<Integer, Student> dataBase = new HashMap<>();
	
	public static void addStudent(Student student) {
		dataBase.put(student.id, student);
	}
	
	public static Map<Integer, Student> getDataBase() {
		return dataBase; 
	}
	
}
