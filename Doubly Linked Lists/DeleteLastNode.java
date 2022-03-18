package doublylinkedlist;

public class DeleteLastNode {

    public static void main(String[] args) {
        DoublyLinkedList dll3 = new DoublyLinkedList();
        dll3.insertFirst(1);
        dll3.insertLast(2);
        dll3.insertLast(3);
        dll3.insertLast(4);

        //display list both forward and backwards Before deleting last element
        System.out.println("List before  deleting last Node");
        dll3.displayForward();
        dll3.displayBackward();

        //Delete first element
        dll3.deleteLast();

        //display list both forward and backwards after deleting last element
        System.out.println("\nList after deleting last Node");
        dll3.displayForward();
        dll3.displayBackward();

    }
}
