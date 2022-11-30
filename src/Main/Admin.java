package Main;


import java.util.Map.Entry;

import hostel.Hostel;
// import hostel.Krishna;

public class Admin {
	
	private int totalRevenue=0;
	
	static private final String userName = "admin";
	static private final int pin = 1234;
	
	public String showStudentStatus(int id, int date) {
		return LaundroSystem.getDataBase().get(id).clothes.getStatus();
	}
	
	public void updateStatus(int id, int date, String status) {
		Student student = LaundroSystem.getDataBase().get(id);
		
		student.clothes.setStatus(status);
		
	}
	
	//Login to admin, needs to work with gui 
	public void login(String userName, int pwd) {
		if (userName.equals(Admin.userName) && pwd == Admin.pin) {
			System.out.println("Welcome");
		}
		else{
			System.out.println("Error");
		}
	}
	
	//Logout of admin, needs to work with gui and switch to student/admin page, use exception handling
	public void logout() {
		
	}

	public int getRevenue() {
		// add for all the objects of hostel class
		// can't be resolved from admin class
		// krishna.calculateHostelRevenue();

		return totalRevenue;
	}



	//iterate through the database HashMap
	public void printDetailsOfAllStudents(){
		for( Entry<Integer, Student> entry : LaundroSystem.getDataBase().entrySet() ){
			System.out.println( entry.getKey() + " : " + entry.getValue() );
		}
		
	}

	//Schedule drop time for each hostel
	public void scheduleDeliveryTime(Hostel hostel, int time, String day){
		hostel.setDeliveryTime(time);
		hostel.setDeliveryDay(day);
	}

	





	
	
	

}
