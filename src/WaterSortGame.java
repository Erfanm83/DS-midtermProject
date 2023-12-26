import java.util.Arrays;
import java.util.Random;

public class WaterSortGame {
    private int numberOfBottles;
    private String colors;
    private int maxbottlesize;

    //circular Queue implementation with linkedList
    private ClinkedList bottleList;
    //constructor
    public WaterSortGame(String colors, int maxbottlesize) {
        //The number of spaces is one less than the number of colors
        //and the number of bottles are one greater than the number of colors
        this.numberOfBottles = WaterSortGame.countSpaces(colors) + 2;
        this.colors = new String(colors);
        this.maxbottlesize = maxbottlesize;
        this.bottleList = new ClinkedList();
        initialize(maxbottlesize, bottleList , colors);
    }

    private void initialize(int maxBottleSize , ClinkedList clinkedList , String colors){
        for (int i = 0; i < maxBottleSize; i++) {
            Bottle bottle = new Bottle(maxBottleSize);
            RandomColor(bottle , colors);
            clinkedList.AddCnode(bottle);
        }
    }

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
    //random method for random selection of colors for bottles
    public void RandomColor(Bottle bottle, String colorsString) {
        String[] colors = colorsString.split("\\s+");

        if (colors.length == 0) {
            System.out.println("No colors provided.");
            return;
        }

        Random random = new Random();
        String randomColor = colors[random.nextInt(colors.length)];
        insertColor(randomColor);
    }
    private void insertColor(String color) {
        if (colors.length() < this.maxbottlesize) {
            colors += color;
            System.out.println("Color '" + color + "' inserted into the bottle.");
        } else {
            System.out.println("Bottle is already full.");
        }
    }
    //display method for displaying bottle stuff
    public void display(int maxbottlesize, ClinkedList bottleList){
        bottleList.show(maxbottlesize);
    }
    //select method for choosing a bottle
    public Boolean select(int bottleNumber){
        Boolean isSelected = false;
        //implementation
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
        Boolean Haswon = true;
        //implementation
        return Haswon;
    }
    //Undo Method
    public void undo(){
        //implementation
    }
    //REdo Method
    public void redo(){
        //implementation
    }
}
