package doublylinkedlist;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    //ListNode class
    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        //Constructor for the ListNode class
        public ListNode(int data){
            this.data = data;
        }
    }
    //Constructor for DoublyLinkedList class. Initializes head and tail to null and length to 0
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    //Method to check if list is empty
    public boolean isEmpty(){
        return length == 0;
    }

    //Method to return length of list
    public int Length() {
        return length;
    }
}
