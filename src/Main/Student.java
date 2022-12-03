package Main;
import hostel.Hostel;
import plans.Plan;
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

	//Check later!!!!!!!!!!!!!!!!! (Date and plan extra charges)
	public void dropClothes(int quantity, float weight) throws ClothesAlreadyDroppedException, WeightLimitExceededException{
		

		if (clothes.getIsAlreadyDropped()){
			throw new ClothesAlreadyDroppedException("Clothes already dropped");
		}
		if (weight > 2){
			//Handle weight limit exceeded exception separately by including charges
			throw new WeightLimitExceededException("You have exceeded weight limit");
		}
		this.clothes.setQuantiy(quantity);
		this.clothes.setWeight(weight);
		clothes.setAlreadyDropped(true);
		clothes.setStatus("Waiting to be picked up"); //Initial status
		this.numOfWashes--;
	}

	public void dropClothesWithExtraCharges(int quantity, float weight){
		this.clothes.setQuantiy(quantity);
		this.clothes.setWeight(weight);
		clothes.setAlreadyDropped(true);
		clothes.setStatus("Waiting to be picked up"); //Initial status
		this.numOfWashes--;
		this.moneyCharged += (weight - 2)*25;
	}

	public void addAdditonalWashes(int numOfWashes){
		this.moneyCharged += numOfWashes*20;
		this.numOfWashes += numOfWashes;

		this.hostel.setHostelRevenue(numOfWashes*20);
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
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", plan=" + plan
				+ ", moneyCharged=" + moneyCharged + ", numOfWashes=" + numOfWashes + ", clothes=" + clothes + "hostel= " + this.hostel.getName() + "]";
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

	public DroppedClothes getClothes() {
		return clothes;
	}

}
