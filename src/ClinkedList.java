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

    public myNode getHead() {
        return head;
    }

    //Add a node to linked list
    public void AddCnode(Bottle value, int bottleIndex) {
        myNode newNode = new myNode(value);
        try {
            if (head == null) {
                head = newNode;
                newNode.bottleIndex = 0;
            } else {
                tail.next = newNode;
                newNode.bottleIndex = bottleIndex;
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

    //show method for printing colors colorfully on console
    public void show(int maxbottleSize, int selectedBottle, Boolean canSelect) {
        if (this.head == null) {
            System.out.println("Circular Queue is empty.");
        }
        myNode p = this.head;
        if (p.bottleIndex != 0) {
            p = p.next;
        }
        int j = 0;
        String[] colorsTemp = new String[maxbottleSize * (getnumberofNodes() + 1)];
        // Pop items from each Bottle and add it to a temp String
        for (int k = 0; k < maxbottleSize; k++) {
            do {
                if (!p.info.isEmpty()) {
                    colorsTemp[j] = p.info.pop();
                    j++;
                }
                p = p.next;
            } while (p.bottleIndex != 0);
        }
        // Print colorsTemp on the console
        printColorsTemp(maxbottleSize , colorsTemp);
        //Mark the Selected Bottle
        int index = 0;
        for (int l = 0; l < getnumberofNodes() + 1; l++) {
            if (selectedBottle == index && canSelect) {
                System.out.println("  ---#---");
            }else {
                System.out.print("            ");
            }
            index++;
        }
        System.out.println();
        // Insert each element back to Bottle
        for (int i = 0; i < getnumberofNodes() - 1; i++) {
            p = p.next;
        }
        int tIndex = j - 1;
        while (tIndex >= 0) {
            do {
                if (tIndex == -1)
                    break;
                if (colorsTemp[tIndex] != null) {
                    p.info.insert(colorsTemp[tIndex]);
                }
                for (int i = 0; i < getnumberofNodes() - 1; i++) {
                    p = p.next;
                }
                tIndex--;
            } while (p.bottleIndex != getnumberofNodes());
        }
    }

    private void printColorsTemp(int maxbottleSize , String [] colorsTemp){
        int colorsTempIndex = 0;
        for (int i = 0; i < maxbottleSize; i++) {
            for (int k = 0; k < getnumberofNodes(); k++) {
                System.out.print(ANSI_RESET + " | " + ANSI_RESET);
                if (colorsTempIndex < colorsTemp.length) {
                    switch (colorsTemp[colorsTempIndex]) {
                        case "red" -> {
                            System.out.print(ANSI_RED + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_RED);
                            colorsTempIndex++;
                        }
                        case "blue" -> {
                            System.out.print(ANSI_BLUE + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_BLUE);
                            colorsTempIndex++;
                        }
                        case "yellow" -> {
                            System.out.print(ANSI_YELLOW + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_YELLOW);
                            colorsTempIndex++;
                        }
                        case "green" -> {
                            System.out.print(ANSI_GREEN + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_GREEN);
                            colorsTempIndex++;
                        }
                        case "cyan" -> {
                            System.out.print(ANSI_CYAN + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_CYAN);
                            colorsTempIndex++;
                        }
                        case "purple" -> {
                            System.out.print(ANSI_PURPLE + String.format("%-6s", colorsTemp[colorsTempIndex]) + ANSI_PURPLE);
                            colorsTempIndex++;
                        }
                        //this is a trick that we consider Empty str as a color and print it in Black Color
                        case "Empty" -> {
                            System.out.print(ANSI_WHITE + String.format("%-6s", "Empty") + ANSI_WHITE);
                            colorsTempIndex++;
                        }
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
    int bottleIndex;

    public myNode(Bottle data) {
        this.info = data;
        this.next = null;
        this.prev = null;
        this.bottleIndex = 0;
    }
}
