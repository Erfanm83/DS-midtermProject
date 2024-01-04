//implementation of Stack with 1-D array
public class Bottle {
    int maxBottleSize;
    String[] bottleColors;
    int top;

    //constructor
    public Bottle(int maxBottleSize) {
        this.maxBottleSize = maxBottleSize;
        this.bottleColors = new String[maxBottleSize];
        this.top = -1;
    }

    // Pop item from stack
    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop!");
            return null;
        } else {
            String poppedColor = bottleColors[top];
            bottleColors[top] = null;
            top--;
            return poppedColor;
        }
    }

    // Insert an item to stack
    public boolean insert(String color) {
        if (top == maxBottleSize - 1) {
            return false;
        } else {
            top++;
            bottleColors[top] = color;
            return true;
        }
    }

    //retrieve the top color
    public String getTopColor() {
        for (int i = maxBottleSize - 1; i >= 0; i--) {
            if (bottleColors[i] != null) {
                return bottleColors[i];
            }
        }
        return null; // Return null for an empty bottle
    }

    public Boolean isEmpty() {
        return this.top == -1;
    }
}
