import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by rkelly on 1/29/16.
 */


public class ClassicSlot extends SlotMachines implements Slots {

    private static int totalReels = 3;

    private ArrayList<ArrayList<Object>> payOuts = new ArrayList<ArrayList<Object>>();
    public void createPayOuts(int reels) {
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList("Bar", "Bar", "Bar", 10));
        payOuts.add(temp);


        temp = new ArrayList<Object>(Arrays.asList("Seven", "Seven", "Seven", 8));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "Cherry", 5));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Lemon", "Lemon", "Lemon", 3));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Orange", "Orange", "Orange", 3));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Diamond", "Diamond", "Diamond", 3));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Money", "Money", "Money", 3));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Heart", "Heart", "Heart", 3));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "", 1.5));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "Cherry", 1.5));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "Cherry", 1.5));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "", 1));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "", 1));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("", "", "Cherry", 1));
        payOuts.add(temp);
    }

    public void exit() {
        System.out.println("You have cashed out with $" + PlayerManager.pc.getChips());
    }

    public void start() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            super.start(totalReels);
            createPayOuts(totalReels);
            String winner = super.calculateResults(payOuts);
            super.display(winner);
            System.out.println("Do you want to spin again?y/n");
            String restart = scan.nextLine();
            System.out.println("Current Chip Count: $" + PlayerManager.pc.getChips());
            if (restart.toLowerCase().contains("n")){
                exit();
                break;
            }
        }
    }

}


