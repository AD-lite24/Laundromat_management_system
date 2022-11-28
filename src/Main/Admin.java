package Main;
import java.util.*;

public class Admin {
	
	private int revenue = 0;
	
	static final String userName = "admin";
	static final int pin = 1234;
	
	public String showStudentStatus(int id, int date) {
		return LaundroSystem.getDataBase().get(id).clothes.status;
	}
	
	public void updateStatus(int id, int date, String status) {
		Student student = LaundroSystem.getDataBase().get(id);
		
		student.clothes.status = status;
		
	}
	
	public void login(String userName, int pwd) {
		if (userName.equals(Admin.userName) && pwd == Admin.pin) {
			System.out.println();
		}
	}
	
	public void logout() {
		
	}
	
	
	
	

}
