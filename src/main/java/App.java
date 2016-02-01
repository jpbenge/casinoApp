import java.util.*;

public class App {


    public static void main(String[] args) {

        System.out.println("Welcome to Ultra Pseudo Lego Ninja Casino");
        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager();

        playerManager.loadPlayer();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name to get started: ");
        String name = scan.nextLine();

        PlayerManager.pc.setName(name);


        gameManager.start();
    }
}