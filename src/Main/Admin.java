package Main;


import Exceptions.ClothesNotDroppedException;
import hostel.Hostel;


public class Admin {
	
	static private final String userName = "admin";
	static private final String pin = "1234";
	
	public String showStudentStatus(String id, int date) {
		return LaundroSystem.getDataBase().get(id).getClothes().getStatus();
	}
	
	public void updateStatus(String id, int date, String status) {
		Student student = LaundroSystem.getDataBase().get(id);
		student.getClothes().setStatus(status);
		LaundroSystem.updateDatabase();	
	}
	
	
	//Login to admin, needs to work with gui 
	public boolean login(String userName, String pwd) {
		if (userName.equals(Admin.userName) && pwd.equals(Admin.pin)) {
			System.out.println("login successful");
			return true;
		}
		else {
			System.out.println("Incorrect credentials");
			return false;
		}
	}
	
	//Logout of admin, needs to work with gui
	public void logout() {
		
	}

	//Make method to get revenue per hostel
	//Make a revenue class and override the toString method to print the details per hostel in list format 
	public void getRevenuePerHostel(){
		for (Hostel hostel : LaundroSystem.hostelList){
			System.out.println("Revenue for hostel " + hostel.getName() + "is " + hostel.getRevenue());
		}
	}

	//iterate through the database HashMap
	public void printDetailsOfAllStudents(){
		System.out.println("Printing details of all students....");
		for (Student student : LaundroSystem.getDataBase().values()){
			System.out.println("Name: " + student.getName() + " ID: " + student.getId() + " Phone No: " + student.getPhoneNumber());
		}
	}

	//Return laundry Status of each student, don't forget to make an array for possible states 
	public String checkLaundyStatus(Student student){
		try {
			return student.getClothesStatus();
		} catch (ClothesNotDroppedException e) {
			return e.getMessage();
		}
		
	}

	//Schedule drop time for each hostel
	public void scheduleDeliveryTime(Hostel hostel, int deliveryTimeHours, int deliveryTimeMinutes, String day){
		hostel.setDeliveryDay(day);
		hostel.setDeliveryTime(deliveryTimeHours, deliveryTimeMinutes);
		LaundroSystem.fillHostelDetails(LaundroSystem.hostelList);
	}

	public void scheduleDropDay(String day, Hostel hostel){
		hostel.setDropDay(day);
		LaundroSystem.fillHostelDetails(LaundroSystem.hostelList);
	}

}
