import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
/**
	This class contain several methods to manipulate a set of images.
	@ author Meiling Liu
**/

public class ImageManipulator {

	/** 
	The method will first create an array of Picture objects, 
	one for each jpg file found in the directory specified.
	**/

	public void removePhotobomb(String directory, String outputfile){
		// 1. read images from directory 
		File[] files = (new File(directory)).listFiles();  

		// count the number of varified picture 
		int i = 0;
		for(File f: files){
			// if end with .jpg, add to picture array
			if(f.getName().endsWith(".jpg")){
				i++;
			}
		}

		Picture[] pictures = new Picture[i];   // create an array of Picture
		
		// add into Picture list
		int j = 0;
		for(File f: files){
			if(f.getName().endsWith(".jpg")){
				pictures[j] = new Picture(f.getAbsolutePath());
				j++;
			}
		}

		// 2. read first pixel of each images

		Picture newPicture = new Picture(pictures[0].getWidth(), pictures[0].getHeight());   // new Picture to store the result

		// create a new list to store rgb vlaues.
	    int[] red = new int[pictures.length];
	    int[] green = new int[pictures.length];
	    int[] blue = new int[pictures.length];
	    

		for(int w = 0; w < pictures[0].getWidth(); w++) {
	        for(int h = 0; h < pictures[0].getHeight(); h++) {
	        	int n = 0;
	            for(Picture p: pictures){

	            	// get pixel from each picture
	               	Pixel pixel = p.getPixel(w, h);
		            
		            // for each pixel, add rgb vaules
		            if(n < pictures.length){
						red[n] = pixel.getRed();
						green[n] = pixel.getGreen();
						blue[n] = pixel.getBlue();
						n++;
					}
	            }
	            // sort rgb values
				Arrays.sort(red);
				Arrays.sort(green);
				Arrays.sort(blue);

				// take median
				int medRed = 0;
				int medGre = 0;
				int medBlu = 0;

				if(red.length / 2 == 0){
					medRed = red.length / 2;
				} else{
					medRed = (red.length +1) / 2;
				}
				if(green.length / 2 == 0){
					medGre = green.length / 2;
				} else{
					medGre = (green.length +1) / 2;
				}
			    if(blue.length / 2 == 0){
			    	medBlu = blue.length / 2;
			    } else{
			    	medBlu = (blue.length +1) / 2;
			    }

		        // create a new pixel for the new image
	          	Pixel newPixel = new Pixel();
		
	          	// set new pix pixel to mdedian
		        newPixel.setRed(red[medRed]);
		        newPixel.setGreen(green[medGre]);
	            newPixel.setBlue(blue[medBlu]);

	            newPicture.setPixel(w, h, newPixel);
            }
		}

    	// 3. store into outputfile
		newPicture.store(outputfile);       

	}

	/**
	The method will create a new image of the same size that is zoomed in to the middle of the original image.
	**/
	
	public void zoomMiddle(String inputfile, String outputfile){
		Picture originalP = new Picture(inputfile);
		int width = originalP.getWidth();
		int height = originalP.getHeight();
		
		if(width /2 != 0){
			width = (int)width -1;
		}
		
		if(height /2 != 0){
			height = (int)height -1;
		}
		Picture newPicture = new Picture(width, height);

		int x = 0;
		for(int w = width/4; w < (3*width)/4; w++){
			
			int y = 0;
			for(int h = height/4; h < (3*height)/4; h++){
				
				Pixel oldPixel = originalP.getPixel(w, h); // at (w, h); color

				// 0.0
				newPicture.setPixel(x, y, oldPixel);
				// 1,0
				newPicture.setPixel(x+1, y, oldPixel);
				// 0,1
				newPicture.setPixel(x, y+1, oldPixel);
				// 1,1
				newPicture.setPixel(x+1, y+1, oldPixel);
				y+=2;
				
			}
			x += 2;
		}
		
		newPicture.store(outputfile); 

	}

	/**
	divides the image in the inputfile into 9 subsquares 
	and then reassigns 8 of those subsquares into random locations
	**/
	public void eightSquares(String inputfile, String outputfile){
		if(!inputfile.endsWith(".jpg")){
			System.out.println("Please upload the image with \".jpg\"");
			System.exit(1);
		}

		Picture inputP = new Picture (inputfile);
		int width = inputP.getWidth();
		int height = inputP.getHeight();

		if(width %3 != 0){
			width = (int)width -1;
		}
		
		if(height %3 != 0){
			height = (int)height -1;
		}

		// Create 9 divided images for storing
		Picture divided1 = new Picture(width/3, height/3);
		Picture divided2 = new Picture(width/3, height/3);
		Picture divided3 = new Picture(width/3, height/3);
		Picture divided4 = new Picture(width/3, height/3);
		Picture divided5 = new Picture(width/3, height/3);
		Picture divided6 = new Picture(width/3, height/3);
		Picture divided7 = new Picture(width/3, height/3);
		Picture divided8 = new Picture(width/3, height/3);
		Picture divided9 = new Picture(width/3, height/3);


		//Choose not repeat random number, and then add into a list

		ArrayList<Picture> randomList = new ArrayList<Picture>();

		randomList.add(divided1);
		randomList.add(divided2);
		randomList.add(divided3);
		randomList.add(divided4);
		randomList.add(divided5);
		randomList.add(divided6);
		randomList.add(divided7);
		randomList.add(divided8);

/**
		Adding into 9 seperate picutures
**/
		for(int w = 0; w < width/3; w++){
			for(int h = 0; h < height/3; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided1.setPixel(w, h, oldPixel);
			}

			for(int h = height/3; h < 2*height/3; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided2.setPixel(w, (h - height/3), oldPixel);
			}

			for(int h = 2*height/3; h < height; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided3.setPixel(w, (h - 2*height/3), oldPixel);
			}

		}

		for(int w = width/3; w < 2*width/3; w++){
			for(int h = 0; h < height/3; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided4.setPixel(w - width/3, h, oldPixel);
			}

			for(int h = height/3; h < 2*height/3; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided5.setPixel(w - width/3, (h - height/3), oldPixel);
			}

			for(int h = 2*height/3; h < height; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided6.setPixel(w - width/3, h - 2*height/3, oldPixel);
			}
		}

		for(int w = 2*width/3; w < width; w++){
			for(int h = 0; h < height/3; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided7.setPixel(w - 2*width/3, h, oldPixel);
			}

			for(int h = height/3; h < 2*height/3; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided8.setPixel(w - 2*width/3, (h - height/3), oldPixel);
			}

			for(int h = 2*height/3; h < height; h++){
				Pixel oldPixel = inputP.getPixel(w, h); // at (w, h); color
				divided9.setPixel(w - 2*width/3, h - 2*height/3, oldPixel);
			}
		}

/**
		Random Picture arraylist
**/
		// // print original list
		// for(int j = 0; j < randomList.size(); j++){
		// 	System.out.println(randomList.get(j));
		// }

		Random r = new Random();  //create object of type Random
		

		for(int i = 0; i < randomList.size(); i++){
			int j = r.nextInt(8);
			Picture temp = randomList.get(i);
			randomList.set(i, randomList.get(j));
			randomList.set(j, temp);
		}


		// // after swaping
		// for(int j = 0; j < randomList.size(); j++){
		// 	System.out.println(randomList.get(j));
		// }

/**
		Combining parts into newPicture
**/
		Picture newPicture = new Picture(width, height);

		// Assume lower right part is divided9, don't remove randomly

		for(int w = 0; w < width/3; w++){
			for(int h = 0; h < height/3; h++){
				Pixel pixel = randomList.get(0).getPixel(w, h);
				newPicture.setPixel(w, h, pixel);
			}

			for(int h = height/3; h < 2*height/3; h++){
				Pixel pixel = randomList.get(1).getPixel(w, h-height/3);
				newPicture.setPixel(w, h, pixel);
			}

			for(int h = 2*height/3; h < height; h++){
				Pixel pixel = randomList.get(2).getPixel(w, h-2*height/3);
				newPicture.setPixel(w, h, pixel);
			}
		}

		for(int w = width/3; w < 2*width/3; w++){
			for(int h = 0; h < height/3; h++){
				Pixel pixel = randomList.get(3).getPixel(w - width/3, h);
				newPicture.setPixel(w, h, pixel);
			}

			for(int h = height/3; h < 2*height/3; h++){
				Pixel pixel = randomList.get(4).getPixel(w - width/3, h-height/3);
				newPicture.setPixel(w, h, pixel);
			}

			for(int h = 2*height/3; h < height; h++){
				Pixel pixel = randomList.get(5).getPixel(w - width/3, h-2*height/3);
				newPicture.setPixel(w, h, pixel);
			}
		}

		for(int w = 2*width/3; w < width; w++){
			for(int h = 0; h < height/3; h++){
				Pixel pixel = randomList.get(6).getPixel(w - 2*width/3, h);
				newPicture.setPixel(w, h, pixel);
			}

			for(int h = height/3; h < 2*height/3; h++){
				Pixel pixel = randomList.get(7).getPixel(w - 2*width/3, h-height/3);
				newPicture.setPixel(w, h, pixel);
			}

			for(int h = 2*height/3; h < height; h++){
				Pixel pixel = new Pixel();
				pixel.setRed(0);
				pixel.setBlue(0);
				pixel.setGreen(0);

				newPicture.setPixel(w, h, pixel);
			}
		}
		// store into outputfile
		newPicture.store(outputfile); 
	}


}


