public class ClinkedList {

    // ANSI escape codes to use color in your output.
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
        //Pop items from each Bottle and add it to a temp String
        for (int i = 0; i < maxbottleSize; i++) {
            do {
                p = p.next;
                colorsTemp[j] = p.info.pop();
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
                switch (colorsTemp[j]) {
                    case "red" ->
                            System.out.print(ANSI_RED + String.format("%-6s", colorsTemp[j]) + ANSI_RED); // Red text
                    case "blue" ->
                            System.out.print(ANSI_BLUE + String.format("%-6s", colorsTemp[j]) + ANSI_BLUE); // Blue text
                    case "yellow" ->
                            System.out.print(ANSI_YELLOW + String.format("%-6s", colorsTemp[j]) + ANSI_YELLOW); // Yellow text
                    case "green" ->
                            System.out.print(ANSI_GREEN + String.format("%-6s", colorsTemp[j]) + ANSI_GREEN); // Green text
                    case "black" ->
                            System.out.print(ANSI_BLACK + String.format("%-6s", colorsTemp[j]) + ANSI_BLACK); // Black text
                    case "cyan" ->
                            System.out.print(ANSI_CYAN + String.format("%-6s", colorsTemp[j]) + ANSI_CYAN); // Cyan text
                    case "purple" ->
                            System.out.print(ANSI_PURPLE + String.format("%-6s", colorsTemp[j]) + ANSI_PURPLE); // Purple text
                    default -> System.out.print(colorsTemp[j]);
                }
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
                j++;
            } while (p != head);
            System.out.println();
        }
        //pop from that temp string and insert each element to Bottle
        p = this.tail;
        for (int i =colorsTemp.length - 1; i > 0; i--) {
            do {
                p = p.next;
                System.out.println(p.info.insert(colorsTemp[i]));
            }while (p != head);
        }
    }

    public Boolean isEmpty() {
        return head == null;
    }
}

//Definition of class Node
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
