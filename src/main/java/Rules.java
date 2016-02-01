import java.util.Scanner;

/**
 * Created by rkelly on 2/1/16.
 */
public class Rules {
    public void rules(String gameName) {
        if(gameName.toLowerCase().contains("black")){
            System.out.println("Aces may be counted as 1 or 11 points, 2 to 9 according to pip value, and tens and face cards count as ten points. \n"+
            "The value of a hand is the sum of the point values of the individual cards. Except, a \"blackjack\" is the highest hand, consisting of an ace and any 10-point card, and it outranks all other 21-point hands.\n" +
                    "After the players have bet, the dealer will give two cards to each player and two cards to himself. One of the dealer cards is dealt face up. The facedown card is called the hole card.\n" +
                            "If the dealer does have a blackjack, then all wagers will lose, unless the player also has a blackjack, which will result in a push. The dealer will resolve insurance wagers at this time.\n" +
                            "Play begins with the player to the dealer's left. The following are the choices available to the player: \n" +
                            "Stand: Player stands pat with his cards.\n" +
                            "Hit: Player draws another card (and more if he wishes). If this card causes the player's total points to exceed 21 (known as \"busting\") then he loses.\n" +
                            "Double Down: Player doubles his bet and gets one, and only one, more card.\n" +
                            "After the player has had his turn, the dealer will turn over his card. If the dealer has 16 or less, then he will draw another card.\n" +
                            "If the dealer goes over 21 points, then if the didn't already bust will win player.\n" +
                            "If the dealer does not bust, then the higher point total between the player and dealer will win.\n" +
                    "Winning wagers pay even money, except a winning player blackjack usually pays 3 to 2.");
        }
        else if(gameName.toLowerCase().contains("stud")){
            System.out.println("All players place an ante in the pot.\n" +
            "Each player is dealt one card face down and one face up, and there is a betting round.\n" +
                    "Each player is dealt a third card face up. There is a second betting round.\n" +
            "Each player is dealt a fourth card face up. There is a third betting round.\n" +
            "Each player is dealt a fifth and card face down. There is a fourth betting round.\n" +
            "Surviving players show their cards and the best five-card hand wins the pot.\n\n" +
                    "The rank of hands from lowest to highest is:\n" +

            "high card\n" +
            "pair\n" +
            "4-straight\n" +
            "4-flush\n" +
            "two pair\n" +
            "three of a kind\n" +
            "straight\n" +
                    "flush\n" +
            "full house\n" +
            "four of a kind\n" +
            "straight flush");

        }
        else if (gameName.toLowerCase().contains("slots") || gameName.toLowerCase().contains("5") || gameName.toLowerCase().contains("3")) {
            System.out.println("The player places a bet.\n" +
                    "The reels will spin randomly.\n" +
                    "If the reels make a combination that is consider a \"Winner\", the slot will pay out the winning amount.\n\n"
                    );
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter when you are ready to continue.");
        String a = sc.nextLine();

    }

}
