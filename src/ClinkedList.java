import java.util.Objects;

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
        String[] colorsTemp = new String[maxbottleSize * (getNumberofNodes() + 1)];
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
        printColorsTemp(maxbottleSize, colorsTemp);
        //Mark the Selected Bottle
        int index = 0;
        for (int l = 0; l < getNumberofNodes() + 1; l++) {
            if (selectedBottle == index && canSelect) {
                System.out.println("  ---#---");
            } else {
                System.out.print("            ");
            }
            index++;
        }
        System.out.println();
        // Insert each element back to Bottle
        for (int i = 0; i < getNumberofNodes() - 1; i++) {
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
                for (int i = 0; i < getNumberofNodes() - 1; i++) {
                    p = p.next;
                }
                tIndex--;
            } while (p.bottleIndex != getNumberofNodes());
        }
    }

    private void printColorsTemp(int maxbottleSize, String[] colorsTemp) {
        int colorsTempIndex = 0;
        for (int i = 0; i < maxbottleSize; i++) {
            for (int k = 0; k < getNumberofNodes(); k++) {
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

    public void setnumberofNodes(int numberofNodes) {
        this.numberofNodes = numberofNodes;
    }

    public int getNumberofNodes() {
        return numberofNodes;
    }

    public String getColorByIndex(int index) {
        myNode p = this.head;
        while (p != null && p.bottleIndex != index) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        Bottle bottle = p.info;
        if (bottle.isEmpty()) {
            return null;
        }
        String poppedColor = bottle.pop();
        if (poppedColor != null) {
            bottle.insert(poppedColor);
        }
        return poppedColor;
    }

    public Bottle getBottleByIndex(int index) {
        myNode p = this.head;
        while (p != null && p.bottleIndex != index) {
            p = p.next;
        }
        if (p == null) {
            return null;
        }
        return p.info;
    }

    public Boolean pourBottle(int bottleToPour, int selectedBottle, int maxbottlesize) {
        String topColor = getColorByIndex(selectedBottle - 1);
        String selectedBottleColor = getColorByIndex(selectedBottle - 1);
        String bottleToPourColor = getColorByIndex(bottleToPour - 1);
        Bottle selectedbottle = getBottleByIndex(selectedBottle - 1);
        Bottle bottletoPour = getBottleByIndex(bottleToPour - 1);
        System.out.println("selectedBottle = " + selectedBottle);
        System.out.println("bottleToPour = " + bottleToPour);

        //Bottle to pour is an Empty Bottle
        if (bottleToPourColor.equals("Empty")) {
            int eNumber = 0;
            int pNumber = 0;
            String pColor = "Empty";
            String sColor = selectedBottleColor;
            String temp = null;
            if (!selectedBottleColor.equals("Empty")) {
                while (Objects.equals(pColor, "Empty")) {

                    if (pColor != null && pColor.equals("Empty")) {
                        pColor = bottletoPour.pop();
                        eNumber++;
                    }
                    System.out.println("pColor : " + pColor);
                    pColor = getColorByIndex(bottleToPour - 1);
                    System.out.println("pColor2 : " + pColor);
                }
                while (Objects.equals(sColor, topColor)) {
                    System.out.println("topColor : " + topColor);
                    System.out.println("sColor : " + sColor);
                    if (sColor != null) {
                        sColor = selectedbottle.pop();
//                    System.out.println(bottletoPour.insert(sColor));
                        if (!sColor.equals("Empty")) {
                            System.out.println(bottletoPour.insert(sColor));
//                      System.out.println("GorgMammad " + selectedbottle.pop());
                        }
                    }
                    sColor = getColorByIndex(selectedBottle - 1);
                    System.out.println("sColor2 : " + sColor);
                    pNumber++;
                }
                // refill stacks
//            System.out.println("number of Empty insert on bottleToPour");
                for (int i = 0; i < eNumber - pNumber; i++) {
                    bottletoPour.insert("Empty");
//                System.out.println(bottletoPour.insert("Empty"));
                }
//            System.out.println("number of Empty insert on selectedbottle");
                for (int i = 0; i < pNumber; i++) {
                    selectedbottle.insert("Empty");
//                System.out.println(selectedbottle.insert("Empty"));
                }
                return true;
            }
            if (!sColor.equals(bottleToPourColor)) {
                System.out.println("Can not pour to this Bottle");
                return false;
            } else {
                System.out.println("GorgAli Ghaaaaaaaaaaan Ghaaaaaaan");
                while (Objects.equals(pColor, "Empty")) {
                    if (pColor != null && pColor.equals("Empty")) {
                        pColor = bottletoPour.pop();
                        eNumber++;
                    }
                    System.out.println("pColor : " + pColor);
                    pColor = getColorByIndex(bottleToPour - 1);
                    System.out.println("pColor2 : " + pColor);
                }
                while (Objects.equals(sColor, topColor)) {
                    System.out.println("topColor : " + topColor);
                    System.out.println("sColor : " + sColor);
                    if (sColor != null) {
                        sColor = selectedbottle.pop();
                        temp = sColor;
//                    System.out.println(bottletoPour.insert(sColor));
                    }
                    sColor = getColorByIndex(selectedBottle - 1);
                    System.out.println("sColor2 : " + sColor);
                    bottleToPourColor = getColorByIndex(bottleToPour - 1);
                    System.out.println("bottleToPourColor = " + bottleToPourColor);
                    if (sColor != null && !sColor.equals("Empty")) {
                        topColor = sColor;
                        if (sColor.equals(bottleToPourColor))
                            System.out.println(bottletoPour.insert(sColor));
                        else {
                            System.out.println(sColor + " color doesn't match " + bottleToPourColor + " color.");
                            System.out.println(selectedbottle.insert(temp));
                            break;
                        }
//                      System.out.println("GorgMammad " + selectedbottle.pop());
                    }
//                    if (!sColor.equals(bottleToPourColor)) {
//                        System.out.println("Can not pour to this Bottle");
//                        break;
//                    }
                    pNumber++;
                }
                // refill stacks
//            System.out.println("number of Empty insert on bottleToPour");
                for (int i = 0; i < eNumber - pNumber; i++) {
                    bottletoPour.insert("Empty");
//                System.out.println(bottletoPour.insert("Empty"));
                }
//            System.out.println("number of Empty insert on selectedbottle");
                for (int i = 0; i < pNumber; i++) {
                    selectedbottle.insert("Empty");
//                System.out.println(selectedbottle.insert("Empty"));
                }
                return true;
            }
        }
        return false;
    }

    public Boolean checkWinnig(int maxbottleSize) {
        myNode p = this.head;
        if (p.bottleIndex != 0) {
            p = p.next;
        }
        int fullBottles = 0;
        int similarColors;
        for (int k = 0; k < getNumberofNodes() - 1; k++) {
            similarColors = 1;
            String topColor = p.info.pop();
            if (!topColor.equals("Empty")) {
                for (int i = 0; i < maxbottleSize - 1; i++) {
                    if (p.info.pop().equals(topColor)) {
                        similarColors++;
                    }
                }
            }
            if (similarColors == maxbottleSize) {
                fullBottles++;
                for (int i = 0; i < maxbottleSize; i++) {
                    System.out.println("topColor " + topColor);
                    System.out.println(p.info.insert(topColor));
                }
            }
//            if (p.next.bottleIndex != 0)
            p = p.next;
        }
        return fullBottles == getNumberofNodes() - 1;
    }

    //Swap method for swapping two Bottles
    // Swap method for swapping two Bottles
    public void swapBottle(int bottleToSwap, int selectedBottle) {
        // Check for empty list and invalid indexes
        if (this.head == null) {
            throw new RuntimeException("The list is empty. Swapping not possible.");
        }

        System.out.println("selectedBottle = " + selectedBottle);
        System.out.println("bottleToSwap = " + bottleToSwap);

        // Get the nodes to swap
        myNode swapNode = getNode(bottleToSwap);
        myNode selectedNode = getNode(selectedBottle);

        // Swap node positions in the circular linked list
        if (swapNode == selectedNode) {
            // No need to swap if they're the same node
            return;
        }

        if (swapNode == this.head) {
            System.out.println("gogrAli Downloading...1");
            swapFirstNode(swapNode, selectedNode);
        } else if (selectedNode == this.head) {
            System.out.println("gogrAli Downloading...2");
            swapFirstNode(selectedNode, swapNode);
        } else {
            System.out.println("gogrAli Downloading...3");
            // Update pointers for non-head nodes
//            myNode swapPrev = swapNode.prev;
            myNode swapPrev = getPrevNode(swapNode);
            myNode swapNext = swapNode.next;
//            myNode selectedPrev = selectedNode.prev;
            myNode selectedPrev = getPrevNode(selectedNode);
            myNode selectedNext = selectedNode.next;

            swapPrev.next = selectedNode;
//            selectedNode.prev = swapPrev;
//            selectedNext.prev = swapNode;
            swapNode.next = selectedNext;

            selectedNode.next = swapNext;
//            swapNext.prev = selectedNode;
//            swapNode.prev = selectedPrev;
            selectedPrev.next = swapNode;
        }

        // Swap bottle indexes
        int tempIndex = swapNode.bottleIndex;
        swapNode.bottleIndex = selectedNode.bottleIndex;
        selectedNode.bottleIndex = tempIndex;

        System.out.println("after changing");
        System.out.println("selectedNode Index = " + selectedNode.bottleIndex);
        System.out.println("swapNode Index = " + swapNode.bottleIndex);
        // Update head pointer if necessary
//        if (this.head == swapNode) {
//            this.head = selectedNode;
//        } else if (this.head == selectedNode) {
//            this.head = swapNode;
//        }
    }

    // Helper method for swapping the first node
    private void swapFirstNode(myNode firstNode, myNode otherNode) {
        myNode tempNext = otherNode.next;
        otherNode.next = firstNode.next;
        firstNode.next = tempNext;

        tempNext = otherNode.prev;
        otherNode.prev = firstNode.prev;
        firstNode.prev = tempNext;

        int tempIndex = firstNode.bottleIndex;
        firstNode.bottleIndex = otherNode.bottleIndex;
        otherNode.bottleIndex = tempIndex;

        this.head = otherNode;
    }

//    public void swapBottle(int bottleToSwap, int selectedBottle) {
////        if (this.head == null) {
////            System.out.println("Circular Queue is empty.");
////        }
////        myNode swapNode = this.head;
////        myNode selectedNode = this.head;
////        myNode tempNode;
////        int tempIndex;
////        while (swapNode.bottleIndex != bottleToSwap){
////            System.out.println("swapNode bottleIndex = " + swapNode.bottleIndex);
////            swapNode = swapNode.next;
////        }
//////        System.out.println("swapNode = " + swapNode.info.pop() + " swapNode Index = " + swapNode.bottleIndex);
////        while (selectedNode.bottleIndex != selectedBottle){
////            System.out.println("selectedNode bottleIndex = " + selectedNode.bottleIndex);
////            selectedNode = selectedNode.next;
////        }
//////        System.out.println("selectedNode = " + selectedNode.info.pop() + " selectedBottle Index = "  +selectedNode.bottleIndex);
////        tempNode = selectedNode.next;
////        selectedNode.next = swapNode.next;
////        tempNode = selectedNode.prev;
////        selectedNode.prev = swapNode.prev;
////        swapNode.next = tempNode;
////        tempIndex = swapNode.bottleIndex;
////        swapNode.bottleIndex = selectedNode.bottleIndex;
////        selectedNode.bottleIndex = tempIndex;
////        System.out.println("swapNode bottleIndex = " + swapNode.bottleIndex);
////        System.out.println("selectedNode bottleIndex = " + selectedNode.bottleIndex);
////    }
//        myNode swapNode = getNode(bottleToSwap);
//        myNode selectedNode = getNode(selectedBottle);
////        myNode prevswapNode = getNode(bottleToSwap - 1);
////        myNode prevselectedNode = getNode(selectedBottle - 1);
////        if (bottleToSwap == 0)
////            prevswapNode = getNode(getNumberofNodes() - 1);
////        if (selectedBottle == 0)
////            prevselectedNode = getNode(getNumberofNodes() - 1);
//
//        System.out.println("selectedBottle = " + selectedBottle);
//        System.out.println("bottleToSwap = " + bottleToSwap);
////        System.out.println("prevselectedBottle = " + (selectedBottle - 1));
////        System.out.println("prevbottleToSwap = " + (bottleToSwap - 1));
//
//        // Update next and prev pointers
//        myNode temp = selectedNode.next;
//        selectedNode.next = swapNode.next;
//        swapNode.next = temp;
//
////        // prev Nodes
////        myNode prevtemp = prevselectedNode.next;
////        prevselectedNode.next = prevswapNode.next;
////        prevswapNode.next = prevtemp;
//
//        temp = selectedNode.prev;
//        selectedNode.prev = swapNode.prev;
//        swapNode.prev = temp;
//
//        // Swap indexes
//        int tempIndex = swapNode.bottleIndex;
//        swapNode.bottleIndex = selectedNode.bottleIndex;
//        selectedNode.bottleIndex = tempIndex;
//
//        System.out.println("after changing");
//        System.out.println("selectedBottle Index = " + selectedNode.bottleIndex);
//        System.out.println("bottleToSwap Index = " + swapNode.bottleIndex);
//
////        System.out.println("prevselectedBottle Index = " + prevselectedNode.bottleIndex);
////        System.out.println("prevbottleToSwap Index = " + prevswapNode.bottleIndex);
////        // Prev Swap Indexes
////        int prevtempIndex = prevswapNode.bottleIndex;
////        prevswapNode.bottleIndex = prevselectedNode.bottleIndex;
////        prevselectedNode.bottleIndex = prevtempIndex;
////
////        System.out.println("prevselectedBottle Index = " + prevselectedNode.bottleIndex);
////        System.out.println("prevbottleToSwap Index = " + prevswapNode.bottleIndex);
//
//        temp = this.head;
//        while (temp.bottleIndex != 0) {
//            temp = temp.next;
//        }
//        System.out.println("nodes = " + getNumberofNodes());
//        for (int i = 0; i < getNumberofNodes(); i++) {
//            System.out.println("Bottle Indexes = " + temp.bottleIndex);
//            temp = temp.next;
//        }
//    }

    // Helper method to get node by index
    private myNode getNode(int index) {
        myNode curr = this.head;
        if (curr.bottleIndex != 0) {
            curr = curr.next;
        }
        do {
            curr = curr.next;
        } while (curr.bottleIndex != 0 && curr.bottleIndex != index);
        return curr;
    }
    private myNode getPrevNode(myNode curr){
        for (int i = 0; i < getNumberofNodes() - 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

//    private void setPrevNode(myNode setnode , myNode curr){
//        myNode temp = getPrevNode(curr);
//        temp.next = setnode;
//    }
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
