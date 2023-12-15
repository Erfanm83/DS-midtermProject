//implementation of Stack with 1-D array
public class Bottle {
    int maxBottleSize;
    String[] bottleColors;

    //constructor
    public Bottle(int maxBottleSize) {
        this.maxBottleSize = maxBottleSize;
    }

    //pop item from stack
    public String pop(){
        int i = 0;
        if (bottleColors.length == 0){
            System.out.println("Bottle is Empty , cannot delete color !");
            return null;
        }else {
            while (bottleColors[i] != null){
                i++;
            }
            String deletedColor = bottleColors[i-1];
            bottleColors[i-1] = null;
            return deletedColor;
        }
    }

    //insert an item to stack
    public Boolean insert(String color){
        int i = 0;
        if (bottleColors.length == maxBottleSize){
            System.out.println("Bottle is full , cannot add color anymore !");
            return false;
        }else {
            while (bottleColors[i] != null){
                i++;
            }
            bottleColors[i] = color;
            return true;
        }
    }
}
