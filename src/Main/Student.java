package Main;
import hostel.Hostel;
import plans.Plan;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.spi.CalendarDataProvider;

import Exceptions.*;


class UserEntryError extends Exception {
	public UserEntryError(String message){
		super(message);
	}
}

class DroppedClothes{
	private String status;
	private int quantiy;
	private float weight;
	private boolean alreadyDropped = false;

	public boolean getIsAlreadyDropped() {
		return alreadyDropped;
	}
	public void setAlreadyDropped(boolean alreadyDropped) {
		this.alreadyDropped = alreadyDropped;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantiy;
	}
	public void setQuantity(int quantiy) {
		this.quantiy = quantiy;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	@Override
	public String toString(){
		return ""+status+","+quantiy+","+weight+","+alreadyDropped+"";
	} 
}

public class Student {
	
	private String id;
	private String name;
	private String phoneNumber;
	private Plan plan;
	private float moneyCharged = 0;
	private int numOfWashes;
	private DroppedClothes clothes;
	private Hostel hostel;

	public Student(String id, String name, String sphone, Plan plan, Hostel hostel) {

		this.id = id;
		this.name = name;
		this.phoneNumber = sphone;
		this.plan = plan;
		this.hostel = hostel;

		this.moneyCharged += plan.getCost();
		this.numOfWashes = plan.getNumOfWashes();
		this.clothes = new DroppedClothes();
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
	}

	public void setClothes(DroppedClothes clothes){
		this.clothes=clothes;
	}

	//Check later!!!!!!!!!!!!!!!!! (Date and plan extra charges)
	public void dropClothes(int quantity, float weight) throws ClothesAlreadyDroppedException, WeightLimitExceededException, ClothesDroppedOnWrongDayException{
		
		if (!LocalDate.now().getDayOfWeek().name().equals(this.hostel.getDropDay().toUpperCase())){
			throw new ClothesDroppedOnWrongDayException("You cannot drop your laundry today");
		}
		if (clothes.getIsAlreadyDropped()){
			throw new ClothesAlreadyDroppedException("Clothes already dropped");
		}
		if (weight > 2){
			//Handle weight limit exceeded exception separately by including charges
			throw new WeightLimitExceededException("You have exceeded weight limit");
		}
		this.clothes.setQuantity(quantity);
		this.clothes.setWeight(weight);
		clothes.setAlreadyDropped(true);
		clothes.setStatus("Waiting to be picked up"); //Initial status
		this.numOfWashes--;
		LaundroSystem.updateDatabase();
	}

	public void dropClothesWithExtraCharges(int quantity, float weight){
		this.clothes.setQuantity(quantity);
		this.clothes.setWeight(weight);
		clothes.setAlreadyDropped(true);
		clothes.setStatus("Waiting to be picked up"); //Initial status
		this.numOfWashes--;
		this.moneyCharged += (weight - 2)*25;
		LaundroSystem.updateDatabase();
	}

	public void addAdditonalWashes(int numOfWashes){
		this.moneyCharged += numOfWashes*20;
		this.numOfWashes += numOfWashes;
		this.hostel.setHostelRevenue(numOfWashes*20);
		LaundroSystem.updateDatabase();
		LaundroSystem.fillHostelDetails(LaundroSystem.hostelList);
	}

	public void registerForLaundro() throws UserEntryError{
		if (LaundroSystem.getDataBase().containsKey(this.id)){
			throw new UserEntryError("This ID is already registered");
		}
		else {
			LaundroSystem.addStudent(this);	
			System.out.println("Details:");
			System.out.println(this);
			System.out.println("Your alloted drop day is " + this.getHostel().getDropDay());
		}
	}

	public String getClothesStatus() throws ClothesNotDroppedException {
		if (!clothes.getIsAlreadyDropped()) throw new ClothesNotDroppedException("Clothes not dropped");
		return clothes.getStatus();
	}

	//To implement
	//What is price per laundry
	//What about status?
	public void getStudentInfo(){
		
	}

	public void recieveClothes(){
		if (clothes.getStatus().equals("On Delivery")){
			System.out.println("Success");
			clothes.setAlreadyDropped(false);
			clothes.setStatus("Delivered");
		}
		else{
			System.out.println("Clothes not reached");
		}
		LaundroSystem.updateDatabase();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", plan=" + plan
				+ ", moneyCharged=" + moneyCharged + ", numOfWashes=" + numOfWashes + ", clothes=" + clothes + "]";
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public float getMoneyCharged(){
		return moneyCharged;
	}

	public int getNumOfWashes(){
		return numOfWashes;
	}

	public DroppedClothes getClothes() {
		return clothes;
	}

}
