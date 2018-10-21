/**
	This driver class will accept a directory as input at the command line. The directory will contain multiple jpg image files.
	@ author Meiling Liu 
**/

public class ImageDriver{
	public static void main(String[] args) 
	{
		//verify command line argument provided
		//If the file name parameter is not present, print an error message and exit the program.
		if(args.length != 1) {					
			System.out.println("Please follow this direction: java <your driver class here> /<Put your image files here>");
			System.exit(1);				
		}

		// Create an instance of ImageManipulator.
		ImageManipulator im = new ImageManipulator();

		// Invoke the removePhotobomb method passing as input the command line argument and the output filename "nophotobomb.jpg". 
		im.removePhotobomb(args[0],"nophotobomb.jpg");


		// Invoke the zoomMiddle method passing as input "nophotobomb.jpg" as the input filename and "zoomed.jpg" as the output filename. 
		im.zoomMiddle("nophotobomb.jpg", "zoomed.jpg");

		// extra credits here:
		im.eightSquares("nophotobomb.jpg", "eightSquares.jpg");

	}

}