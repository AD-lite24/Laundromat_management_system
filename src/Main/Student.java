package Main;
import plans.Plan;

class ClothesAlreadyDroppedException extends Exception{
	public ClothesAlreadyDroppedException(String message){
		super(message);
	}
}

class WeightLimitExceededException extends Exception{
	public WeightLimitExceededException(String message){
		super(message);
	}
}

class DroppedClothes{
	private String status;
	private int quantiy;
	private float weight;
	private boolean alreadyDropped = false;

	public boolean isAlreadyDropped() {
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

	public Student(int id, String name, long phoneNumber, Plan plan) {

		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.plan = plan;

		this.moneyCharged += plan.getCost();
		this.numOfWashes = plan.getNumOfWashes();
		this.clothes = new DroppedClothes();
	}

	public void dropClothes(int quantity, float weight) throws ClothesAlreadyDroppedException, WeightLimitExceededException{
		if (clothes.isAlreadyDropped()){
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
	}

	public void registerForLaundro(){
		LaundroSystem.addStudent(this);	
	}

	public String getClothesStatus(){
		return clothes.getStatus();
	}

	//To implement
	public void getStudentInfo(){

	}

}
