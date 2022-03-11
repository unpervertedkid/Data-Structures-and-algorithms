package singlylinkedlist;

public class MergingSortedLists {
    //Head of List
    private Node head;

    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //Method to display List
    public void display(){
        Node current = head;

        while(current!= null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("Null");
    }


    //Method to insert node to end of List
    public void insertLast(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }
        Node current = head;

        while(current.next!=null){
            current=current.next;
        }

        current.next=newNode;
    }
    //Method to merge two sorted lists
    public static Node merge(Node a, Node b){
        Node dummy = new Node(0);
        Node tail = dummy;

        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next = a;
                a = a.next;
            }
            else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a==null){
            tail.next = b;
        }else{
            tail.next = a;
        }
    return dummy.next;

    }

    public static void main(String[] args) {

        //Create a List
        MergingSortedLists list1 = new MergingSortedLists();
        list1.head = new Node(1);
        list1.insertLast(3);
        list1.insertLast(5);
        list1.insertLast(7);

        //Print out List
        System.out.println("List One:");
        list1.display();
        System.out.println();
        //Create second List
        MergingSortedLists list2 = new MergingSortedLists();
        list2.head = new Node(4);
        list2.insertLast(6);
        list2.insertLast(8);
        list2.insertLast(11);
        list2.insertLast(13);
        list2.insertLast(15);


        //Print out List
        System.out.println("List Two:");
        list2.display();
        System.out.println();

        //Merge the lists and save the result to another list
        MergingSortedLists mergeList = new MergingSortedLists();
        mergeList.head = merge(list1.head, list2.head);

        //Print out the merged list
        System.out.println("Merged List:");
        mergeList.display();




    }
}
