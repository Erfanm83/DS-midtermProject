import java.util.Scanner;

public class main {
    private static int maxBottleSize = 0;
    private static String bottleColors;
    private static WaterSortGame waterSortGame;
    private static ClinkedList clinkedList;

    public static void main(String[] args) {
        System.out.println("\u001B[32m" + "*** Welcome to WaterSortGame ***" + "\u001B[32m");
        Scanner scanner = new Scanner(System.in);
        String action = " ";

        while (!action.toLowerCase().contains("start")) {
            System.out.println("\u001B[33m" + "type \"start\" to Start Game..." + "\u001B[33m");
            action = scanner.nextLine();
        }
        System.out.println("\u001B[0m" + "Game started..." + "\u001B[0m");
        //asking to enter colors
        System.out.println("Please enter colors...");
        try {
            main.bottleColors = String.valueOf(scanner.nextLine());
        } catch (RuntimeException exception) {
            throw new RuntimeException("Please enter Valid Colors");
        }
        //asking for maxBottleSize
        System.out.println("Please enter Max Bottle Size...");
        try {
            main.maxBottleSize = scanner.nextInt();
            main.clinkedList = new ClinkedList();
            main.waterSortGame = new WaterSortGame(main.bottleColors, main.maxBottleSize, main.clinkedList);
            main.waterSortGame.display(main.maxBottleSize, main.clinkedList, 1, true);
            gameplay(main.waterSortGame, main.clinkedList);
        } catch (RuntimeException exception) {
            throw new RuntimeException("<! An Unexpected ERROR Just Happened !>");
        }
    }

    //The GamePlay of WaterSortGame all happens here
    private static void gameplay(WaterSortGame waterSortGame, ClinkedList bottleList) {
        Scanner scanner = new Scanner(System.in);
        String action = " ";
        boolean selectNext = true;
        int EmptyBottles = 0;
        int selectedBottle = 2;
        int undoRedo = 5;
        System.out.println("\u001B[0m" + "type any action to continue..." + "\u001B[0m");

        while (!waterSortGame.hasWon()) {
            action = scanner.nextLine();
            switch (action) {
                case "select":
                    System.out.println("enter bottle number from 1 to " + main.waterSortGame.getNumberOfBottles());
                    selectedBottle = scanner.nextInt();
                    waterSortGame.select(selectedBottle, bottleList, main.maxBottleSize);
                    break;
                case "deselect":
                    System.out.println("enter bottle number from 1 to " + main.waterSortGame.getNumberOfBottles());
                    int deselectedBottle = scanner.nextInt();
                    if (waterSortGame.deselect(deselectedBottle, selectedBottle, bottleList, main.maxBottleSize))
                        selectedBottle = -1;
                    break;
                case "selectnext":
                    if (selectedBottle == -1)
                        System.out.println("Please select a bottle first");
                    else {
                        waterSortGame.selectNext(selectedBottle, bottleList, main.maxBottleSize);
                        selectedBottle++;
                    }
                    break;
                case "selectprevious":
                    if (selectedBottle == -1)
                        System.out.println("Please select a bottle first");
                    else {
                        waterSortGame.selectPrev(selectedBottle, bottleList, main.maxBottleSize);
                        selectedBottle--;
                    }
                    break;
                case "pour":
                    if (selectedBottle == -1)
                        System.out.println("Please select a bottle first");
                    else {
                        int bottleToPour = scanner.nextInt();
                        if (selectedBottle == bottleToPour)
                            System.out.println("Please select a different bottle to pour");
                        else
                            waterSortGame.pour(bottleToPour, selectedBottle, bottleList, main.maxBottleSize);
                    }
                    break;
                case "swap":
                    int bottleToSwap = scanner.nextInt();
//                    waterSortGame.swap(bottleToSwap);
                    break;
                case "ReplaceColor":
                    String inputString = scanner.nextLine();
                    // Split the input string by space
                    String[] parts = inputString.split("\\s+");
                    if (parts.length == 2)
                        waterSortGame.replaceColor(parts[0], parts[1]);
                    else
                        System.out.println("please enter two colors separated by space.");
                    break;
                case "undo":
                    if (undoRedo > 0) {
                        waterSortGame.undo();
                        undoRedo--;
                    } else
                        System.out.println("you reached the maximum usage of undo.");
                    break;
                case "redo":
                    if (undoRedo > 0) {
                        waterSortGame.redo();
                        undoRedo--;
                    } else
                        System.out.println("you reached the maximum usage of redo.");
                    break;
                case "addEmptyBottle":
                    EmptyBottles++;
                    if (EmptyBottles == 1) {
                        waterSortGame.addEmptyBottle(main.maxBottleSize , bottleList);
                        main.waterSortGame.display(main.maxBottleSize, main.clinkedList, selectedBottle - 1, true);
                        main.waterSortGame.setNumberOfBottles(main.waterSortGame.getNumberOfBottles() + 1);
                        System.out.println("new Bottle added to ClinkedList Successfully. ");
                    } else
                        System.out.println("you reached the maximum usage of adding an empty Bottle");
                    break;
                default:
                    System.out.println("\u001B[0m" + "type any action to continue..." + "\u001B[0m");
                    break;
            }
        }
        System.out.println("\u001B[33m" + "*************************************************************************************************" + "\u001B[33m");
        System.out.println("\u001B[34m" + "###                           Congratulations, You won the Game !!!                           ###" + "\u001B[34m");
        System.out.println("\u001B[33m" + "*************************************************************************************************" + "\u001B[33m");
        System.out.println("\u001B[35m" + "Thanks for choosing my game to play !" + "\u001B[35m");
    }
}
