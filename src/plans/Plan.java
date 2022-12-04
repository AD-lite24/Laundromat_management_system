package plans;

import java.io.Serializable;

//No subclasses of Plan, we will create objects for all plans in the main method
public class Plan implements Serializable {
	
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getNumOfWashes() {
		return numOfWashes;
	}

	public void setNumOfWashes(int numOfWashes) {
		this.numOfWashes = numOfWashes;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public int getQuantityPerDrop() {
		return quantityPerDrop;
	}

	public void setQuantityPerDrop(int quantityPerDrop) {
		this.quantityPerDrop = quantityPerDrop;
	}

	int cost;
	int numOfWashes;
	String codeName;
	int quantityPerDrop;
	
	public Plan(int cost, int numOfWashes, String codeName, int quantityPerDrop) {
		this.cost = cost;
		this.numOfWashes = numOfWashes;
		this.codeName = codeName;
		this.quantityPerDrop = quantityPerDrop;
	}
	
}

