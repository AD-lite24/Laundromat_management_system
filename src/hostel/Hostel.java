package hostel;

import java.io.Serializable;
import java.time.LocalTime;

//should hostel be subclassed? Check problem statement and let me know
public class Hostel implements Serializable{

	private String name;
	private String dropDay;
	private LocalTime deliveryTime;
	private String deliveryDay;
	private float revenue = 0;
	
	public Hostel(String name, String dropDay, LocalTime deliveryTime, String deliveryDay) {
		this.name = name;
		this.dropDay = dropDay;
		this.deliveryTime = deliveryTime;
		this.deliveryDay = deliveryDay;
	}

	
	
	public void setDropDay(String day) {
		this.dropDay = day;
	}
	
	
	public void setDeliveryTime(int deliveryTimeHours, int deliveryTimeMinutes) {
		this.deliveryTime = LocalTime.of(deliveryTimeHours, deliveryTimeMinutes);
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


