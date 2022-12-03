package hostel;

import java.time.LocalTime;

//should hostel be subclassed? Check problem statement and let me know
public class Hostel {

	private String name;
	private String dropDay;
	private LocalTime deliveryTime;
	private String deliveryDay;
	private float revenue = 0;
	
	public Hostel(String name) {
		this.name = name;
	}
	
	public void setDropDay(String day) {
		this.dropDay = day;
	}
	
	
	public void setDeliveryTime(int deliveryTimeHours, int deliveryTImeMinutes) {
		this.deliveryTime = LocalTime.of(deliveryTimeHours, deliveryTImeMinutes);
	}
	
	
	public void setDeliveryDay(String day) {
		this.deliveryDay = day;
	}
	
	public void setHostelRevenue(float amount) {
		this.revenue += amount;
	}
	
	public float getRevenue() {
		return revenue;
	}


	public String getDropDay() {
		return dropDay;
	}


	public LocalTime getDeliveryTime() {
		return deliveryTime;
	}


	public String getDeliveryDay() {
		return deliveryDay;
	}

	public String getName() {
		return name;
	}
	
	

}


