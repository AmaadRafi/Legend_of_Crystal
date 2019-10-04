package project2;

public class Cow {
	
	private int cowID;
	private int totalMilk = 0;
	private int numberOfMilkings = 0;
	private int averageMilking = 0;
	private int currentWeight = 0;
	private int lowestWeight = 0;
	private int temperature = 0;
	private int timeStamp;
	
	public Cow(int cowID, char actionCode, int actionValue, int timeStamp) {
		super();
		this.cowID = cowID;
		this.timeStamp = timeStamp;
		
		doAction(actionCode, actionValue);
	}
	public void doAction(char actionCode, int actionValue) {
		
		switch(actionCode){
		
		case 'W': setWeight(actionValue);
			break;
		case 'M': setMilk(actionValue);
			break;
		case 'T': setTemperature(actionValue);
			break;
		}
	}
	public void setWeight(int value) {
		
		currentWeight = value;
		
		if(lowestWeight > currentWeight) {
			lowestWeight = currentWeight;
		}
		else if(lowestWeight == 0) {
			lowestWeight = currentWeight;
		}
	}
	public void setMilk(int value) {
		
		totalMilk += value;
		numberOfMilkings++;
		
		averageMilking = totalMilk / numberOfMilkings;
	}
	public void setTemperature(int value) {
		temperature = value;
	}
	public int getCowID() {
		return cowID;
	}
	public int getCurrentWeight() {
		return currentWeight;
	}
	public int getLowestWeight() {
		return lowestWeight;
	}
	public int getNumMilkings() {
		return numberOfMilkings;
	}
	public int getAverageMilking() {
		return averageMilking;
	}
	@Override
	public String toString() {
		return cowID + " " + lowestWeight + " " + currentWeight 
				+ " " + averageMilking;
	}
}
