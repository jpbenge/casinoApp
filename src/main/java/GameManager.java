import java.util.Scanner;

public class GameManager {
    static Game curGame;

    private void chooseGame() {
        Scanner sc = new Scanner(System.in);
        if (curGame == null) {
            System.out.println("What game would you like to play?\n\n Choose from: 'BlackJack', '5 Card Poker', or 'Slots'.");
            String gameChoice = sc.nextLine().toLowerCase();
            if (gameChoice.equals("blackjack")){

            } else if (gameChoice.equals("5 card poker")){

            } else if (gameChoice.equals("slots")){

            } else {
                System.out.println("That game does not exist in our Casino.");
            }
        }

    }

    public void start() {
        chooseGame();
    }

    public void exit() {

    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.start();
    }
}
