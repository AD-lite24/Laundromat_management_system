
public interface Hostel {
	
	static String name;
	static String dropDay;
	static int deliveryTime;
	static String deliveryDay;
	static int revenue;
	
	
	default void updateDropDay(String day) {
		this.dropDay = day;
	}
	
	default void updateDeliveryTime(int time) {
		this.deliveryTime = time;
	}
	
	
	default void updateDeliveryDay(String day) {
		this.deliveryDay = day;
	}

}

class Krishna implements Hostel{
	
	
	
}

