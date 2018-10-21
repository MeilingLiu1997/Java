/**
	a class that contains main methods
	@Author Meiling Liu
**/
public class LinkedList {

	private Node head;
	private Node tail;
	private int count;

	// - adds a new Node at the head of the list
	public void addAtHead(Integer data){
		//create a node
		Node newNode = new Node(data);

		//set next reference of new node to the first item in the list
		newNode.setNext(head);

		//link together head reference and the new node
		head = newNode;

		//increment count
		count++;

	}

	// - adds a new Node at the tail of the list
	public void addAtTail(Integer data){
		Node newNode = new Node(data);
		newNode.setNext(null);

		Node cur = head;
		while(cur.getNext() != null){
			cur = cur.getNext();
		}
		tail = cur;
		tail.setNext(newNode);
		tail = newNode;
		count++;

	}

	// - returns a string representation of the list
	public String toString() {
		String returnV = "";

		Node cur = head;

		while(cur != null){
			returnV += cur.getData();

			cur = cur.getNext();
						
			if(cur != null){
				returnV += ", ";
			}

		}
		returnV = "{" + returnV + "}";
		return returnV;
	}
	
	// - returns the sum of all Integer data in the list
	public int sum(){
		int sum = 0;

		Node cur = head;

		while(cur != null){

			sum += cur.getData();

			cur = cur.getNext();
		}
		return sum;
	}

	//takes as input a new data item and an index 
	// and sets the data in the Node at index index to be that value. 
	// set(3, 0) would change the data in the first Node in the list to be the value 3. 
	// Note that you cannot access an element by its index 
	// so you will need to find the appropriate Node using a counter variable.
	public void set(Integer data, int index){
		if(index == 0){
			addAtHead(data);
		}
		int counter = 0;

		Node newNode = new Node(data);
		Node cur = head;
		while(cur != null){
			cur = cur.getNext();
			counter++;
			if(counter == index - 1){
				newNode.setNext(cur.getNext());
				cur.setNext(newNode);
				cur = newNode;
			}
		}
	}

	// - prints the list backwards. 
	public void printElementsBackwards(){
		// recursion here

		Node cur = head;
		printElementsBackwards(cur);
		System.out.println();
	}

	// helper method
	public void printElementsBackwards(Node cur){

		if(cur.getNext() != null){
			printElementsBackwards(cur.getNext());
			if(cur != null){
				System.out.print(", ");
			}
		}
		System.out.print(cur.getData());

	}



}