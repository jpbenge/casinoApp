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
        //String a = "1";//for testing only
        return a;
    }
}
