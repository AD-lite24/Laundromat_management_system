package hostel;

public class Hostel {
	
	static String name;
	static String dropDay;
	static int deliveryTime;
	static String deliveryDay;
	static int revenue;
	
	
	
	public void updateDropDay(String day) {
		this.dropDay = day;
	}
	
	
	public void updateDeliveryTime(int time) {
		this.deliveryTime = time;
	}
	
	
	public void updateDeliveryDay(String day) {
		this.deliveryDay = day;
	}

}

class Krishna extends Hostel{
	
	public Krishna(){
		Krishna.name = "Krishna";
	}
	
}

