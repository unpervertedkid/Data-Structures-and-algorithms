package doublylinkedlist;

import java.util.NoSuchElementException;

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

    //Method to print From first element to last element
    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null ");

    }

    //Method to print  From Last to first element
    public void displayBackward(){
        if(tail == null){
            return;
        }
        ListNode temp = tail;
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.print("null ");
    }

    //Method to insert Node at beginning on list
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
        tail = newNode;
        }
        else{
            head.previous = newNode;
        }

        newNode.next = head;
        head = newNode;
        length++;
    }

    //Method to insert Node at end of List
    public void insertLast(int value){
        ListNode newNode = new ListNode(value);

        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
    }

    //Method to delete first Node in a dll
    public void deleteFirst(){

        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        if(head==tail){
            tail = null;
        }
        else{
           head.next.previous = null;

        }

        head = head.next;
        temp.next  = null;
    }

    //Method to delete last Node in dll
    public void deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        ListNode temp = tail;

        if(tail==head){
            head = null;
        }
        else{
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.next = null;
    }

    public static void main(String[] args) {

        //Create new doubly linked list
        DoublyLinkedList dll = new DoublyLinkedList();

        //Add elements from front
        dll.insertFirst(5);
        dll.insertFirst(4);
        dll.insertFirst(3);
        dll.insertFirst(2);
        dll.insertFirst(1);

        //display list both forward and backwards
        dll.displayForward();
        dll.displayBackward();


        //Add elements from back
        dll.insertLast(6);
        dll.insertLast(7);
        dll.insertLast(8);
        //display list both forward and backwards
        System.out.println("");
        dll.displayForward();
        dll.displayBackward();
    }
}
