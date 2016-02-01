import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rkelly on 1/29/16.
 */
public interface Slots {

    ArrayList spin(int reels);
    String calculateResults(ArrayList reels);
    default String getBet() {
        Scanner scan = new Scanner(System.in);
        System.out.println("How much would you like to bet?");
        String a = scan.nextLine(); ///Comment out for testing only
        //String a = "10";//for testing only
        AudioManager am = new AudioManager("startSlotMachine.wav");
        am.play();

        try {
            Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return a;
    }
}
