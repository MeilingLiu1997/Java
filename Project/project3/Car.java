/**
	This class is a base class
	Author @Meiling Liu
**/
public abstract class Car implements Comparable<Car>{

	// properties
	protected String model;        	// column Model
	protected String vehicleClass;	// column Veh Class
	protected int pollutionScore;	// column Air Pollution Score

	// contributor
	public Car(String model, String vehicleClass, int pollutionScore){
		this.model = model;
		this.vehicleClass = vehicleClass;
		this.pollutionScore = pollutionScore;
	}

	public String getModel(){
		return this.model;
	}

	public String getVehicleClass(){
		return this.vehicleClass;
	}

	public int getPollutionScore(){
		return this.pollutionScore;
	}

	public String toString(){
		return "Model: " + this.model + 
				" Class: " + this.vehicleClass + 
				" Pollution Score: " + this.pollutionScore;
	}
	/**
	Comparable method
	Car objects are sorted first by pollution score. 
	If two Car objects have the same pollution score then they will be sorted by model.
	**/

	public int compareTo(Car input){
		if(this.pollutionScore == input.getPollutionScore()){
			// sort by model
			int modelResult = this.model.compareTo(input.getModel());
			return modelResult;

		} else {
			return (this.pollutionScore - input.getPollutionScore());
		}
	}

}




