/**
	a class Node that holds an Integer as its data.
	@Author Meiling Liu
**/

public class Node {
	// data memeber
	private Integer data;
	private Node next;


	// construcotr
	public Node(Integer data, Node next){
		this.data = data;
		this.next = next;
	}

	public Node(Integer data){
		this(data, null);
	}


	public Integer getData(){
		return this.data;
	}

	public Node getNext(){
		return this.next;
	}


	public void setNext(Node next){
		this.next = next;
	}
	
}