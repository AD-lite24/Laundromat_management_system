package hostel;
import Main.Revenue;


//should hostel be subclassed? Check problem statement and let me know
public class Hostel {

	String name;
	private String dropDay;
	private int deliveryTime;
	private String deliveryDay;
	private int revenue = 0;

	// create 13 objects for each hostel
	public Hostel(String name, String dropDay){
		this.name=name;
		this.dropDay= dropDay;
	}
	
	public Hostel(String name) {
		this.name = name;
	}

	public String getHostelName(){
		return this.name;
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
	
	public int calculateHostelRevenue() {
		Revenue rev=new Revenue();
		revenue= rev.calculateRevenue(this.name);
		System.out.println(rev);
		return revenue;
	}

	
	// public int getRevenue() {
		
	// 	return revenue;
	// }


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


