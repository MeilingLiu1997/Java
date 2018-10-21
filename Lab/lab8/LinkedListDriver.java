/**
	a class that create a LinkedList object and test all of its methods.
	@Author Meiling Liu
**/

public class LinkedListDriver {
	public static void main(String[] args){
		LinkedList ll = new LinkedList();
		ll.addAtHead(5);
		ll.addAtHead(2);
		ll.addAtHead(17);
		ll.addAtHead(85);

		// 85, 17, 2, 5
		System.out.println("After adding at the head: " + ll.toString());

		
		ll.addAtTail(100);
		ll.addAtTail(66);
		ll.addAtTail(7777);

		// 85, 17, 2, 5, 100, 66, 7777
		System.out.println("After adding at tail: " + ll.toString());

		ll.set(31, 3);
		ll.set(3, 0);
		ll.set(4, 2);
		// 3, 85, 4, 17, 2, 31, 5, 100, 66, 7777
		System.out.println("After setting: " + ll.toString());

		System.out.println("Print backwards: ");

		// 7777, 66, 100, 5, 31, 2, 17, 4, 85, 3
		ll.printElementsBackwards();

		System.out.println("Sum of the all data: " + ll.sum());


	}
	
}