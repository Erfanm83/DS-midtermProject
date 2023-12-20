import org.w3c.dom.Node;

public class ClinkedList {
    private myNode first;
//    private Bottle front;
//    private Bottle rear;

    //Constructor
    public ClinkedList() {
        this.first = null;
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
        myNode p;

        p = new myNode(value);
        p.info = value;
        p.next = null;

        if(first == null)
            first = p;
        else {
            p.next = first;
            first = p;
        }
    }

    //Delete node to linked list
    public myNode DeleteCnode(Bottle value) {
        myNode p, q;
        if (first == null) {
            System.out.println("List is empty. Cannot delete");
            return null;
        }
        else {
            p = first;
            q = first;
            while (p != null && p.info != value) {
                q = p;
                p = p.next;
            }
            if (p == null) {
                System.out.println("Not found. Cannot delete");
                return null;
            }
            else if (p == first) {
                first = first.next;
                return p;
            }
            else {
                q.next = p.next;
                return p;
            }
        }
    }
    public void show() {
        if (first == null) {
            System.out.println("Circular Queue is empty.");
            return;
        }
        myNode p = first;
        do {
            myNode temp = p;
            if (p == null) {
                System.out.print("| " + "Empty" + " |");
            }else {
                temp.info.insert(p.info.pop());
                System.out.print("| " + temp.info.pop() + " |");
            }
            p = p.next;
        } while (p != first);
        System.out.println();
    }

    public Boolean isEmpty(){
        return first == null;
    }
}

//Definition of class Node that is of type Bottle itself
class myNode {
    Bottle info ;
    myNode next;
    myNode prev;
    public myNode(Bottle data) {
        this.info = data;
        this.next = null;
        this.prev = null;
    }
}
