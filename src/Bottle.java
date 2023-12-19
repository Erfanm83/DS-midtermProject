//implementation of Stack with 1-D array
public class Bottle {
    int maxBottleSize;
    String[] bottleColors;

    //constructor
    public Bottle(int maxBottleSize) {
        this.maxBottleSize = maxBottleSize;
        this.bottleColors = new String[maxBottleSize];  // Initialize the array with the specified size
    }

    //pop item from stack
    public String pop() {
        int i = 0;
        if (bottleColors.length == 0) {
            System.out.println("Bottle is Empty , cannot delete color !");
            return null;
        } else {
            while (bottleColors[i] != null) {
                i++;
            }
            String deletedColor = bottleColors[i - 1];
            bottleColors[i - 1] = null;
            return deletedColor;
        }
    }

    //insert an item to stack
    public Boolean insert(String color) {
        if (this.bottleColors != null) {
            if (bottleColors.length == maxBottleSize) {
                System.out.println("Bottle is full, cannot add color anymore!");
                return false;
            } else {
                int i = 0;
                while (i < bottleColors.length && bottleColors[i] != null) {
                    i++;
                }
                bottleColors[i] = color;
                return true;
            }
        }
        return false;
    }

    // Override toString method
    @Override
    public String toString() {
        if (bottleColors == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("|      |\n".repeat(Math.max(0, maxBottleSize)));
            return "| Empty Kooni |";
        }

        StringBuilder result = new StringBuilder();
        for (String color : bottleColors) {
            if (color != null) {
                result.append(String.format("| %-30s |\n", color));
            }
        }

        if (result.length() == 0) {
            return "| Empty |";
        }

        return result.toString();
    }
}
