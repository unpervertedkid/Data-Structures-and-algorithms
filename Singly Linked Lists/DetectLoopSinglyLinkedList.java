package linkedLists;

public class DetectLoopSinglyLinkedList {
	
		
	//Node head
	private Node head;
	
	//Create node class
	private static class Node{
		//Create data and pointer variables
		private int data;
		private Node next;
		//Node constructor
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//Method to display singly linked list
	public void displayList() {
		//Begin from the head of list
		Node current = head;
		
		while(current!=null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		
		System.out.print("null");
		System.out.println();
		
		
		
	}
	
	
	//Method to detect loop
	public boolean detectLoop() {
		//Create two nodes, one moves slowly(one node at a time, fast moves two nodes at a time
		Node slowptr = head;
		Node fastptr = head;
		
		//Create loop to detect loop
		while(fastptr!=null && fastptr.next!=null) {
			fastptr = fastptr.next.next;
			slowptr = slowptr.next;
			
			if(slowptr==fastptr) {
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		
		//Create a Singly linked List
		DetectLoopSinglyLinkedList singlyLinkedList = new DetectLoopSinglyLinkedList();
		
		//List with loop
		//Assign head of loop
		singlyLinkedList.head = new Node(1);
		
		//Create other nodes
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(5);
		Node sixth = new Node(6);
		
		//Link the nodes but create a loop(Intentional)
		singlyLinkedList.head.next =second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		//Loop
		sixth.next = second;
		
		//List without loop
		DetectLoopSinglyLinkedList singlyLinkedList2 = new DetectLoopSinglyLinkedList();
		
		//Assign head
		singlyLinkedList2.head = new Node(1);
		
		//Create other nodes
		Node second2 = new Node(2);
		Node third2 = new Node(3);
		Node fourth2 = new Node(4);
		Node fifth2 = new Node(5);
		Node sixth2 = new Node(6);
		
		//Link the nodes but without loop
		singlyLinkedList2.head.next =second2;
		second2.next = third2;
		third2.next = fourth2;
		fourth2.next = fifth2;
		fifth2.next = sixth2;
		
		//Display the two lists(Stop the execution as the looped list would run forever
		singlyLinkedList2.displayList();
		//Uncomment the next line if you want to see the loop
		//singlyLinkedList.displayList();
		
		//Detect loops
		System.out.println(singlyLinkedList2.detectLoop() ? "Loop detected!" : "No loop detected");
		System.out.println(singlyLinkedList.detectLoop() ? "Loop detected!" : "No loop detected");
		
		
		
		

	}

}
