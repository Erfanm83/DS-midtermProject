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

        try {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
            }
            numberofNodes++;
            tail = newNode;
            tail.next = head;
        } catch (RuntimeException exception) {
            throw new RuntimeException("Error Creating new Node !");
        }
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
        String[] colorsTemp = new String[maxbottleSize * getnumberofNodes() + 10];
        // Pop items from each Bottle and add it to a temp String
        for (int k = 0; k < getnumberofNodes(); k++) {
            do {
                if (!p.info.isEmpty()) {
                    String poppedColor = p.info.pop();
                    colorsTemp[j] = poppedColor;
                    System.out.println("poppedColor = " + poppedColor);
                    j++;
                }
                p = p.next;
            } while (p != head);
        }
        for (String color : colorsTemp) {
            System.out.println("color : " + color);
        }
        // Print colorsTemp on the console
        int colorsTempIndex = 0;
        for (int i = 0; i < maxbottleSize; i++) {
            for (int k = 0; k < getnumberofNodes(); k++) {
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
            if (colorsTempIndex < colorsTemp.length) {
                switch (colorsTemp[colorsTempIndex]) {
                    case "red" -> {System.out.print(ANSI_RED + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_RED);
                        colorsTempIndex++;}
                    case "blue" -> {System.out.print(ANSI_BLUE + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_BLUE);
                        colorsTempIndex++;}
                    case "yellow" -> {System.out.print(ANSI_YELLOW + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_YELLOW);
                        colorsTempIndex++;}
                    case "green" -> {System.out.print(ANSI_GREEN + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_GREEN);
                        colorsTempIndex++;}
                    case "cyan" -> {System.out.print(ANSI_CYAN + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_CYAN);
                        colorsTempIndex++;}
                    case "purple" -> {System.out.print(ANSI_PURPLE + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_PURPLE);
                        colorsTempIndex++;}
                    //this is a trick that we consider Empty str as a color and print it in Black Color
                    case "Empty" -> {System.out.print(ANSI_WHITE + String.format("%-6s", "Empty") + ANSI_WHITE);
                        colorsTempIndex++;}
                    default -> {
                        System.out.print(colorsTemp[colorsTempIndex]);
                        colorsTempIndex++;
                    }
                }
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
            }
        }
            System.out.println();
        }
        //Mark the Selected Bottle
        for (int s = 0; s < selectedBottle; s++) {
            System.out.print("            ");
        }
        int index = 0;
        for (int l = 0; l < getnumberofNodes() + 1; l++) {
            p = p.next;
            if (selectedBottle == index) {
                System.out.println("  ---#---");
            }
            index++;
        }
        // Insert each element back to Bottle
        p = this.tail;
        for (int h = j - 1; h >= 0; h--) {
            do {
                p = p.next;
                p.info.insert(colorsTemp[h]);
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
