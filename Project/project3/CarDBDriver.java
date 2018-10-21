import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;


/**
	This class is 
	Author @Meiling Liu
**/


public class CarDBDriver{

	public static void main(String[] args){
		
		CarList list = new CarList();

		//open file
		File inputFile = new File("cars.csv"); //Create a File with the given filename.

		//read in each line of file
		try(Scanner input = new Scanner(inputFile)) {  //Create a new Scanner to read input from the file

			input.useDelimiter(",|\n");    //Specify that that Scanner will useDelimiter(",|\n"). This indicates that the newline character as well as the comma (,) will separate tokens read by the Scanner.

			while(input.hasNext()) { 
				String line = input.nextLine(); // Read in the first line and ignore it.
				String model = input.next(); 
				String displ = input.next();
				String cyl = input.next(); 
				String trans = input.next();
				String drive = input.next();
				String fuel = input.next();
				String certRegion = input.next();
				String stnd = input.next();
				String stndDescription = input.next();
				String underhoodID = input.next();
				String vehClass = input.next();
				int airPollutionScore = input.nextInt();
				String cityMPG = input.next();
				String hwyMPG = input.next();
				String cmbMPG = input.next();
				int greenhouseGasScore = input.nextInt();
				String smartWay = input.next();
				String combCO2 = input.next();

				//	Create a new Car containing the data specified.
				if(fuel.equals("Hydrogen") || fuel.equals("Electricity")){
					Car greenCars = new GreenCar(model, vehClass, airPollutionScore,fuel);
					list.addCar(greenCars);

				} else {
					String[] mpgParts = cmbMPG.split("/");
					Car gasCars = new GasCar(model, vehClass, airPollutionScore, Integer.parseInt(cyl), Integer.parseInt(mpgParts[0]));
					list.addCar(gasCars);
				}
				
			}


		} catch(FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
		}

		System.out.println("All Cars:");


		// Print the result of calling toString on the CarList.
		System.out.println(list.toString());

		// Print "Green Cars - Fuel Type:" followed by a newline.
		System.out.println("Green Cars - Fuel Type:");

		// Print the result of calling toStringGreenCars on the CarList.
		System.out.println(list.toStringGreenCars());

		// Print "Average MPG All:" followed by the result of calling avgMpg on the CarList followed by a newline. 
		// The result should be displayed with exactly two digits after the decimal point.
		System.out.printf("Average MPG All: %3.2f\n", list.avgMpg());
		System.out.println();

		// Print "Average MPG Subaru:" followed by the result of calling avgMpgByPartialModel("SUBARU") on the CarList followed by a newline. 
		// The result should be displayed with exactly two digits after the decimal point.
		System.out.printf("Average MPG Subaru: %3.2f\n", list.avgMpgByPartialModel("SUBARU"));
		System.out.println();

		// Print "Average MPG Toyota:" followed by the result of calling avgMpgByPartialModel("TOYOTA") on the CarList followed by a newline. 
		// The result should be displayed with exactly two digits after the decimal point.
		System.out.printf("Average MPG Toyota: %3.2f\n", list.avgMpgByPartialModel("TOYOTA"));
		System.out.println();

		// Print "Average MPG Ferrari:" followed by the result of calling avgMpgByPartialModel("FERRARI") on the CarList followed by a newline. 
		// The result should be displayed with exactly two digits after the decimal point.
		System.out.printf("Average MPG Ferrari: %3.2f\n", list.avgMpgByPartialModel("FERRARI"));
		System.out.println();

		// Print "Vehicle Classes with 4-Cylinder Cars:" followed by a newline 
		// followed by the result of calling findClassesByCylinders(4) on the CarList. 
		// For each item in the list returned, print a tab followed by the item followed by a newline.
		System.out.println("Vehicle Classes with 4-Cylinder Cars:");
		for(String s: list.findClassesByCylinders(4)){
			System.out.println(s);
		}

		// Print "Vehicle Classes with 6-Cylinder Cars:" followed by a newline 
		// followed by the result of calling findClassesByCylinders(6) on the CarList. 
		// For each item in the list returned, print a tab followed by the item followed by a newline.
		System.out.println("Vehicle Classes with 6-Cylinder Cars:");
		for(String s: list.findClassesByCylinders(6)){
			System.out.println(s);
		}


		// Print "Small SUVs with MPG > 22:" followed by a newline 
		// followed by the result of calling findModelsByClassAndMpg("small SUV", 22) on the CarList. 
		// For each item in the list returned, print a tab followed by the item followed by a newline.
		System.out.println("Small SUVs with MPG > 22:");
		list.findModelsByClassAndMpg("small SUV", 22);
		// for(String s: list.findModelsByClassAndMpg("small SUV", 22)){
		// 	System.out.println(s);
		// }


		// Print "Small Cars with MPG > 35:" followed by a newline 
		// followed by the result of calling findModelsByClassAndMpg("small car", 35) on the CarList. 
		// For each item in the list returned, print a tab followed by the item followed by a newline.
		System.out.println("Small Cars with MPG > 35:");
		// for(String s: list.findModelsByClassAndMpg("small car", 35)){
		// 	System.out.println(s);
		// }
		list.findModelsByClassAndMpg("small car", 35);

	
	}
	
}