package linkedLists;

public class SinglyLinkedList {
	
	//Create the head(Instance of ListNode class)
	private ListNode head;
	
	//ListNode Class
	private static class ListNode{
		//Singly linked has the data and the pointer(next)
		private int data;
		private ListNode next;
		
		//constructor to initialize the pointer to null and assign data 
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	
	//Method to insert node in the beginning of a singlylinkedlist
	public void insert(int value) {
		ListNode newNode  = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	//Method to insert node in the end of a singlylinkedlist
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		
		if(head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		
		while(null!=current.next) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	//Method to insert value at any position in SinglyLinkedList
	public void insert(int position, int data) {
		//Create a new node
		ListNode newNode = new ListNode(data);
		
		//If position is 1, insert node in first position
		if(position == 1) {
			newNode.next = head;
			newNode = head;
		}
		
		//Else traverse the list and insert in position
		else {
			ListNode previous = head;
			int count = 1;
			while(count < (position-1)) {
				previous = previous.next;
				count++;
			}
			
			ListNode current = previous.next;
			newNode.next = current;
			previous.next = newNode;
		}
	}
	
	//Method to delete First Node
	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		}
		//Temporary node to hold head
		ListNode temp = head;
		//Assign head to next element
		head = head.next;
		
		//Delete the temp node by assigning its pointer to null
		temp.next  = null;
		
		//return the deleted node
		return temp;
	}
	
	//Method to delete last node
	public ListNode deleteLast() {
		if(head==null||head.next == null) {
			return head;
		}
		//Assign node to hold current node
		ListNode current = head;
		//Assign node to have previous node
		ListNode previous = null;
		
		//Traverse list to the end node
		while(current.next!=null) {
			previous = current;
			current = current.next;
		}
		
		//Asign the pointer of the node before the last node(previous) to null
		previous.next = null;
		
		//Return  the last node(current)
		
		return current;
		
		
	}
	//Method to traverse and print elements of a SinglyLinkedList
	public void display() {
		//Begin from the head
		ListNode current = head;
		//If current pointer is not null, we move on and stop otherwise
		System.out.println();
		while(current!=null) {
			//print the data of current node
			System.out.print(current.data + " --> ");
			//Move to next node
			current = current.next;
		}
		
		//When the pointer is null, print null
		System.out.print("null");
		
	}
	
	
	
	//Method to delete element at any position
	public ListNode delete(int position) {
		
		ListNode current;
		//If element to be deleted is 1(head) assign head to
		//next element and return the deleted element
		if(position == 1) {
			current = head;
			head = head.next;
			return current;
		}
		else {
			//Assign node to a previous list node
			ListNode previous = head;
			int count = 1;
			//Traverse till one position behind the element to be deleted
			while(count<position-1) {
				previous = previous.next;
				count++;
			}
			//Assign element to be deleted to next
			current = previous.next;
			/*Assign pointer of element before element to be deleted to the element 
			after the element to be deleted
			*/
			previous.next = current.next;
			//Return deleted element
			return current;
		}
	}
	
	//Method to search singly linked list
	public boolean search(int searchKey) {
		//Create a ListNode Current and assign it to null
		ListNode current  = head;
		
		//Traverse list to end of list
		while(current!=null) {
			//Compare data of current node to key and return true on match
			if(current.data == searchKey) {
				return true;
			}
			//Move to next element
			current = current.next;
		}
		//Return false if the whole list does not contain key
		return false;
	}
	
	//Method to find length of singlylinkedlist
	public int length() {
		
		//Return 0 if first head is null
		if(head == null) {
			return 0;
		}
		
		//Initialize count to 0
		int count = 0;
		
		//Begin from the head
		
		ListNode current = head;
		
		//Iterate until pointer is null(last element)
		while(current != null) {
			count++;
			current = current.next;
		}
		//Return the count
		return count;
		
		
	}
	
	//Method to reverse List
	public ListNode reverse() {
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while(current!=null) {
			//Assign next to node after current
			next =current.next;
			//Assign the current node to point to previous node
			current.next = previous;
			//Assign the value of current node to the previous node
			previous = current;
			//Move to next node 
			current = next;
		}
		return previous;
	}
	
	//Method to get middle node
	public ListNode getMiddleNode() {
		//Create 2 nodes and assign them to head
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		/*
		 * One node slow pointer moves one node at a time
		 * FastPointer moves 2 nodes at a time
		 * The fast Pointer will reach the end when the slow pointer is in the middle
		 * The fast pointer is then null and the while loops breaks
		 */
		
		while((fastPointer!=null)&& (slowPointer!=null)) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	
	}
	
	
	//Find nth node from the end of list
	/*
	 * Create two nodes pointing to head
	 * Move the ref  pointer nth number of nodes forward
	 * Move both nodes forward till the ref pointer is at the end(points to null)
	 */
	public ListNode getnthNodeEnd(int count) {
		//Create 2 nodes
		ListNode mainptr = head;
		ListNode refptr = head;
		
		int counter = 0;
		//Move pointer to nth position
		while(counter<count) {
			refptr = refptr.next;
			counter++;
		}
		
		//Move both pointers till refptr is null(end of list)
		while(refptr!=null) {
			refptr = refptr.next;
			mainptr = mainptr.next;
		}
		//Return main pointer
		return mainptr;
		
	}
	
	//Main class
	public static void main(String[] args) {
		
		//Create an object of SinglyLinkedList
		SinglyLinkedList first = new SinglyLinkedList();
//		
//		//Assign the first element 
//		first.head = new ListNode(10);
//		
//		//Create the other list elements
//		ListNode second = new ListNode(20);
//		ListNode third = new ListNode(30);
//		ListNode fourth = new ListNode(40);
//		
//		//Assign the pointers to  the next item in list
//		first.head.next = second;// 10--->20
//		second.next = third;//20--->30
//		third.next = fourth;//30--->40
//		
//		// 10--->20--->30--->40--->null
//		
//		//Print the list
//		first.display();
//		
//		//Print length
//		System.out.println("\nLenght is : " + first.length());
//		
//		//Insert elements
//		first.insert(1);
//		first.insert(23);
//		first.insert(34);
//		first.insert(67);
//		first.insert(78);
//		
		//Insert elements at the end
		first.insertLast(10);
		first.insertLast(20);
		first.insertLast(30);
		first.insertLast(40);
		
		
		//Insert element in third and fifth position
		first.insert(3, 7);
		first.insert(5,20);
		//Display the singlylinkedlist
		first.display();
		
//		//Delete first node
//		System.out.println("\nDeleting first node: " + first.deleteFirst().data);
//		
//		//Print the list
//		first.display();
//		
//		//Delete last node
//		System.out.println("\nDeleting last node: " + first.deleteLast().data);
//		
//		//Print the list
//		first.display();
//		
//		//Delete third
//		System.out.println("\nDeleting: " + first.delete(1).data);
//		
//		//Print list
//		first.display();
//		
//		//Search for element
//		int searchKey = 70;
//		System.out.println("\nSearching :" + searchKey);
//		if(first.search(searchKey)) {
//			System.out.print("Found");
//		}
//		else {
//			System.out.print("Not found!");
//		}
		//Create a new SinglyLinked list
		SinglyLinkedList reversedFirst = new SinglyLinkedList();
		
		//Assign head to the head of the reversed first list
		reversedFirst.head = first.reverse();
		
		//Print the list
		reversedFirst.display();
		
		//Find middle Node of reversed list
		System.out.println("\nMiddle node: " + reversedFirst.getMiddleNode().data);
		
		//Find nth node from the end
		int position = 3;
		
		System.out.println("The node at position " + position + " from the end is " + reversedFirst.getnthNodeEnd(position).data);
	}


}

