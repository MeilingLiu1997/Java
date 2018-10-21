/**
	This class maintains a sorted array of Car objects.
	Author @Meiling Liu 
**/

import java.util.Arrays;

public class CarList{

	private Car[] carList; // car object list

	//int to keep track of the number of items in the list
	private int count;

	// constructor
	public CarList(){
		this.count = 0;
		this.carList = new Car[18];
	}

	// If the array is full it will be resized to accommodate a new item.
	private void resize(){
		Car[] tmpCarList = new Car[count+1];

		//copy everything over
		for(int i = 0; i < count; i++){
			tmpCarList[i] = carList[i];

		}
		//move reference to new array
		carList = tmpCarList;
	}

	public void addCar(Car inputCar){
		if(count == carList.length){
			resize();
		}

		if(count == 0){
			carList[0] = inputCar;
		}
		// inserts inputCar into the array in sorted order
		for(int i = count-1; i >= 0; i--){
			if(carList[i].compareTo(inputCar) >= 0){
				carList[i+1] = carList[i];
				if(carList[1] == carList[0]){
					carList[0] = inputCar;
				}
			
			} else if(carList[i].compareTo(inputCar) < 0){
				carList[i+1] = inputCar;
				break;
			}
			
		}


		count++;
	}

	public String toString(){
		String returnVal = "";
		// gas car:
		// Model: VOLVO XC 90 Class: standard SUV Pollution Score: 9 MPG: 25 Cylinders: 4
		// green car:
		// Model: FIAT 500e Class: small car Pollution Score: 10 Fuel Type: Electricity
		for(Car cars: carList){
			returnVal += cars + "\n";
		}

		return returnVal;
	}

	public String toStringGreenCars(){

		// the GreenCar objects in the list where the representation for each Car is of the following format: 
		// Model: BMW i3 BEV Fuel Type: Electricity. 
		// Note, the format for this method is different than that of the toString method.
		String returnVal = "";
		for(Car cars: carList){
			if(cars instanceof GreenCar){	// source: http://stackoverflow.com/questions/7526817/use-of-instance-of-in-java
				returnVal += "Model: " + ((GreenCar)cars).getModel() + " Fuel Type: " + ((GreenCar)cars).getFuelType() + "\n";
			}
		}
		return returnVal;
	}

	public double avgMpg(){
		double sum = 0;
		int num = 0;
		// returns the average MPG across all GasCar objects.
		for(Car cars: carList){
			if(cars instanceof GasCar){
				sum += ((GasCar)cars).getMpg();
				num++;
			}
		}
		return sum/num;
	}

	public double avgMpgByPartialModel(String model){
		double sum = 0;
		int num = 0;
		// the average MPG for all cars with a model containing the partial model query String. 
		// You may use the String contains method in your solution for this method.
		for(Car cars: carList){
			if(cars instanceof GasCar && (((GasCar)cars).getModel()).contains(model)){
				sum += ((GasCar)cars).getMpg();
				num++;
			}
		}
		return sum/num;
	}


	public String[] findClassesByCylinders(int numOfCylinders){
		int count = 0;
		String[] returnVal = new String[100000];
		// returns a String[] containing the vehicle classes with models that have the specified number of cylinders. 
		// For full credit, 
		// the String[] will have no repeated elements (each class will only appear once) 
		// and the length must be large enough to accommodate only the number of valid elements.
		
		for(Car cars: carList){
			if(returnVal.length == count){
				String[] tmpList = new String[count*2];

				for(int i = 0; i < count; i++){
					tmpList[i] = returnVal[i];

				}
				returnVal = tmpList;
			}
		 	if(cars instanceof GasCar && ((GasCar)cars).getNumberCylinders() == numOfCylinders){

		 		if(containClass(((GasCar)cars).getVehicleClass(), returnVal) == false){

					returnVal[count] = ((GasCar)cars).getVehicleClass();
					count++;
				}	
			}
		}

		String[] newReturnVal = new String[count];

		for(int i = 0; i < returnVal.length; i++){
			if(returnVal[i] != null && returnVal[i].length() > 0){
				newReturnVal[i] = "\t" + returnVal[i];
			}
		}
		Arrays.sort(newReturnVal);

		return newReturnVal;
	}

	private boolean containClass(String input, String[] returnVal){
		// if contains, reture true
		for(int i = 0; i < count; i++){

			if(input.equals(returnVal[i])){
				return true;
			}
		}
			return false;

	}

	public String[] findModelsByClassAndMpg(String vehicle, int minMpg){
		int count = 0;
		String[] returnVal = new String[1000];
		
		// returns a String[] containing the models of all vehicles of the specified class that have at least the specified combined MPG. 
		// The String[] may have repeated elements if the same model appears twice in the dataset, 
		// but the the length must be large enough to accommodate only the number of valid elements.
		for(Car cars: carList){

			if(cars instanceof GasCar && ((GasCar)cars).getVehicleClass().equals(vehicle) 
				&& ((GasCar)cars).getMpg() >= minMpg){
				returnVal[count] = ((GasCar)cars).getModel();
				count++;
			}	
		}

		String[] newReturnVal = new String[count];

		for(int i = 0; i < returnVal.length; i++){
			if(returnVal[i] != null && returnVal[i].length() > 0){
				newReturnVal[i] = "\t" + returnVal[i];
			}
		}
		Arrays.sort(newReturnVal);
		for(String s: newReturnVal){
			System.out.println(s);
		}
		return newReturnVal;
	}

}