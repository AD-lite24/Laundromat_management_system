package Main;
import java.util.*;

public class Admin {
	
	private int revenue = 0;
	
	static String userName = "admin";
	static int pin = 1234;
	
	public String showStudentStatus(int id, int date) {
		return System.getDataBase().get(id).clothes.status;
	}
	
	public void updateStatus(int id, int date, String status) {
		Student student = System.getDataBase().get(id);
		
		student.clothes.status = status;
		
	}
	
	public void login(String userName, int pwd) {
		if (userName.equals(this.userName) && pwd == this.pin) {
			System.out.println();
		}
	}
	
	public void logout() {
		
	}
	
	
	
	

}
