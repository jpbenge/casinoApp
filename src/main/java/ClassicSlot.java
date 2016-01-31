import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rkelly on 1/29/16.
 */


public class ClassicSlot extends SlotMachines implements Slots {

    private static int totalReels = 3;

    private ArrayList<ArrayList<Object>> payOuts = new ArrayList<ArrayList<Object>>();
    public void createPayOuts(int reels) {
        ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList("Lemon", "Lemon", "Lemon", 10));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Bar", "Bar", "Bar", 75));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Seven", "Seven", "Seven", 50));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "Cherry", 25));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Orange", "Orange", "Orange", 8));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Diamond", "Diamond", "Diamond", 8));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Money", "Money", "Money", 8));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Heart", "Heart", "Heart", 8));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Cherry", "Cherry", "", 3));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "Cherry", 3));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "Cherry", 3));
        payOuts.add(temp);

        temp = new ArrayList<Object>(Arrays.asList("Cherry", "", "", 1));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("", "Cherry", "", 1));
        payOuts.add(temp);
        temp = new ArrayList<Object>(Arrays.asList("", "", "Cherry", 1));
        payOuts.add(temp);
    }

    public ClassicSlot() {
        super(totalReels);
        createPayOuts(totalReels);

        String winner = super.calculateResults(payOuts);
        super.display(winner);
    }

}


