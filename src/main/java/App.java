import java.util.*;

public class App {


    public static void main(String[] args) {

        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager();


        System.out.println("Welcome to Ultra Pseudo Lego Ninja Casino");
        System.out.println("Enter your name to get started: ");

        // Scanner input = new Scanner("System.in");
        // String player = input.nextLine();
        /*
        BlackJack blackJack = new BlackJack();
        playerManager.loadPlayer();
        blackJack.start();
        System.out.println("Current Chip Count: $" + PlayerManager.pc.getChips());
        */

        FiveReelSlot slot = new FiveReelSlot();
        playerManager.loadPlayer();
        slot.start();
        System.out.println("Current Chip Count: $" + PlayerManager.pc.getChips());
        /*
        ClassicSlot slot = new ClassicSlot();
        playerManager.loadPlayer();
        slot.start();
        System.out.println("Current Chip Count: $" + PlayerManager.pc.getChips());
        */
    }
}
