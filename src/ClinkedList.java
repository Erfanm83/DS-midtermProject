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
    private int numberofNodes = 0;

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
            tail = newNode;
        } else {
            tail.next = newNode;
        }
        numberofNodes++;
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
        } while (currentNode != head);
    }

    public void show(int maxbottleSize, int selectedBottle) {
        if (this.head == null) {
            System.out.println("Circular Queue is empty.");
        }
        myNode p = this.head;
        int j = 0;
//        System.out.println("getnumberofNodes : " + getnumberofNodes());
        String[] colorsTemp = new String[maxbottleSize * getnumberofNodes() + 1];
        //Pop items from each Bottle and add it to a temp String
        // Pop items from each Bottle and add it to a temp String
        do {
            if (!p.info.isEmpty()) {
                String poppedColor = p.info.pop();
                colorsTemp[j] = poppedColor;
                j++;
            }
            p = p.next;
        } while (p != head);

        // Print colorsTemp on the console
        for (int i = 0; i < maxbottleSize; i++) {
            for (int k = 0; k < getnumberofNodes() + 1; k++) {
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
                if (i < colorsTemp.length) {
                    switch (colorsTemp[i]) {
                        case "red" -> System.out.print(ANSI_RED + String.format("%-6s", colorsTemp[i]) + ANSI_RED);
                        case "blue" -> System.out.print(ANSI_BLUE + String.format("%-6s", colorsTemp[i]) + ANSI_BLUE);
                        case "yellow" -> System.out.print(ANSI_YELLOW + String.format("%-6s", colorsTemp[i]) + ANSI_YELLOW);
                        case "green" -> System.out.print(ANSI_GREEN + String.format("%-6s", colorsTemp[i]) + ANSI_GREEN);
                        case "cyan" -> System.out.print(ANSI_CYAN + String.format("%-6s", colorsTemp[i]) + ANSI_CYAN);
                        case "purple" -> System.out.print(ANSI_PURPLE + String.format("%-6s", colorsTemp[i]) + ANSI_PURPLE);
                        //this is a trick that we consider Empty str as a color and print it in Black Color
                        case "Empty" -> System.out.print(ANSI_BLACK + String.format("%-6s", colorsTemp[i]) + ANSI_BLACK);
                        default -> System.out.print(colorsTemp[i]);
                    }
                    System.out.print(ANSI_RESET + " | " + ANSI_RESET);
                }
            }
            System.out.println();
        }
        //Mark the Selected Bottle
        for (int i = 0; i < selectedBottle; i++) {
            System.out.print("            ");
        }
        int k = 0;
        for (int l = 0; l < getnumberofNodes() + 1; l++) {
            p = p.next;
            if (selectedBottle == k) {
                System.out.println("  ---#---");
            }
            k++;
        }
        // Insert each element back to Bottle
        p = this.tail;
        for (int i = j - 1; i >= 0; i--) {
            do {
                p = p.next;
                p.info.insert(colorsTemp[i]);
            } while (p != head);
        }
    }

    //check to see whether CLinkedList is Empty or not
    public Boolean isEmpty() {
        return head == null;
    }

    //counts number of nodes
    public int getnumberofNodes() {
        int k = 0;
        do {
            if (head == null)
                return 0;
            head = head.next;
            k++;
        } while (head != tail);
        return k;
    }

    public void setnumberofNodes(int numberofNodes) {
        this.numberofNodes = numberofNodes;
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
