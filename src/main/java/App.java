import java.util.*;

public class App {


    public static void main(String[] args) {

        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager();
        playerManager.loadPlayer();
        gameManager.start();

        //System.out.println("Welcome to Ultra Pseudo Lego Ninja Casino");
        //System.out.println("Enter your name to get started: ");

        // Scanner input = new Scanner("System.in");
        // String player = input.nextLine();

    }
}
