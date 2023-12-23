public class ClinkedList {
    private myNode head = null;
    private myNode tail = null;
//    private Bottle front;
//    private Bottle rear;

    //Constructor
    public ClinkedList() {
        this.head = new myNode(null);
        this.tail =  new myNode(null);
//        this.front = null;
//        this.rear = null;
    }

    //    public  Bottle getNext(Bottle value){
//        return front;
//    }
//    public Bottle getPrev(Bottle value){
//        return rear;
//    }
    //Add a node to linked list
    public void AddCnode(Bottle value) {
        myNode newNode = new myNode(value);

        if (head == null) {
            head = newNode;
        }else {
            tail.next = newNode;
        }
        tail = newNode;
        tail.next = head;
    }

    //Delete node to linked list
    public void DeleteCnode(Bottle value) {
        myNode currentNode = head;
        if (head == null) // the list is empty
            return;
        do {
            myNode nextNode = currentNode.next;
            if (nextNode.info == value) {
                if (tail == head) { // the list has only one single element
                    head = null;
                    tail = null;
                } else {
                    currentNode.next = nextNode.next;
                    if (head == nextNode) { //we're deleting the head
                        head = head.next;
                    }
                    if (tail == nextNode) { //we're deleting the tail
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head) ;
    }

    public void show(int bottleSize) {
        if (this.head == null || this.tail == null) {
            System.out.println("Circular Queue is empty.");
            return;
        }
        myNode p = this.head;
        int number = 0;
        for (int i = 0; i < bottleSize; i++) {
            do {
                p = p.next;
                myNode temp = p;
//                temp.info.insert(p.info.pop());
                System.out.print("| " + temp.info.pop() + " |");
                if (p.next == null)
                    System.out.println("Ridi");
                number++;
            } while (p != head);
            for (int j = 0; j < number; j++) {
                p = p.prev;
            }
            System.out.println();
        }
    }

    public Boolean isEmpty() {
        return head == null;
    }
}

//Definition of class Node that is of type Bottle itself
class myNode {
    Bottle info;
    myNode next;
    myNode prev;

    public myNode(Bottle data) {
        this.info = data;
        this.next = null;
        this.prev = null;
    }
}
