import java.util.LinkedList;

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
        this.colors = colors;
        this.maxbottlesize = maxbottlesize;
        this.bottleList = new ClinkedList();
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
    private static void randomColor(Bottle bottle){

    }
    //display method for displaying bottle stuff
    public void display(int maxbottlesize , int colorNumber , ClinkedList bottleList){
//        Bottle temp = new Bottle(maxbottlesize);
        bottleList.show();
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
}
