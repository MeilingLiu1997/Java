/**
	This class will print the shape, 
	where the largest number in the longest row is specified by the input parameter. 
	like below:
	0
	01
	012
	0123
	012
	01
	0
	Author @Meiling Liu
**/
public class NumberPrinter{
	// one to print a single row 
	// and one that is called by main and prints the entire structure.


	// recursion to print number from 0 to n
	public static void passoutNum(int n){
		passoutNum(0,n);
	}

	/**
		A helper method to print the numbers from 0 to n.
	**/
	private static void passoutNum(int start, int end) {
		lindOfNum(0, start);

		if(start == end) {
			//System.out.println(end);
			return;
		}
		//System.out.print(start);
		passoutNum(start + 1, end);
		lindOfNum(0, start);

	}

	public static void lindOfNum(int start, int end){

		if(start == end){
			System.out.println(end);
			return;
		}

		System.out.print(start);
		lindOfNum(start + 1, end);
	}


	public static void main(String[] args){
		if(args.length != 1) {					
			System.out.println("Please follow this direction: java NumberPrinter <int>, for example java NumberPrinter 3.");
			System.exit(1);				
		}
		try {
			int inputNum = Integer.parseInt(args[0]);
			passoutNum(inputNum);
		
		} catch(NumberFormatException nfe) {
			System.out.println("Notify! Here is an Unchecked Exception. Please Enter an Integer.");
			System.out.println(nfe.getMessage());
		
		} catch(Exception e) {
			System.out.println("Notify! Here is an adivice.");
			System.out.println(e.getMessage());
		}

	}
	
}