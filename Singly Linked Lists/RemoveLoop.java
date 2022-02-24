package linkedLists;

public class RemoveLoop {
	
	
	private Node head;
	
	//Node class 
	private static  class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	//Method to display List
	public void display() {
		Node current = head;
		
		while(current!=null) {
			System.out.print(current.data + "-->");
			current = current.next;
		}
		System.out.print("null");
	}
	

	//Method to detect and remove loop
	public void removeLoop() {
		Node slowptr = head;
		Node fastptr = head;
		
		while(fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			
			if(slowptr == fastptr) {
				removeLoopAt(slowptr);
				return;
			}
		}
	}
	private void removeLoopAt(Node slowptr) {
		Node temp = head;
		while(slowptr.next != temp.next) {
			temp = temp.next;
			slowptr = slowptr.next;
		}
		slowptr.next = null;
		
	}

	public static void main(String[] args) {
		
		//Create a singly linked list
		RemoveLoop listLoop = new RemoveLoop();
		
		listLoop.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(6);
		
		//Link the nodes to create a loop (Intentional)
		listLoop.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = third;
		
		
		//Remove loop and print out loop
		listLoop.removeLoop();
		listLoop.display();
		
		
		
		

	}

}
