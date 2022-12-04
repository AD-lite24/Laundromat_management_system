package Main;
import hostel.Hostel;
import plans.Plan;

import java.io.Serializable;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;


import Exceptions.*;


class UserEntryError extends Exception {
	public UserEntryError(String message){
		super(message);
	}
}

class DroppedClothes implements Serializable{
	private String status;
	private int quantiy;
	private float weight;
	private boolean alreadyDropped = false;
	private float costPerLaundry = 0;

	public DroppedClothes(float costPerLaundry){
		this.costPerLaundry = costPerLaundry;
	}

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
	public int getQuantiy() {
		return quantiy;
	}
	public void setQuantiy(int quantiy) {
		this.quantiy = quantiy;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getCostPerLaundry() {
		return costPerLaundry;
	}
	public void setCostPerLaundry(int costPerLaundry) {
		this.costPerLaundry = costPerLaundry;
	}
}

public class Student implements Serializable{
	
	private String id;
	private String name;
	private String phoneNumber;
	private Plan plan;
	private float moneyCharged = 0;
	private int numOfWashes;
	private Map<LocalDate, DroppedClothes> clothes;
	private Hostel hostel;

	public Student(String id, String name, String sphone, Plan plan, Hostel hostel) {

		this.id = id;
		this.name = name;
		this.phoneNumber = sphone;
		this.plan = plan;
		this.hostel = hostel;

		this.moneyCharged += plan.getCost();
		this.numOfWashes = plan.getNumOfWashes();
		this.clothes = new HashMap<>();
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
		LaundroSystem.writeToDatabaseFile();
		LaundroSystem.writeToHostelFile();
	}

	public Hostel getHostel() {
		return hostel;
	}

	public void setHostel(Hostel hostel) {
		this.hostel = hostel;
		LaundroSystem.writeToDatabaseFile();
		LaundroSystem.writeToHostelFile();
	}

	//Check later!!!!!!!!!!!!!!!!! (Date and plan extra charges)
	public synchronized void dropClothes(int quantity, float weight, LocalDate date) throws ClothesAlreadyDroppedException, WeightLimitExceededException, ClothesDroppedOnWrongDayException{
		
		if (!date.getDayOfWeek().name().equals(this.hostel.getDropDay().toUpperCase())){
			throw new ClothesDroppedOnWrongDayException("You cannot drop your laundry today");
		}
		if (clothes.get(date).getIsAlreadyDropped()){
			throw new ClothesAlreadyDroppedException("Clothes already dropped");
		}
		if (weight > 2){
			//Handle weight limit exceeded exception separately by including charges
			throw new WeightLimitExceededException("You have exceeded weight limit");
		}

		clothes.put(date, new DroppedClothes(this.plan.getCost()/this.plan.getNumOfWashes()));
		this.clothes.get(date).setQuantiy(quantity);
		this.clothes.get(date).setWeight(weight);
		clothes.get(date).setAlreadyDropped(true);
		clothes.get(date).setStatus("Waiting to be picked up"); //Initial status
		this.numOfWashes--;
		LaundroSystem.writeToDatabaseFile();
		LaundroSystem.writeToHostelFile();
	}

	public synchronized void dropClothesWithExtraCharges(int quantity, float weight, LocalDate date){
		this.clothes.put(date, new DroppedClothes(this.plan.getCost()/this.plan.getNumOfWashes() + (weight -2)*25));
		this.clothes.get(date).setQuantiy(quantity);
		this.clothes.get(date).setWeight(weight);
		clothes.get(date).setAlreadyDropped(true);
		clothes.get(date).setStatus("Waiting to be picked up"); //Initial status
		this.numOfWashes--;
		this.moneyCharged += (weight - 2)*25;
		this.hostel.setHostelRevenue((weight - 2)*25);
		LaundroSystem.writeToDatabaseFile();
		LaundroSystem.writeToHostelFile();
	}

	public void addAdditonalWashes(int numOfWashes){
		this.moneyCharged += numOfWashes*20;
		this.numOfWashes += numOfWashes;

		this.hostel.setHostelRevenue(numOfWashes*20);
		LaundroSystem.writeToDatabaseFile();
		LaundroSystem.writeToHostelFile();
	}

	public synchronized void registerForLaundro() throws UserEntryError{
		if (LaundroSystem.getDataBase().containsKey(this.id)){
			throw new UserEntryError("This ID is already registered");
		}
		else {
			LaundroSystem.addStudent(this);	//Data is being written to file in addStudent method
			System.out.println("Details:");
			System.out.println(this);
			System.out.println("Your alloted drop day is " + this.getHostel().getDropDay());
		}
	}

	public String getClothesStatus(LocalDate date) throws ClothesNotDroppedException {
		if (clothes.get(date) == null) throw new ClothesNotDroppedException("Clothes not dropped on this date");
		System.out.println("testing");
		return clothes.get(date).getStatus();
	}

	//To implement
	//What is price per laundry
	//What about status?
	public void getStudentInfo(){
		System.out.println("Your total expenses are: " + this.moneyCharged);
		for (Map.Entry<LocalDate, DroppedClothes> entry : clothes.entrySet()){
			System.out.println("Date: " + entry.getKey() + " Status: " + entry.getValue().getStatus() + " Cost: " + entry.getValue().getCostPerLaundry());
		}
	}

	public void recieveClothes(LocalDate date){
		if (clothes.get(date).getStatus().equals("On Delivery")){
			System.out.println("Success");
			clothes.get(date).setAlreadyDropped(false);
			clothes.get(date).setStatus("Delivered");
			LaundroSystem.writeToDatabaseFile();
			LaundroSystem.writeToHostelFile();
		}
		else{
			System.out.println("Clothes not reached");
		}
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

	public DroppedClothes getClothes(LocalDate date) {
		return clothes.get(date);
	}

}
