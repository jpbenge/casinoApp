import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by rkelly on 1/31/16.
 */
public class FiveReelSlot extends SlotMachines implements Slots  {

        private static int totalReels = 5;

        private ArrayList<ArrayList<Object>> payOuts = new ArrayList<ArrayList<Object>>();
        public void createPayOuts(int reels) {
            ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList("Bar", "Bar", "Bar", "Bar", "Bar", 30));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Seven", "Seven", "Seven", "Seven", "Seven", 25));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "Cherry", "Cherry", "Cherry", 20));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Orange", "Orange", "Orange", "Orange", "Orange", 15));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Diamond", "Diamond", "Diamond", "Diamond", "Diamond", 15));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Money", "Money", "Money", "Money", "Money", 15));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Heart", "Heart", "Heart", "Heart", "Heart", 15));
            payOuts.add(temp);

            temp = new ArrayList<Object>(Arrays.asList("Lemon", "Lemon", "Lemon", "Lemon", "Lemon", 8));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "Cherry", "Cherry", "", 8));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "Cherry", "", "Cherry", 8));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "", "Cherry", "Cherry", 8));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "Cherry", "Cherry", "Cherry", 8));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "Cherry", "Cherry", "Cherry", 8));
            payOuts.add(temp);


            temp = new ArrayList<Object>(Arrays.asList("", "", "Cherry", "Cherry", "Cherry", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "", "Cherry", "Cherry", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "Cherry", "", "Cherry", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "Cherry", "Cherry", "", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "", "Cherry", "Cherry", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "Cherry", "", "Cherry", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "Cherry", "Cherry", "", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "", "", "Cherry", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "", "Cherry", "", 2));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "Cherry", "", "", 2));
            payOuts.add(temp);



            temp = new ArrayList<Object>(Arrays.asList("", "", "", "Cherry", "Cherry", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "", "Cherry", "", "Cherry", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "", "Cherry", "Cherry", "", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "", "", "Cherry", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "", "Cherry", "", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "Cherry", "", "", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "", "", "Cherry", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "", "Cherry", "", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "Cherry", "", "", 1.25));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "", "", "", 1.25));
            payOuts.add(temp);


            temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "", "", "", 1));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "", "", "", 1));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "", "Cherry", "", "", 1));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "", "", "", "Cherry", 1));
            payOuts.add(temp);
            temp = new ArrayList<Object>(Arrays.asList("", "", "", "", "Cherry", 1));
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



