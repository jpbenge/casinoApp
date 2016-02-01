import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by johnb on 1/31/16.
*/
public class FiveCardStud extends CardGame {
    private int numOfDecks = 1;
    private boolean firstBettingRound;
    private boolean firstRound;
    private int curentBet;
    private Random random = new Random();


    Deck deck;

    public void start() {
        exit = false;
        initPlayers();
        for (Player p : playerList)
        {
            if (p.isNPC())
            {
                p.addChips(100000000000L);
            }
        }
        while (!exit) {
            collectAnte();
            newRound();
            dealFirstRound();
            firstRound = true;
            firstBettingRound = true;
            displayHands();
            currentBet = 0;
            bettingRound();
            dealMiddleRound();
            firstRound = false;
            firstBettingRound = true;
            displayHands();
            bettingRound();
            firstBettingRound = true;
            dealMiddleRound();
            displayHands();
            bettingRound();
            firstBettingRound = true;
            dealFinalRound();
            displayHands();
            bettingRound();
            //compareHands();
            //distributePot();
            //continuePrompt();
            exit = true;
        }

    }

    private void newRound() {
        deck = new Deck(numOfDecks);
        deck.shuffle();
        for (Player p : playerList) {
            p.getHands().clear();
            p.getHands().add(new Hand());
        }

    }

    //deal everybody 2 cards
    private void dealFirstRound() {
        for (int i = 1; i < playerList.size(); i++) {
            playerList.get(i).getHands().get(0).addCard(deck.dealCard(), false);
            playerList.get(i).getHands().get(0).addCard(deck.dealCard());
        }
        //Player's cards
        playerList.get(0).getHands().get(0).addCard(deck.dealCard());
        playerList.get(0).getHands().get(0).addCard(deck.dealCard());

    }

    private void dealMiddleRound() {
        for (int i = 0; i < playerList.size(); i++)
        {
            playerList.get(i).getHands().get(0).addCard(deck.dealCard());
        }
    }

    private void dealFinalRound() {
        for (int i = 1; i < playerList.size(); i++) {
            playerList.get(i).getHands().get(0).addCard(deck.dealCard(), false);
        }
        //Player's cards
        playerList.get(0).getHands().get(0).addCard(deck.dealCard());
    }

    private int checkCardPoker(Card c) {
        if (c.getNumber() == 1) {
            return 14;
        }
        return c.getNumber();
    }

    private int rankHand(boolean firstRound) {
        if (firstRound) {
            int low = 0;
            for (int i = 1; i < playerList.size(); i++) {
                if (checkCardPoker(playerList.get(i).getHands().get(0).getHand().get(1))
                        < checkCardPoker(playerList.get(low).getHands().get(0).getHand().get(1))) {
                    low = (i);
                }
            }
            return low;
        }
        return 0;
    }
    private String getDecision(String[] args)
    {
        String message = "Would you like to ";
        for (int i = 0;i < args.length-1;i++)
        {
            message += "'"+args[i]+"', ";
        }
        message += "or '"+args[args.length-1]+"'";
        String input = "";
        boolean matches;


        do
        {
            matches = false;
            System.out.println(message);
            input = sc.nextLine().toLowerCase();
            for (String s : args)
            {
                if (input.equals(s))
                {
                    matches = true;
                }
            }


        } while (!matches);

        return input;
    }
    private void decision(Player p) {
        if (!p.isNPC()) {
            if (firstBettingRound && currentBet == 0) {
                //System.out.println("Would you like to bet, check or fold?");
                //String answer = sc.nextLine().toLowerCase();
                String answer = getDecision(new String[]{"bet","check","fold"});
                switch (answer) {
                    case "check":
                        call(p);
                        break;
                    case "bet":
                        raise(p);
                        break;
                    case "fold":
                        fold(p);
                        break;
                    default:
                        call(p);
                        break;
                }
            } else {
                    //System.out.println("Would you like to raise, call or fold?");
                    //String answer = sc.nextLine().toLowerCase();
                    String answer = getDecision(new String[]{"raise","call","fold"});
                    switch (answer) {
                        case "call":
                            call(p);
                            break;
                        case "raise":
                            raise(p);
                            break;
                        case "fold":
                            fold(p);
                            break;
                        default:
                            call(p);
                            break;
                    }
            }
        } else {
            int choice = (int) (1 + Math.random() * 10);
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    call(p);
                    break;
                case 7:
                    raise(p);
                    break;
                case 8:
                case 9:
                case 10:
                    fold(p);
                    break;
                default:
                    call(p);
                    break;
            }
        }
    }

    private int call(Player p) {
        if (firstBettingRound) {
            if (currentBet > 0)
            {
                if (!p.isNPC()) {
                    System.out.println("You called");
                } else {
                    System.out.println("NPC called");
                }
            }
            else {
                if (!p.isNPC()) {
                    System.out.println("You checked");
                } else {
                    System.out.println("NPC checked");
                }
            }
        } else {
            if (!p.isNPC()) {
                System.out.println("You called");
            } else {
                System.out.println("NPC called");
            }
        }
        p.setCurrentBet(currentBet);
        p.removeChips(currentBet);
        pot += currentBet;
        return pot;
    }

    private int raise(Player p) {
        int raise = 0;
        if (!p.isNPC())
        {
            if (firstBettingRound)
                System.out.println("How much would you like to bet?");
            else
                System.out.println("How much would you like to raise?");
            raise = sc.nextInt();
            sc.nextLine();
        }
        else {
            raise += 20;
        }

        currentBet += raise;
        if (currentBet > raise)
        {
            if (!p.isNPC())
            {
                System.out.println("You raised by " + raise);
            }
            else
            {
                System.out.println("NPC raised by " + raise);
            }
            System.out.println("bet is now "+(currentBet));
        }
        else
        {
            if (!p.isNPC())
            {
                System.out.println("You placed a bet of " + raise);
            }
            else
            {
                System.out.println("NPC placed a bet of " + raise);
            }
        }
        p.setCurrentBet(currentBet);
        p.removeChips(currentBet);
        pot += currentBet;
        return pot;
    }


    private void fold(Player p) {
        p.setFolded(true);
        if (!p.isNPC()) {

        }
        else
        {
            System.out.println("NPC folded");
        }
    }

    private void bettingRound() {
        currentBet = 0;
        int start = rankHand(firstRound);

        for (int i = start; i < start + playerList.size(); i++) {
            if (!playerList.get(i % playerList.size()).isFolded()) {
                decision(playerList.get(i % playerList.size()));
            }
        }
        firstRound = false;

        boolean playerMustCall;
        do
        {
            playerMustCall = false;
            for (int i = start; i < start + playerList.size(); i++) {
                if (!playerList.get(i% playerList.size()).isFolded()
                   && playerList.get(i% playerList.size()).getCurrentBet() < currentBet)
                {
                    playerMustCall = true;
                    decision(playerList.get(i% playerList.size()));
                }
            }
        } while (playerMustCall);


    }


        private void displayHands () {
            for (int i = 1; i < playerList.size(); i++) {
                if (!playerList.get(i).isFolded()) {
                    System.out.print("\nPlayer " + i + " \n");
                    playerList.get(i).getHands().get(0).display();
                }
            }
            if (!playerList.get(0).isFolded()) {
                System.out.println("\nPlayer hand:");
                playerList.get(0).getHands().get(0).display();
            }
        }


}

