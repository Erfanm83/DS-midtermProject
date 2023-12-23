import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        WaterSortGame waterSortGame = new WaterSortGame("blue green yellow cyan" , 4);
        Bottle mybottle = new Bottle(4);
        Bottle mybottle2 = new Bottle(4);
        Bottle mybottle3 = new Bottle(4);
        System.out.println(mybottle.insert("blue"));
        System.out.println(mybottle.insert("green"));
        System.out.println(mybottle.insert("yellow"));
        System.out.println(mybottle.insert("red"));
        System.out.println(mybottle2.insert("cyan"));
        System.out.println(mybottle2.insert("purple"));
        System.out.println(mybottle2.insert("red"));
        System.out.println(mybottle2.insert("green"));
        System.out.println(mybottle3.insert("red"));
        System.out.println(mybottle3.insert("purple"));
        System.out.println(mybottle3.insert("yellow"));
        System.out.println(mybottle3.insert("cyan"));
        ClinkedList bottleClinkedList = new ClinkedList();
        bottleClinkedList.AddCnode(mybottle);
        bottleClinkedList.AddCnode(mybottle2);
        bottleClinkedList.AddCnode(mybottle3);
        waterSortGame.display(4, bottleClinkedList);
        main.gameplay(bottleClinkedList);
    }

    //The GamePlay of WaterSortGame all happens here
    private static void gameplay(ClinkedList bottleList) {
        System.out.println("*** Welcome to WaterSortGame ***");
        Scanner scanner = new Scanner(System.in);
        String action = " ";
        boolean quit = false;
        boolean selectNext = true;
        int EmptyBottles = 0;
//        ListIterator<String> listIterator = bottleList.listIterator();

        if(bottleList.isEmpty()) {
            System.out.println("No Bottle in the itinerary");
            return;
        }
//        else {
//            System.out.println("Now play " + listIterator.next());
//        }
        while (!action.toLowerCase().contains("start")){
            System.out.println("type \"start\" to Start Game...");
            action = scanner.nextLine();
        }
        System.out.println("Game started...");
        //asking to enter colors
        System.out.println("Please enter colors to continue...");
        action = scanner.nextLine();
        while (action.matches(".*\\d.*")){
            System.out.println("Please enter colors NOT numbers, Try again...");
            action = scanner.nextLine();
        }
        //asking for maxBottleSize
        System.out.println("Please enter Max Bottle Size...");
        action = scanner.nextLine();
        while (!action.matches(".*\\d.*")){
            System.out.println("Please enter Max Bottle Size as a Number, Try again");
            action = scanner.nextLine();
        }
        System.out.println("type anything to continue...");
        while (!quit) {
            action = scanner.nextLine();
            switch(action) {
                case "select":
//                    int selectedBottle = scanner.nextLine().split(" ");
                    break;
                case "deSelect":
                    break;
                case "selectNext":
                    if(!selectNext) {
//                        if(listIterator.hasNext()) {
//                            listIterator.next();
//                        }
                        selectNext = true;
                    }
//                    if(listIterator.hasNext()) {
//                        System.out.println("Now play " + listIterator.next());
//                    } else {
//                        System.out.println("Reached the end of the list");
//                        selectNext = false;
//                    }
                    break;
                case "selectPrevious":
                    if(selectNext) {
//                        if(listIterator.hasPrevious()) {
//                            listIterator.previous();
//                        }
//                        selectNext = false;
//                    }
//                    if(listIterator.hasPrevious()) {
//                        System.out.println("Now visiting " + listIterator.previous());
//                    } else {
//                        System.out.println("We are at the start of the list");
//                        selectNext = true;
                    }
                    break;
                case "pour":
                    break;
                case "swap":
                    break;
                case "ReplaceColor":
                    break;
                case "undo":
                    break;
                case "redu":
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
