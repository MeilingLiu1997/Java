/**
	A class providing ArrayList-like functionality for a list of String objects.
	Author: @Meiling Liu.
**/
public class StringList {

	//declare data members to hold an array of strings and an
	private String[] strings;
	//int to keep track of the number of items in the list
	private int count;


	/**
		A constructor that takes no input and instantiates a new
		String[] of size 10.
	**/
	public StringList() {  // constructor

		this.count = 0;
		this.strings = new String[10];

	}

	/**
		A constructor that takes a size and instantiates a new
		String[] of size size.
	**/
	public StringList(int size) {
		this.count = 0;
		this.strings = new String[size];
	}

	/**
		When the space in array not enough,
		resize the space in array,
		create a new string list, and copy data in it.
	**/
	private void resize(){

		//create an array that is larger (2x)
		String[] tmpStrings = new String[count*2];

		//copy everything over
		for(int i = 0; i < count; i++){
			tmpStrings[i] = strings[i];

		}
		//move reference to new array
		strings = tmpStrings;

	}

	/**
		Adds the new item s to the end of the array 
		and returns true. In case the array is full, 
		it will be resized by creating new array of 
		twice the size and copying all elements to 
		the new array.
	**/
	public void add(String s)  {
		// if the array is full, resize
		if(count == strings.length){
			resize();
		}

		strings[count] = s;
		
		count++;

	}
	
	/**
		Adds the new item to the array at the location 
		specified by index, in case the array is full, 
		it will be resized by creating new array of 
		twice the size and copying all elements to the
		new array.
	**/
	public void add(int index, String s) {
		// if the array is full, resize
		if(count == strings.length){
			resize();
		}

		if(index <= count){
			for(int i = count; i > index;i--){   //create a space for position index
				strings[i] = strings[i-1];
			}
			strings[index] = s;
			count++;
		}

	}

	/**
		Returns a string representation of the array.
		Following is an example of the expected format:
		{A,B,C,D,E}
		For full credit your solution must iterate over
		the array and build the string. 
	**/
	public String toString() {
		String returnVal = "";

		if(count != 0){
			returnVal += strings[0]; //record first item
			for(int i = 1; i < count; i++){

				returnVal += "," + strings[i];  // show "," and next item
			}
		}
		returnVal = "{" + returnVal + "}";
		return returnVal;	
	}


	/**
		Returns true if the array contains the string s
		and false otherwise.
	**/
	public boolean contains(String s) {
		for(int i = 0; i < count; i++){
			if(s.equals(strings[i])){
				return true;
			}	
		}
		return false;
	}

	/**
		Returns true if there are no elements in the array
		and false otherwise.
	**/
	public boolean isEmpty() {
		if(count == 0){ 
			return true;
		}
		return false;
	}

	/**
		Returns the number of elements in the array. Note this
		is not the total number of spaces in the array, but 
		the total number of valid elements.
	**/
	public int size() {
		return count;
	}

	/**
		Returns the first index of the given String,
		or -1 if not found.
	**/
	public int indexOf(String s) {
		for(int i = 0; i < count; i++){
			if(s.equals(strings[i])){
				return i;
			}
		}
		return -1;
	}

	/**
		Returns the last index of the given String, 
		or -1 if not found.
	**/
	public int lastIndexOf(String s) {
		for(int i = count-1; i >= 0; i--){
			if(s.equals(strings[i])){
				return i;
			}
		}
		return -1;
	}

	/**
		Returns the String at the given index.
		Returns null if index is out of range.
	**/
	public String get(int index) {
		if(index < count){
			return strings[index];
		}
		return null;
	}


	/**
		Removes the item at the given index and returns it.
		Returns null if index is out of range.
	**/
	public String remove(int index) {
		if(index < count) {
			String removeItem = strings[index];
			//move items up
			for(int i = index; i < count - 1; i++) {
				strings[i] = strings[i+1];
			}
			count--;
			return removeItem;
		}
		return null;
	}

	/**
		Removes the first occurance of the given item.
		Returns true if successful and false otherwise.
	**/
	public boolean remove(String s) {
		for(int i = 0; i < count; i++){
			if(s.equals(strings[i])){
				remove(i);
				return true;
			}
		}
		return false;
	}

	/**
		Replaces the element at index with the given string. 
		Returns null if index is out of range.
		Returns the item replaced.
	**/	
	public String set(int index, String s) {
		if(index < count){
			String originalItem = strings[index];
			strings[index] = s;
			return originalItem; 
		}
		return null;
	}


}