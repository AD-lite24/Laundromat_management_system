package Main;
import hostel.Hostel;
import plans.Plan;

class ClothesAlreadyDroppedException extends Exception{
	public ClothesAlreadyDroppedException(String message){
		super(message);
	}
}

class ClothesNotDroppedException extends Exception{
	public ClothesNotDroppedException(String message){
		super(message);
	}
}

class WeightLimitExceededException extends Exception{
	public WeightLimitExceededException(String message){
		super(message);
	}
}

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
	
	int id;
	String name;
	long phoneNumber;
	Plan plan;
	int moneyCharged = 0;
	int numOfWashes;
	DroppedClothes clothes;
	Hostel hostel;

	public Student(int id, String name, long phoneNumber, Plan plan, Hostel hostel) {

		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
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
			throw new WeightLimitExceededException("Weight above 2kg");
		}
		this.clothes.setQuantiy(quantity);
		this.clothes.setWeight(weight);
		clothes.setAlreadyDropped(true);

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
				+ ", moneyCharged=" + moneyCharged + ", numOfWashes=" + numOfWashes + ", clothes=" + clothes + "]";
	}

}
