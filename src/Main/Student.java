package Main;
import plans.Plan;

class DroppedClothes{
	private String status;
	private int quantiy;
	private float weight;

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
	}

	public void dropClothes(int quantity, float weight){
		this.clothes.setQuantiy(quantity);
		this.clothes.setWeight(weight);
	}

	public void addAdditonalWashes(int numOfWashes){
		this.moneyCharged += numOfWashes*20;
		this.numOfWashes += numOfWashes;
	}

	public void registerForLaundro(){
		LaundroSystem.addStudent(this);

	}


}
