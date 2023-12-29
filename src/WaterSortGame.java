import java.util.*;

public class WaterSortGame {
    private int numberOfBottles;
    private String colors;
    private int maxbottlesize;

    //circular Queue implementation with linkedList
    private ClinkedList bottleList;
    //constructor
    public WaterSortGame(String colors, int maxbottlesize , ClinkedList bottleList) {
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
        System.out.println("Outside of initialize , colorList : " + colorList);
        initialize(maxbottlesize, bottleList, colorList);
//        initialize(maxbottlesize, bottleList , colors);
    }

    public int getNumberOfBottles() {
        return this.numberOfBottles;
    }

    private void initialize(int maxBottleSize, ClinkedList clinkedList, List<String> colorList) {
        Iterator<String> iterator = colorList.iterator();
        for (int i = 0; i < getNumberOfBottles() - 1; i++) {
//            Iterator<String> iterator = colorList.iterator();
            Bottle bottle = new Bottle(maxBottleSize);

            Collections.shuffle(colorList);
            System.out.println("colorList : " + colorList);
            // Assign colors from the shuffled list to each bottle
            while (iterator.hasNext()) {
                // Assign colors from the shuffled list to each bottle
                System.out.println(bottle.insert(iterator.next()));
            }
//            RandomColor(bottle , colorList);
            clinkedList.AddCnode(bottle);
            try {
                iterator = colorList.iterator(); // Reset iterator for the next bottle
            }catch (RuntimeException exception) {
                throw new RuntimeException("can not set iterator on the colors List");
            }
        }

        // The last bottle is an empty bottle
        Bottle emptyBottle = new Bottle(maxBottleSize);
        // Assign a single color "Empty" to the empty bottle
//        RandomColor(emptyBottle, Arrays.asList("Empty"));
        for (int i = 0; i < maxBottleSize; i++) {
            System.out.println(emptyBottle.insert("Empty"));
        }
        clinkedList.AddCnode(emptyBottle);
    }
//    private void initialize(int maxBottleSize , ClinkedList clinkedList , String colors){
//        for (int i = 0; i < getNumberOfBottles() - 1; i++) {
//            Bottle bottle = new Bottle(maxBottleSize);
//            RandomColor(bottle , colors);
//            clinkedList.AddCnode(bottle);
//        }
//        // The last bottle is an empty bottle
//        Bottle emptyBottle = new Bottle(maxBottleSize);
//        RandomColor(emptyBottle , "Empty ");
//        clinkedList.AddCnode(emptyBottle);
//    }

    //Calculates the number of spaces
    public static int countSpaces(String input) {
        int spaceCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }
    // random method for random selection of colors for bottles
    public void RandomColor(Bottle bottle, List<String> colorList) {
        // Shuffle the list of colors before assigning them to the bottle
//        Collections.shuffle(colorList);
        // Assign colors from the shuffled list to the bottle
        for (String color : colorList) {
            bottle.insert(color);
        }
    }
    //random method for random selection of colors for bottles
//    public void RandomColor(Bottle bottle, String colorsString) {
//        String[] colors = colorsString.split("\\s+");
//
//        if (colors.length == 0) {
//            System.out.println("No colors provided.");
//            return;
//        }
//
//        // Shuffle the array of colors
//        List<String> colorList = Arrays.asList(colors);
//        Collections.shuffle(colorList);
//
//        // Assign colors to bottles based on the shuffled order
//        for (String color : colorList) {
//            bottle.insert(color);
//        }
//
////        Random random = new Random();
////        String randomColor = colors[random.nextInt(colors.length)];
////        bottle.insert(randomColor);
//    }
    //display method for displaying bottle stuff
    public void display(int maxbottlesize, ClinkedList bottleList , int selectedBottle){
        bottleList.show(maxbottlesize , selectedBottle);
    }
    //select method for choosing a bottle
    public Boolean select(int selectedBottle , ClinkedList bottleList , int maxbottlesize){
        Boolean isSelected = false;
        //Selected Bottle out of range
        if (selectedBottle > getNumberOfBottles()){
            System.out.println("!< Selected Bottle out of Range >!");
            isSelected = false;
        } else if (selectedBottle <= 0) {
            System.out.println("<! Please Enter a Number between 1 and " + getNumberOfBottles() + " >!");
            isSelected = false;
        }else {
            display(maxbottlesize , bottleList , selectedBottle - 1);
            System.out.println("Bottle " + selectedBottle + " selected Successfully !");
            isSelected = true;
        }
        return isSelected;
    }
    //deselect method for deselect a bottle
    public void deselect(){
        //implementation
    }
    //selectNext method for selecting next item
    public void selectNext(){

    }
    //selectPrev method for selectiong prev item
    public void selectPrev(){

    }
    //Pour method for pouring Bottles
    public Boolean pour(int bottleNumber){
        //implementation
        return true;
    }
    //Swap method for changing order of Bottles
    public void swap(int bottleNumber){

    }
    //ReplaceColor Method
    public void replaceColor(String firstColor, String secondColor){
        //implementation
    }
    //AddEmptyBottle method
    //Adds a bottle half the size of maxBottleSize to the end of the list of bottles. User until the end of the game only
    //He can use this feature once
    public void addEmptyBottle(){
        //implementation
    }
    //check to see if User had Won the Game or not
    public Boolean hasWon(){
        Boolean Haswon = false;
        //implementation
        return Haswon;
    }
    //Undo Method
    public void undo(){
        //implementation
    }
    //Redo Method
    public void redo(){
        //implementation
    }
}
