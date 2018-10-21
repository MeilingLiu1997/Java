/**
	A class that test class Counter

	@author Meiling Liu
**/

public class CounterDriver
{
	public static void main (String[] args){

		// creates two Counter objects and tests their methods.
		Counter test1 = new Counter();
		Counter test2 = new Counter();

		// call method
		// test click
			// call click (test1)
			test1.click();
			// call getCount (both test1 & test2) and print result
			System.out.println("After one click on test1: " + test1.getCount());
			System.out.println("Original counter on test2: " + test2.getCount());
			// call click
			test2.click();
			// call click
			test2.click();
			// print result getCount
			System.out.println("No click on test1: " + test1.getCount());
			System.out.println("After two clicks on test2: " +test2.getCount());
		// test reset
			// call reset
			test2.reset();
			System.out.println("No reset on test1: " + test1.getCount());
			System.out.println("Reset test2: " + test2.getCount());

	}
}