package Main;


import java.util.Map.Entry;

import hostel.Hostel;

public class Admin {
	
	private int revenue = 0;
	
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
		return revenue;
	}

	//Make method to get revenue per hostel
	//Make a revenue class and override the toString method to print the details per hostel in list format 
	public int getRevenuePerHostel(Hostel hostel){
		return hostel.getRevenue();
	}

	//iterate through the database HashMap
	public void printDetailsOfAllStudents(){
		for( Entry<Integer, Student> entry : LaundroSystem.getDataBase().entrySet() ){
			System.out.println( entry.getKey() + " : " + entry.getValue() );
		}
		
	}

	//Return laundry Status of each student, don't forget to make an array for possible states 
	// public String checkLaundyStatus(int id, int date){
		
	// 	return student.clothes.getStatus();
	// }

	//Schedule drop time for each hostel
	public void scheduleDeliveryTime(Hostel hostel, int time, String day){
		hostel.setDeliveryTime(time);
		hostel.setDeliveryDay(day);
	}






	
	
	

}
