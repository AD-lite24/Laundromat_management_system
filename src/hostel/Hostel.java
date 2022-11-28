package hostel;

//should hostel be subclassed? Check problem statement and let me know
public class Hostel {

	String name;
	private String dropDay;
	private int deliveryTime;
	private String deliveryDay;
	private int revenue = 0;
	
	public Hostel(String name) {
		this.name = name;
	}
	
	public void setDropDay(String day) {
		this.dropDay = day;
	}
	
	
	public void setDeliveryTime(int time) {
		this.deliveryTime = time;
	}
	
	
	public void setDeliveryDay(String day) {
		this.deliveryDay = day;
	}
	
	public void setHostelRevenue(int amount) {
		this.revenue += amount;
	}
	
	public int getRevenue() {
		return revenue;
	}


	public String getDropDay() {
		return dropDay;
	}


	public int getDeliveryTime() {
		return deliveryTime;
	}


	public String getDeliveryDay() {
		return deliveryDay;
	}
	
	

}


