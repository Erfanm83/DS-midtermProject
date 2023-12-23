public class ClinkedList {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

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
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
                switch (colorsTemp[j]) {
                    case "red":
                        System.out.print(ANSI_RED + String.format("%-6s" , colorsTemp[j]) + ANSI_RED); // Red text
                        break;
                    case "blue":
                        System.out.print(ANSI_BLUE + String.format("%-6s" , colorsTemp[j]) + ANSI_BLUE); // Blue text
                        break;
                    case "yellow":
                        System.out.print(ANSI_YELLOW + String.format("%-6s" , colorsTemp[j]) + ANSI_YELLOW); // Yellow text
                        break;
                    case "green":
                        System.out.print(ANSI_GREEN + String.format("%-6s" , colorsTemp[j])  + ANSI_GREEN); // Green text
                        break;
                    case "black":
                        System.out.print(ANSI_BLACK + String.format("%-6s" , colorsTemp[j])  + ANSI_BLACK); // Black text
                        break;
                    case "cyan":
                        System.out.print(ANSI_CYAN + String.format("%-6s" , colorsTemp[j])  +  ANSI_CYAN); // Cyan text
                        break;
                    case "purple":
                        System.out.print(ANSI_PURPLE + String.format("%-6s" , colorsTemp[j])  + ANSI_PURPLE); // Purple text
                        break;
                    default:
                        System.out.print(colorsTemp);
                }
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
//                System.out.print(String.format(" | %-6s | " , colorsTemp[j]));
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
