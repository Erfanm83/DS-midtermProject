public class ClinkedList<Bottle> {
    private Node<Bottle> front;
    private Node<Bottle> rear;

    //Constructor
    public ClinkedList() {
        this.front = null;
        this.rear = null;
    }

    public Node<Bottle> getNext(Bottle value){
        return front;
    }
    public Node<Bottle> getPrev(Bottle value){
        return rear;
    }
    //Add a node to linked list
    public void AddCnode(Bottle value) {
        Node<Bottle> newNode = new Node(value);
        if (front == null) {
            front = rear = newNode;
            newNode.next = newNode.prev = newNode;
        } else {
            newNode.next = front;
            newNode.prev = rear;
            rear.next = newNode;
            front.prev = newNode;
            rear = newNode;
        }
    }

    //Delete node to linked list
    public Node<Bottle> DeleteCnode() {
        if (front == null) {
            System.out.println("Circular LinkedList is empty. Cannot delete");
            return null;
        }
        if (front == rear) {
            front = rear = null;
            return null;
        } else {
            rear.prev.next = front;
            front.prev = rear.prev;
            rear = rear.prev;
            return rear;
        }
    }
    public void show() {
        if (front == null) {
            System.out.println("Circular Queue is empty.");
            return;
        }
        Node<Bottle> current = front;
        do {
            System.out.print(current.bottle + " ");
            current = current.next;
        } while (current != front);
        System.out.println();
    }

    public Boolean isEmpty(){
        return front == null || rear == null;
    }

}

//Definition of class Node that is of type Bottle itself
class Node <Bottle>{
    Bottle bottle;
    Node<Bottle> next;
    Node<Bottle> prev;
    public Node(Bottle data) {
        this.bottle = data;
        this.next = null;
        this.prev = null;
    }
}
