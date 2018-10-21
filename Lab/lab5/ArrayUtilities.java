/**
	A class with utility methods for manipulating one and two dimensional
	arrays of characters.
**/
public class ArrayUtilities { 

	/**
		Determines whether the 2D array is square. The array 
		is square if the length of every row is the same. 
		Returns true if the array is square and false
		otherwise. The solution may not make any assumptions about
		the number of rows or columns in original.		
	**/
	public static boolean isSquare(char[][] original) {
		for(int r = 0; r < original.length; r++){	// each row
			if(original.length != original[r].length){	// comparing rows and columns
				return false;
			}
		}
		return true;
	}

	/**
		Converts a two dimensional array of char to a one 
		dimensional array of char. This method may assume
		that all subarrays of the original are of the same
		length.
		Returns the one dimensional array.
		Example input: 
		[['a', 'b', 'c']
		 ['e', 'd', 'f']
		 ['i', 'h', 'g']]
		 Example output:
		 ['a', 'b', 'c', 'e', 'd', 'f', 'i', 'h', 'g']
	**/
	public static char[] to1D(char[][] original) {
		char[] output = new char[original.length * original[0].length]; // array size same as number of rows

		int position = 0;
		for(int r = 0; r < original.length; r++){
			for(int c = 0; c < original[r].length; c++){
				output[position] = original[r][c];
				position++;
			}
		}

		return output;
	}

	/**
		Finds the char with the smallest value in each row
		of the original and returns an array containing the 
		values found. the result at position [0] will be the
		smallest valued char in row 0 of original.
		This method does NOT assume that all subarrays of the
		original are of the same length.
		Example input:
		[['e', 'c', 'f', 'g', 'c', 'e']
		 ['b', 'b', 'b', 'b']
		 ['a', 'd']
		 ['d', 'c', 'b']]
		Example output:
		['c', 'b', 'a', 'b']
	**/
	public static char[] smallestPerRow(char[][] original) {
		char[] output = new char[original.length];
		char smallest;
		for(int r = 0; r < original.length; r++){

			smallest = original[r][0]; // set the first item in each row is smallest

			for(int c = 1; c < original[r].length; c++){

				if(smallest > original[r][c]){
					smallest = original[r][c];
				}
			}
				output[r] = smallest;

		}
		return output;
	}

}



