import java.util.*;

public class WaterSortGame {
    private int numberOfBottles;
    private String colors;
    private int maxbottlesize;

    //circular Queue implementation with linkedList
    private ClinkedList bottleList;

    //constructor
    public WaterSortGame(String colors, int maxbottlesize, ClinkedList bottleList) {
        //The number of spaces is one less than the number of colors
        //and the number of bottles are one greater than the number of colors
        this.numberOfBottles = WaterSortGame.countSpaces(colors) + 2;
        this.colors = colors;
        this.maxbottlesize = maxbottlesize;
        this.bottleList = bottleList;

        // Create a list of colors and shuffle it
        String[] colorArray = colors.split("\\s+");
        List<String> colorList = new ArrayList<>(Arrays.asList(colorArray));
        Collections.shuffle(colorList);
        initialize(maxbottlesize, bottleList, colorList, colorArray);
    }

    public int getNumberOfBottles() {
        return this.numberOfBottles;
    }

    private void initialize(int maxBottleSize, ClinkedList clinkedList, List<String> colorList, String[] colorsArray) {
        randomColor(colorsArray, clinkedList, numberOfBottles - 1, maxBottleSize);
        // The last bottle is an empty bottle
        Bottle emptyBottle = new Bottle(maxBottleSize);
        // Assign a single color "Empty" to the empty bottle
        for (int i = 0; i < maxBottleSize; i++) {
            emptyBottle.insert("Empty");
        }
        clinkedList.AddCnode(emptyBottle , getNumberOfBottles() - 1);
    }
    //Calculates the number of spaces
    private static int countSpaces(String input) {
        int spaceCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }

    //Random method for random Selection of colors
    private void randomColor(String[] colorsArray, ClinkedList bottleList, int numberOfColors, int maxbottlesize) {
        int [] colorsCapacity = new int[numberOfColors];
        for (int i = 0; i < numberOfColors; i++) {
            colorsCapacity[i] = maxbottlesize;
        }
        for (int i = 0; i < getNumberOfBottles() - 1; i++) {
            Bottle bottle = new Bottle(maxbottlesize);
            for (int j = 0; j < maxbottlesize; j++) {
                Boolean flag = false;
                while (!flag){
                    Random random = new Random();
                    int randomColor = random.nextInt(numberOfColors);
                    if (colorsCapacity[randomColor] > 0) {
                        bottle.insert(colorsArray[randomColor]);
                        colorsCapacity[randomColor]--;
                        flag = true;
                    }
                }
            }
            bottleList.AddCnode(bottle, i);
        }
    }

    //display method for displaying bottle stuff
    public void display(int maxbottlesize, ClinkedList bottleList, int selectedBottle, Boolean canSelect) {
        bottleList.show(maxbottlesize, selectedBottle, canSelect);
    }

    //select method for choosing a bottle
    public Boolean select(int selectedBottle, ClinkedList bottleList, int maxbottlesize) {
        Boolean isSelected = false;
        //Selected Bottle out of range
        if (!validBottle(selectedBottle)) {
            System.out.println("!< Selected Bottle out of Range >!");
            isSelected = false;
        } else {
            display(maxbottlesize, bottleList, selectedBottle - 1, true);
            System.out.println("Bottle " + selectedBottle + " selected Successfully !");
            isSelected = true;
        }
        return isSelected;
    }

    //deselect method for deselect a bottle
    public void deselect(int bottleToDeselect, int selectedBottle, ClinkedList bottleList, int maxbottlesize) {
        if (!validBottle(bottleToDeselect))
            System.out.println("!< deSelected Bottle out of Range >!");
        else if (bottleToDeselect == selectedBottle) {
            display(maxbottlesize, bottleList, bottleToDeselect - 1, false);
            System.out.println("Bottle " + bottleToDeselect + " deselected Successfully !");
        } else {
            System.out.println("Please deSelect a valid");
        }
    }

    //selectNext method for selecting next item
    public Boolean selectNext(int currentSelected, ClinkedList bottleList, int maxbottlesize) {
        return select(currentSelected + 1, bottleList, maxbottlesize);
    }

    //selectPrev method for selectiong prev item
    public Boolean selectPrev(int currentSelected, ClinkedList bottleList, int maxbottlesize) {
        return select(currentSelected - 1, bottleList, maxbottlesize);
    }

    //Pour method for pouring Bottles
    public Boolean pour(int bottleToPour, int selectedBottle, int maxbottlesize, ClinkedList bottleList) {
        Boolean isPoured = false;
        //Selected Bottle out of range
        if (!validBottle(bottleToPour)) {
            System.out.println("!< Selected Bottle out of Range >!");
            isPoured = false;
        } else {
            //implementation
            System.out.println("Bottle " + bottleToPour + " poured Successfully !");
            isPoured = true;
        }
        return isPoured;
    }

    //Swap method for changing order of Bottles
    public Boolean swap(int bottleToSwap, int selectedBottle, int maxbottlesize, ClinkedList bottleList) {
        Boolean isSwapped = false;
        //Selected Bottle out of range
        if (!validBottle(bottleToSwap)) {
            System.out.println("!< Selected Bottle out of Range >!");
            isSwapped = false;
        } else if (bottleToSwap == selectedBottle) {
            System.out.println("Please Select Another Bottle To swap. ");
            isSwapped = false;
        } else {
            //implementation
            System.out.println("Bottle " + selectedBottle + " swapped with " + bottleToSwap + " Successfully !");
            isSwapped = true;
        }
        return isSwapped;
    }

    //check validation for Bottle Number
    private Boolean validBottle(int bottleNumber) {
        return bottleNumber <= getNumberOfBottles() && bottleNumber > 0;
    }

    //ReplaceColor Method
    public void replaceColor(String firstColor, String secondColor) {
        //implementation
    }

    //AddEmptyBottle method
    //Adds a bottle half the size of maxBottleSize to the end of the list of bottles. User until the end of the game only
    //He can use this feature once
    public void addEmptyBottle() {
        //implementation
    }

    //check to see if User had Won the Game or not
    public Boolean hasWon() {
        Boolean hasWon = false;
        //implementation
        return hasWon;
    }

    //Undo Method
    public void undo() {
        //implementation
    }

    //Redo Method
    public void redo() {
        //implementation
    }
}
