import java.util.Scanner;

public class main {
    private static int maxBottleSize;
    private static String bottleColors;
    private static WaterSortGame waterSortGame ;

    public static void main(String[] args) {
        System.out.println("*** Welcome to WaterSortGame ***");
        Scanner scanner = new Scanner(System.in);
        String action = " ";

        while (!action.toLowerCase().contains("start")){
            System.out.println("type \"start\" to Start Game...");
            action = scanner.nextLine();
        }
        System.out.println("Game started...");
        //asking to enter colors
        System.out.println("Please enter colors...");
        try {
            main.bottleColors = String.valueOf(scanner.nextLine());
        }catch (RuntimeException exception){
            throw new RuntimeException("Please enter Valid Colors");
        }
        //asking for maxBottleSize
        System.out.println("Please enter Max Bottle Size...");
        try {
            main.maxBottleSize = Integer.parseInt(scanner.nextLine());
            main.waterSortGame = new WaterSortGame(main.bottleColors , main.maxBottleSize);
        }catch (RuntimeException exception){
            throw new RuntimeException("Please enter Max Bottle Size as a number");
        }
        System.out.println("type anything to continue...");
    }

    //The GamePlay of WaterSortGame all happens here
    private static void gameplay(ClinkedList bottleList) {
        System.out.println("*** Welcome to WaterSortGame ***");
        Scanner scanner = new Scanner(System.in);
        String action = " ";
        boolean quit = false;
        boolean selectNext = true;
        int EmptyBottles = 0;
        int selectedBottle;

        while (!quit) {
            action = scanner.nextLine();
            switch(action) {
                case "select":
                    selectedBottle = scanner.nextInt();
                    main.waterSortGame.select(selectedBottle);
                    break;
                case "deSelect":
                    selectedBottle = scanner.nextInt();
                    main.waterSortGame.deselect();
                    break;
                case "selectNext":
                    selectedBottle = scanner.nextInt();
                    main.waterSortGame.selectNext();
                    if(!selectNext) {
//                        }
                        selectNext = true;
                    }
                    break;
                case "selectPrevious":
                    if(selectNext) {
                    }
                    break;
                case "pour":
                    selectedBottle = scanner.nextInt();
                    main.waterSortGame.pour(selectedBottle);
                    break;
                case "swap":
                    selectedBottle = scanner.nextInt();
                    main.waterSortGame.swap(selectedBottle);
                    break;
                case "ReplaceColor":
                    break;
                case "undo":
                    main.waterSortGame.undo();
                    break;
                case "redu":
                    main.waterSortGame.redo();
                    break;
                case "addEmptyBottle":
                    EmptyBottles ++;
                    if (EmptyBottles == 1){

                    }
                    break;
                case "quit":
                    System.out.println("Thanks for choosing my game to play !");
                    quit = true;
                    break;

            }
        }
    }
}
