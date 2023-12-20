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
        if (Bottle.isEmpty(this.top)) {
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
            System.out.println("Stack is full, cannot insert more bottles!");
            return false;
        } else {
            top++;
            bottleColors[top] = color;
            return true;
        }
    }

    public static Boolean isEmpty(int top) {
        return top == -1;
    }

    // Get element at a specific index
    public String getElementAt(int index) {
        if (index < 0 || index > top) {
            System.out.println("Invalid index!");
            return null;
        }
        return bottleColors[index];
    }

    public int getMaxBottleSize() {
        return maxBottleSize;
    }

    // Override toString method
    @Override
    public String toString() {
        if (bottleColors == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|    |\n".repeat(Math.max(0, maxBottleSize)));
            return "| Empty |";
        }

        StringBuilder result = new StringBuilder();
        for (int i = bottleColors.length - 1; i >= 0; i--) {
            String color = bottleColors[i];
            if (color != null) {
                result.append(String.format("| %-6s |\n", color));
            }
        }
        if (result.length() == 0) {
            return "| Empty |";
        }
        return result.toString();
    }
}
