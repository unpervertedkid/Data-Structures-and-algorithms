package doublylinkedlist;

public class DeleteFirstNodedll {

    public static void main(String[] args) {
        DoublyLinkedList dll2 = new DoublyLinkedList();
        dll2.insertFirst(1);
        dll2.insertLast(2);
        dll2.insertLast(3);

        //display list both forward and backwards Before deleting first element
        dll2.displayForward();
        dll2.displayBackward();

        //Delete first element
        dll2.deleteFirst();

        //display list both forward and backwards after deleting first element
        System.out.println("");
        dll2.displayForward();
        dll2.displayBackward();

    }
}
