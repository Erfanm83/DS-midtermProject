import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        WaterSortGame waterSortGame = new WaterSortGame("blue green yellow" , 4);
        Bottle mybottle = new Bottle(4);
        Bottle mybottle2 = new Bottle(4);
        System.out.println(mybottle.insert("blue"));
        System.out.println(mybottle.insert("green"));
        System.out.println(mybottle.insert("yellow"));
        System.out.println(mybottle.insert("red"));
        System.out.println(mybottle2.insert("red"));
        System.out.println(mybottle2.insert("red"));
        System.out.println(mybottle2.insert("red"));
        System.out.println(mybottle2.insert("red"));
        System.out.println(mybottle2.insert("yellow"));
        ClinkedList bottleClinkedList = new ClinkedList();
        bottleClinkedList.AddCnode(mybottle);
        bottleClinkedList.AddCnode(mybottle2);
        waterSortGame.display(4 , 3 , bottleClinkedList);
    }

    private static void gameplay(LinkedList Bottles) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean selectNext = true;
        int EmptyBottles = 0;
        ListIterator<String> listIterator = Bottles.listIterator();

        if(Bottles.isEmpty()) {
            System.out.println("No Bottle in the itinerary");
            return;
        } else {
            System.out.println("Now play " + listIterator.next());
        }

        while (!quit) {
            String action = String.valueOf(scanner.nextLine().split(" "));
            switch(action) {
                case "start":
                    break;
                case "select":
//                    int selectedBottle = scanner.nextLine().split(" ");
                    break;
                case "deSelect":
                    break;
                case "selectNext":
                    if(!selectNext) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        selectNext = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now play " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        selectNext = false;
                    }
                    break;
                case "selectPrevious":
                    if(selectNext) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        selectNext = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        selectNext = true;
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
