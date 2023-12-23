public class ClinkedList {
    private myNode head;
    private myNode tail;

    //Constructor
    public ClinkedList() {
        this.head = null;
        this.tail = null;
    }
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

    public void show(int maxbottleSize) {
        if (this.head == null) {
            System.out.println("Circular Queue is empty.");
        }
        myNode p = this.head;
        int j = 0;
        String [] colorsTemp = new String[maxbottleSize * (maxbottleSize + 1)];
        for (int i = 0; i < maxbottleSize; i++) {
            do {
                p = p.next;
                colorsTemp[j] = p.info.pop();
                System.out.print(String.format(" | %-6s | " , colorsTemp[j]));
                j++;
            } while (p != head);
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
