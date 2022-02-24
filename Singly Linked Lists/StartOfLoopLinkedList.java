package linkedLists;



public class StartOfLoopLinkedList {
	
	//Head of Node
	private Node head;
	
	private static class Node{
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//Method to return start of loop
	public Node startOfLoop() {
		Node fastptr = head;
		Node slowptr = head;
		
		while(fastptr!=null && fastptr.next != null) {
			fastptr = fastptr.next.next;
			slowptr = slowptr.next;
			
			if(fastptr == slowptr) {
				return getStartingNode(slowptr);
			}
		}
		return null;
	}
	private Node getStartingNode(Node slowptr) {
		Node temp = head;
		
		while(temp != slowptr) {
			temp = temp.next;
			slowptr = slowptr.next;
		}
		return temp;
	}
	public static void main(String[] args) {
		
		//Create a Singly linked List
		StartOfLoopLinkedList singlyLinkedList = new StartOfLoopLinkedList();
				
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
				//Print beginning of loop
				System.out.println(singlyLinkedList.startOfLoop().data);

	}

}
