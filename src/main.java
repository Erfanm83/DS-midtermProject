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
            main.waterSortGame.display(main.maxBottleSize, main.clinkedList, 1);
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
        int selectedBottle;
        System.out.println("\u001B[0m" + "type any action to continue..." + "\u001B[0m");


        while (!waterSortGame.hasWon()) {
            action = scanner.nextLine();
            switch (action) {
                case "select":
                    System.out.println("enter bottle number from 1 to " + main.waterSortGame.getNumberOfBottles());
                    selectedBottle = scanner.nextInt();
                    waterSortGame.select(selectedBottle, bottleList, main.maxBottleSize);
                    break;
                case "deSelect":
                    selectedBottle = scanner.nextInt();
                    waterSortGame.deselect();
                    break;
                case "selectNext":
                    selectedBottle = scanner.nextInt();
                    waterSortGame.selectNext();
                    if (!selectNext) {
                        selectNext = true;
                    }
                    break;
                case "selectPrevious":
                    if (selectNext) {
                    }
                    break;
                case "pour":
                    selectedBottle = scanner.nextInt();
                    waterSortGame.pour(selectedBottle);
                    break;
                case "swap":
                    selectedBottle = scanner.nextInt();
                    waterSortGame.swap(selectedBottle);
                    break;
                case "ReplaceColor":
                    break;
                case "undo":
                    waterSortGame.undo();
                    break;
                case "redu":
                    waterSortGame.redo();
                    break;
                case "addEmptyBottle":
                    EmptyBottles++;
                    if (EmptyBottles == 1) {

                    }
                    break;
                default:
                    System.out.println("\u001B[0m" + "type any action to continue..." + "\u001B[0m");
//                    System.out.println("\u001B[31m" + "Sorry , action you typed not recognized . try again" + "\u001B[31m");
                    break;
            }
        }
        System.out.println("********************************");
        System.out.println("\u001B[34m" + "Congratulations, You won the Game !!!" + "\u001B[34m");
        System.out.println("********************************");
        System.out.println("\u001B[35m" + "Thanks for choosing my game to play !" + "\u001B[35m");
    }
}
