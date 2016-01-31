import javafx.print.PageLayout;

import java.util.ArrayList;
import java.util.SortedMap;

/**
 * Created by johnb on 1/30/16.
 */
public class BlackJack extends CardGame {

    private int numOfDecks = 3;
    private boolean exit = false;
    //int total;

    private Deck deck;


    public void start() {
        exit = false;
        initPlayers();
        while (!exit) {
            newRound();
            dealAll();
            displayHands();
            evaluatePlayerHand();
            checkTotal(PlayerManager.pc);
        }

    }
    //add players to the player list
    private void initPlayers() {
        playerList = new ArrayList<Player>();
        playerList.add(PlayerManager.pc);
        for (int i = 0; i < 5; i++) {
            Player npc = new Player();
            npc.setNPC(true);
            playerList.add(npc);
        }
    }
    //clear any previous hands and re-shuffle deck
    private void newRound() {
        deck = new Deck(numOfDecks);
        deck.shuffle();
        for(Player p :playerList)
        {
            p.getHands().clear();
            p.getHands().add(new Hand());
        }
        System.out.println("You have "+PlayerManager.pc.getChips()+" chips");
        System.out.println("How much would you like to bet?");
        int bet = sc.nextInt();
        sc.nextLine();
        setCurrentBet(bet, PlayerManager.pc);
        System.out.println("Current bet: "+currentBet);
    }
    //return the correct value for a card
    private int checkCard(Card c) {

        if (c.getNumber() > 10) {
            return 10;
        }
        else if (c.getNumber() == 1)
        {
            return 11;
        }
        return c.getNumber();
    }


    //deal everybody 2 cards
    private void dealAll() {
        for (int i = 0; i < (playerList.size() -2); i++) {
           playerList.get(i).getHands().get(0).addCard(deck.dealCard());
           playerList.get(i).getHands().get(0).addCard(deck.dealCard());
        }
        //dealer's second card is face down
        playerList.get(playerList.size() -1).getHands().get(0).addCard(deck.dealCard());
        playerList.get(playerList.size() -1).getHands().get(0).addCard(deck.dealCard(),false);

    }


    private void displayHands() {
        System.out.println("Dealer's hand:");
        playerList.get(playerList.size() - 1).getHands().get(0).display();
        if (!playerList.get(playerList.size()-1).getHands().get(0).getHand().get(1).isFaceUp())
        {
            System.out.println("\nDealer showing "+ checkCard(playerList.get(playerList.size()-1).getHands().get(0).getHand().get(0)));
        }
        else
        {
            System.out.println("\nDealer has "+ checkTotal(playerList.get(playerList.size()-1)));
        }
        System.out.println("\nPlayer hand:");
        playerList.get(0).getHands().get(0).display();
        System.out.println("You have "+checkTotal(playerList.get(0)));

    }

    private void evaluatePlayerHand() {
        int total = checkTotal(PlayerManager.pc);
        if (total > 21) {
            System.out.println("You Bust");
            askPlayAgain();

        } else if (total == 21) {
            System.out.println("21!");
            stay();
        } else
        {
            askNextStep();
        }
    }

    private void askPlayAgain() {
        if (PlayerManager.pc.getChips() > 0) {
            System.out.println("Do you want to play again? Y/N");
            String answer = sc.nextLine().toLowerCase();
            while (!answer.equals("y") && !answer.equals("n") && !answer.equals("yes") && !answer.equals("no")) {
                System.out.println("Please specify 'Y' or 'N'");
                answer = sc.nextLine().toLowerCase();
            }
            if (answer.equals("n") || answer.equals("no")) {
                exit = true;
            }
        }
        else
        {
            System.out.println("You are out of chips.");
            exit = true;
        }

    }
    private void askNextStep() {
        System.out.println("What would you like to do? 'Hit', 'Stay' or 'Double Down'");
        String answer = sc.nextLine().toLowerCase();
        while (!answer.equals("hit") && !answer.equals ("stay") && !answer.equals("double down")) {
            System.out.println("What??? Try again. 'Hit', 'Stay', or 'Double Down' ");
            answer = sc.nextLine().toLowerCase();
        }
        switch (answer) {
            case "hit":
                hit(PlayerManager.pc);
                displayHands();
                evaluatePlayerHand();
                break;
            case "stay":
                stay();
                break;
            case "split":
                break;
            case "double down":
                doubleDown(PlayerManager.pc);
                displayHands();
                evaluatePlayerHand();
                break;
            default:
                System.out.println("Computer Error - come back tomorrow");
                break;
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
        if (checkTotal(playerList.get(playerList.size()-1)) > 21)
        {
            System.out.println("Dealer busts. You Win!");
            System.out.println("Payout: "+currentBet);
            payOut(currentBet*2,PlayerManager.pc);
        }
        else if (checkTotal(playerList.get(0)) > checkTotal(playerList.get(playerList.size()-1)))
        {
            System.out.println("You beat the dealer!");
            System.out.println("Payout: "+currentBet);
            payOut(currentBet*2,PlayerManager.pc);
        }
        else if (checkTotal(playerList.get(0)) == checkTotal(playerList.get(playerList.size()-1)))
        {
            System.out.println("You tied the dealer. House wins");
        }
        else
        {
            System.out.println("You lost");
        }
        askPlayAgain();
    }
    public int checkTotal(Player currentPlayer) {

        int total = 0;
        int numAces = 0;
        for (Card c : currentPlayer.getHands().get(0).getHand()) {
            if (c.getNumber() == 1)
            {
                numAces++;
            }
            total += checkCard(c);
        }
        //ace logic
        while (total > 21 && numAces > 0)
        {
            total -= 10;
            numAces--;
        }
        return total;
    }
    //double bet and hit
    private void doubleDown(Player ddPlayer) {
        ddPlayer.removeChips(currentBet);
        currentBet *= 2;
        hit(ddPlayer);
    }

    private void split() {

    }
}
