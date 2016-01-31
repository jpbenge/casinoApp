import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by johnb on 1/30/16.
 */
public class BlackJack extends CardGame {

    private int numOfDecks = 3;
    private boolean busted = false;
    private int bet;
    Scanner sc = new Scanner(System.in);
    int total;

    protected Deck deck;


    public void start() {
        deck = new Deck(numOfDecks);
        deck.shuffle();
        playerList = new ArrayList<Player>();
        PlayerManager.pc.getHands().clear();
        PlayerManager.pc.getHands().add(new Hand());
        playerList.add(PlayerManager.pc);
        for (int i = 0; i < 5; i++) {
            Player npc = new Player();
            npc.setNPC(true);
            playerList.add(npc);
            npc.getHands().clear();
            npc.getHands().add(new Hand());
        }
        System.out.println("How much would you like to bet?");
        int bet = sc.nextInt();
        sc.nextLine();
        setCurrentBet(bet, PlayerManager.pc);
        dealAll();
        displayHands();

    }
    private int checkCard(Card c) {
        if (c.getNumber() > 10) {
            return 10;
        }
        return c.getNumber();
    }



    private void dealAll() {
        for (int i = 0; i < (playerList.size() -2); i++) {
           playerList.get(i).getHands().get(0).addCard(deck.dealCard());
           playerList.get(i).getHands().get(0).addCard(deck.dealCard());
        }
        playerList.get(playerList.size() -1).getHands().get(0).addCard(deck.dealCard());
        playerList.get(playerList.size() -1).getHands().get(0).addCard(deck.dealCard(),false);

    }

    private boolean compareHand() {
        return true;
    }


    private void displayHands() {
        System.out.println("Dealer hand ");
        playerList.get(playerList.size() - 1).getHands().get(0).display();
        System.out.println("\n Player hand ");
        playerList.get(0).getHands().get(0).display();
        checkTotal(PlayerManager.pc);



    }
    private void askNextStep() {
        System.out.println("What would you like to do? 'Hit', 'Stay', 'Split' or 'Double Down'");
        String answer = sc.nextLine().toLowerCase();
        while (!answer.equals("hit") && !answer.equals ("stay") && !answer.equals ("split") && !answer.equals("double down")) {
            System.out.println("What??? Try again. 'Hit', 'Stay', 'Split' or 'Double Down' ");
            answer = sc.nextLine().toLowerCase();
        }
        switch (answer) {
            case "hit":
                hit(PlayerManager.pc);
                displayHands();
                break;
            case "stay":
                stay();
                break;
            case "split":
                break;
            case "double down":
                doubleDown(PlayerManager.pc);
                break;
            default:
                System.out.println("Computer Error - come back tomorrow");

        }

    }
    private void hit(Player hitPlayer) {
        hitPlayer.getHands().get(0).addCard(deck.dealCard());

    }
    private void stay() {
        playerList.get(playerList.size() -1).getHands().get(0).getHand().get(1).setFaceUp(true);
        while (checkTotal(playerList.get(playerList.size() -1)) < 17) {
            hit(playerList.get(playerList.size() -1));
        }
        displayHands();
    }
    private int checkTotal(Player currentPlayer) {

        total = 0;
        for (Card c: currentPlayer.getHands().get(0).getHand()) {
            total += checkCard(c);
        }
        System.out.println(total);
        if (currentPlayer.equals(playerList.get(0))) {
            if (total > 21) {
                //    displayHands();
                System.out.println("You know the point is to get to 21 not " + total);
                //    currentPlayer.removeChips(bet);
                System.out.println("Do you want to play again?");
                String answer = sc.nextLine();
                if (answer.equals("y")) {
                    start();
                }
            } else if (total == 21) {
                System.out.println("21!");
                PlayerManager.pc.addChips(bet);
                System.out.println("Do you want to play again?");
                String answer = sc.nextLine();
                if (answer.equals("y")) {
                    start();
                }
            } else {
             //   displayHands();
            //    askNextStep();
            }
        }
            return total;
        }

    private void doubleDown(Player ddPlayer) {
        hit(ddPlayer);
        bet = bet * 2;
    }

    private void split() {

    }
}
