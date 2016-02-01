import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by  on 1/31/16.
 */
public interface Poker{

    //int collectAnte();

    //Player compareHand();

    //void dealRound(boolean x);

    void displayHands();

    //void allBet();

    default void fold(Player player) {
        player.getHands().get(0).getHand().clear();
    }


    default ArrayList<Integer> Poker(ArrayList<Player> players) {
        ArrayList<Hand> hands = new ArrayList<>();
        for (Player p: players){
            hands.add(p.getHands().get(0));
        }
        ArrayList<Integer> winners = new ArrayList<>();
        int actOn = -1;
        int winningHand = -1;
        ArrayList<Integer> winningKickers = new ArrayList<>();
        for (int i = 0; i <5; i++) {
            winningKickers.add(i,0);
        }
        ArrayList<Integer> handEvaluation = new ArrayList<>();
        for (Hand hand: hands) {
            actOn++;
            ArrayList<Integer> suits = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
            ArrayList<Integer> faces = new ArrayList<>();
            for (int i = 0; i < 13; i++) {
                faces.add(i, 0);
            }

            ArrayList<Card> cards = new ArrayList<Card>(hand.getHand());
            int kicker1 = -1;
            int kicker2 = -1;
            int kicker3 = -1;
            int kicker4 = -1;
            int kicker5 = -1;
            int i = 0;
            for (Card card : cards) {
                if (card.getSuit() == Suit.SPADES) {
                    suits.set(0, suits.get(0) + 1);
                } else if (card.getSuit() == Suit.CLUBS) {
                    suits.set(1, suits.get(1) + 1);
                } else if (card.getSuit() == Suit.DIAMONDS) {
                    suits.set(2, suits.get(2) + 1);
                } else if (card.getSuit() == Suit.HEARTS) {
                    suits.set(3, suits.get(3) + 1);
                }
                faces.set(i, faces.get(i) + 1);
            }
            String completed = "no";
            for (int suit : suits) {
                if (suit == 5) {
                    completed = "yes";
                    if (faces.get(0).equals(1) && faces.get(12).equals(1) && faces.get(11).equals(1) && faces.get(10).equals(1) &&
                            faces.get(9).equals(1)) {
                        handEvaluation.add(10);//royal flush
                        break;
                    } else if ((faces.get(8).equals(1) &&
                            faces.get(12).equals(1) &&
                            faces.get(11).equals(1) &&
                            faces.get(10).equals(1) &&
                            faces.get(9).equals(1)) ||
                            (faces.get(8).equals(1) &&
                                    faces.get(7).equals(1) &&
                                    faces.get(11).equals(1) &&
                                    faces.get(10).equals(1) &&
                                    faces.get(9).equals(1)) ||
                            (faces.get(8).equals(1) &&
                                    faces.get(7).equals(1) &&
                                    faces.get(6).equals(1) &&
                                    faces.get(10).equals(1) &&
                                    faces.get(9).equals(1)) ||
                            (faces.get(8).equals(1) &&
                                    faces.get(7).equals(1) &&
                                    faces.get(6).equals(1) &&
                                    faces.get(5).equals(1) &&
                                    faces.get(9).equals(1)) ||
                            (faces.get(8).equals(1) &&
                                    faces.get(7).equals(1) &&
                                    faces.get(6).equals(1) &&
                                    faces.get(5).equals(1) &&
                                    faces.get(4).equals(1)) ||
                            (faces.get(3).equals(1) &&
                                    faces.get(7).equals(1) &&
                                    faces.get(6).equals(1) &&
                                    faces.get(5).equals(1) &&
                                    faces.get(4).equals(1)) ||
                            (faces.get(3).equals(1) &&
                                    faces.get(2).equals(1) &&
                                    faces.get(6).equals(1) &&
                                    faces.get(5).equals(1) &&
                                    faces.get(4).equals(1)) ||
                            (faces.get(3).equals(1) &&
                                    faces.get(2).equals(1) &&
                                    faces.get(1).equals(1) &&
                                    faces.get(5).equals(1) &&
                                    faces.get(4).equals(1)) ||
                            (faces.get(3).equals(1) &&
                                    faces.get(2).equals(1) &&
                                    faces.get(1).equals(1) &&
                                    faces.get(0).equals(1) &&
                                    faces.get(4).equals(1))
                            ) {
                        handEvaluation.add(9);//straight flush
                        break;

                    } else {
                        handEvaluation.add(6);//flush
                        break;
                    }
                } else if (faces.get(0).equals(4) ||
                        faces.get(1).equals(4) ||
                        faces.get(2).equals(4) ||
                        faces.get(3).equals(4) ||
                        faces.get(4).equals(4) ||
                        faces.get(5).equals(4) ||
                        faces.get(6).equals(4) ||
                        faces.get(7).equals(4) ||
                        faces.get(8).equals(4) ||
                        faces.get(9).equals(4) ||
                        faces.get(10).equals(4) ||
                        faces.get(11).equals(4) ||
                        faces.get(12).equals(4)

                        ) {
                    handEvaluation.add(8);//four of a kind
                } else if (faces.get(0).equals(3) ||
                        faces.get(1).equals(3) ||
                        faces.get(2).equals(3) ||
                        faces.get(3).equals(3) ||
                        faces.get(4).equals(3) ||
                        faces.get(5).equals(3) ||
                        faces.get(6).equals(3) ||
                        faces.get(7).equals(3) ||
                        faces.get(8).equals(3) ||
                        faces.get(9).equals(3) ||
                        faces.get(10).equals(3) ||
                        faces.get(11).equals(3) ||
                        faces.get(12).equals(3)

                        ) {
                    if (faces.get(0).equals(2) ||
                            faces.get(1).equals(2) ||
                            faces.get(2).equals(2) ||
                            faces.get(3).equals(2) ||
                            faces.get(4).equals(2) ||
                            faces.get(5).equals(2) ||
                            faces.get(6).equals(2) ||
                            faces.get(7).equals(2) ||
                            faces.get(8).equals(2) ||
                            faces.get(9).equals(2) ||
                            faces.get(10).equals(2) ||
                            faces.get(11).equals(2) ||
                            faces.get(12).equals(2)) {
                        handEvaluation.add(7); //full house
                    } else {
                        handEvaluation.add(4);//three of a kind
                    }
                } else if ((faces.get(8).equals(1) &&
                        faces.get(12).equals(1) &&
                        faces.get(11).equals(1) &&
                        faces.get(10).equals(1) &&
                        faces.get(9).equals(1)) ||
                        (faces.get(8).equals(1) &&
                                faces.get(7).equals(1) &&
                                faces.get(11).equals(1) &&
                                faces.get(10).equals(1) &&
                                faces.get(9).equals(1)) ||
                        (faces.get(8).equals(1) &&
                                faces.get(7).equals(1) &&
                                faces.get(6).equals(1) &&
                                faces.get(10).equals(1) &&
                                faces.get(9).equals(1)) ||
                        (faces.get(8).equals(1) &&
                                faces.get(7).equals(1) &&
                                faces.get(6).equals(1) &&
                                faces.get(5).equals(1) &&
                                faces.get(9).equals(1)) ||
                        (faces.get(8).equals(1) &&
                                faces.get(7).equals(1) &&
                                faces.get(6).equals(1) &&
                                faces.get(5).equals(1) &&
                                faces.get(4).equals(1)) ||
                        (faces.get(3).equals(1) &&
                                faces.get(7).equals(1) &&
                                faces.get(6).equals(1) &&
                                faces.get(5).equals(1) &&
                                faces.get(4).equals(1)) ||
                        (faces.get(3).equals(1) &&
                                faces.get(2).equals(1) &&
                                faces.get(6).equals(1) &&
                                faces.get(5).equals(1) &&
                                faces.get(4).equals(1)) ||
                        (faces.get(3).equals(1) &&
                                faces.get(2).equals(1) &&
                                faces.get(1).equals(1) &&
                                faces.get(5).equals(1) &&
                                faces.get(4).equals(1)) ||
                        (faces.get(3).equals(1) &&
                                faces.get(2).equals(1) &&
                                faces.get(1).equals(1) &&
                                faces.get(0).equals(1) &&
                                faces.get(4).equals(1))
                        ) {
                    handEvaluation.add(5);//straight
                } else if (faces.get(0).equals(2) ||
                        faces.get(1).equals(2) ||
                        faces.get(2).equals(2) ||
                        faces.get(3).equals(2) ||
                        faces.get(4).equals(2) ||
                        faces.get(5).equals(2) ||
                        faces.get(6).equals(2) ||
                        faces.get(7).equals(2) ||
                        faces.get(8).equals(2) ||
                        faces.get(9).equals(2) ||
                        faces.get(10).equals(2) ||
                        faces.get(11).equals(2) ||
                        faces.get(12).equals(2)) {
                    if (faces.get(0).equals(faces.get(1)) ||
                            faces.get(0).equals(faces.get(2)) ||
                            faces.get(0).equals(faces.get(3)) ||
                            faces.get(0).equals(faces.get(4)) ||
                            faces.get(0).equals(faces.get(5)) ||
                            faces.get(0).equals(faces.get(6)) ||
                            faces.get(0).equals(faces.get(7)) ||
                            faces.get(0).equals(faces.get(8)) ||
                            faces.get(0).equals(faces.get(9)) ||
                            faces.get(0).equals(faces.get(10)) ||
                            faces.get(0).equals(faces.get(11)) ||
                            faces.get(0).equals(faces.get(12)) ||

                            faces.get(1).equals(faces.get(2)) ||
                            faces.get(1).equals(faces.get(3)) ||
                            faces.get(1).equals(faces.get(4)) ||
                            faces.get(1).equals(faces.get(5)) ||
                            faces.get(1).equals(faces.get(6)) ||
                            faces.get(1).equals(faces.get(7)) ||
                            faces.get(1).equals(faces.get(8)) ||
                            faces.get(1).equals(faces.get(9)) ||
                            faces.get(1).equals(faces.get(10)) ||
                            faces.get(1).equals(faces.get(11)) ||
                            faces.get(1).equals(faces.get(12)) ||

                            faces.get(2).equals(faces.get(3)) ||
                            faces.get(2).equals(faces.get(4)) ||
                            faces.get(2).equals(faces.get(5)) ||
                            faces.get(2).equals(faces.get(6)) ||
                            faces.get(2).equals(faces.get(7)) ||
                            faces.get(2).equals(faces.get(8)) ||
                            faces.get(2).equals(faces.get(9)) ||
                            faces.get(2).equals(faces.get(10)) ||
                            faces.get(2).equals(faces.get(11)) ||
                            faces.get(2).equals(faces.get(12)) ||

                            faces.get(3).equals(faces.get(4)) ||
                            faces.get(3).equals(faces.get(5)) ||
                            faces.get(3).equals(faces.get(6)) ||
                            faces.get(3).equals(faces.get(7)) ||
                            faces.get(3).equals(faces.get(8)) ||
                            faces.get(3).equals(faces.get(9)) ||
                            faces.get(3).equals(faces.get(10)) ||
                            faces.get(3).equals(faces.get(11)) ||
                            faces.get(3).equals(faces.get(12)) ||

                            faces.get(4).equals(faces.get(5)) ||
                            faces.get(4).equals(faces.get(6)) ||
                            faces.get(4).equals(faces.get(7)) ||
                            faces.get(4).equals(faces.get(8)) ||
                            faces.get(4).equals(faces.get(9)) ||
                            faces.get(4).equals(faces.get(10)) ||
                            faces.get(4).equals(faces.get(11)) ||
                            faces.get(4).equals(faces.get(12)) ||

                            faces.get(5).equals(faces.get(6)) ||
                            faces.get(5).equals(faces.get(7)) ||
                            faces.get(5).equals(faces.get(8)) ||
                            faces.get(5).equals(faces.get(9)) ||
                            faces.get(5).equals(faces.get(10)) ||
                            faces.get(5).equals(faces.get(11)) ||
                            faces.get(5).equals(faces.get(12)) ||

                            faces.get(6).equals(faces.get(7)) ||
                            faces.get(6).equals(faces.get(8)) ||
                            faces.get(6).equals(faces.get(9)) ||
                            faces.get(6).equals(faces.get(10)) ||
                            faces.get(6).equals(faces.get(11)) ||
                            faces.get(6).equals(faces.get(12)) ||

                            faces.get(7).equals(faces.get(8)) ||
                            faces.get(7).equals(faces.get(9)) ||
                            faces.get(7).equals(faces.get(10)) ||
                            faces.get(7).equals(faces.get(11)) ||
                            faces.get(7).equals(faces.get(12)) ||

                            faces.get(8).equals(faces.get(9)) ||
                            faces.get(8).equals(faces.get(10)) ||
                            faces.get(8).equals(faces.get(11)) ||
                            faces.get(8).equals(faces.get(12)) ||

                            faces.get(9).equals(faces.get(10)) ||
                            faces.get(9).equals(faces.get(11)) ||
                            faces.get(9).equals(faces.get(12)) ||

                            faces.get(10).equals(faces.get(11)) ||
                            faces.get(10).equals(faces.get(12)) ||

                            faces.get(11).equals(faces.get(12))) {
                        handEvaluation.add(3);//Two pair
                    } else {
                        handEvaluation.add(2); //one pair
                    }
                } else {
                    handEvaluation.add(0);
                }
                if (faces.get(0).equals(1)) {
                    kicker1 = 13;
                }
                if (faces.get(12).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 12;
                    } else {
                        kicker2 = 12;
                    }
                }
                if (faces.get(11).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 11;
                    } else if (kicker2 == -1) {
                        kicker2 = 11;
                    } else {
                        kicker3 = 11;
                    }
                }
                if (faces.get(10).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 10;
                    } else if (kicker2 == -1) {
                        kicker2 = 10;
                    } else if (kicker3 == -1) {
                        kicker3 = 10;
                    } else {
                        kicker4 = 10;
                    }
                }
                if (faces.get(9).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 9;
                    } else if (kicker2 == -1) {
                        kicker2 = 9;
                    } else if (kicker3 == -1) {
                        kicker3 = 9;
                    } else if (kicker4 == -1) {
                        kicker4 = 9;
                    } else {
                        kicker5 = 9;
                    }
                }
                if (faces.get(8).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 8;
                    } else if (kicker2 == -1) {
                        kicker2 = 8;
                    } else if (kicker3 == -1) {
                        kicker3 = 8;
                    } else if (kicker4 == -1) {
                        kicker4 = 8;
                    } else {
                        kicker5 = 8;
                    }
                }
                if (faces.get(7).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 7;
                    } else if (kicker2 == -1) {
                        kicker2 = 7;
                    } else if (kicker3 == -1) {
                        kicker3 = 7;
                    } else if (kicker4 == -1) {
                        kicker4 = 7;
                    } else {
                        kicker5 = 7;
                    }
                }
                if (faces.get(6).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 6;
                    } else if (kicker2 == -1) {
                        kicker2 = 6;
                    } else if (kicker3 == -1) {
                        kicker3 = 6;
                    } else if (kicker4 == -1) {
                        kicker4 = 6;
                    } else {
                        kicker5 = 6;
                    }
                }
                if (faces.get(5).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 5;
                    } else if (kicker2 == -1) {
                        kicker2 = 5;
                    } else if (kicker3 == -1) {
                        kicker3 = 5;
                    } else if (kicker4 == -1) {
                        kicker4 = 5;
                    } else {
                        kicker5 = 5;
                    }
                }
                if (faces.get(4).equals(1)) {
                    if (kicker1 == -1) {
                        kicker1 = 4;
                    } else if (kicker2 == -1) {
                        kicker2 = 4;
                    } else if (kicker3 == -1) {
                        kicker3 = 4;
                    } else if (kicker4 == -1) {
                        kicker4 = 4;
                    } else {
                        kicker5 = 4;
                    }
                }
                if (faces.get(3).equals(1)) {
                    if (kicker2 == -1) {
                        kicker2 = 3;
                    } else if (kicker3 == -1) {
                        kicker3 = 3;
                    } else if (kicker4 == -1) {
                        kicker4 = 3;
                    } else {
                        kicker5 = 3;
                    }
                }
                if (faces.get(2).equals(1)) {
                    if (kicker3 == -1) {
                        kicker3 = 2;
                    } else if (kicker4 == -1) {
                        kicker4 = 2;
                    } else {
                        kicker5 = 2;
                    }
                }
                if (faces.get(1).equals(1)) {
                    if (kicker1 == -1) {
                        kicker4 = 1;
                    } else {
                        kicker5 = 1;
                    }
                }
                if (faces.get(1).equals(1)) {
                    if (kicker5 == -1) {
                        kicker5 = 1;
                    }
                }
            }
            if (handEvaluation.get(actOn) == winningHand){
                String win = "no";
                if (kicker1 > winningKickers.get(0)) {
                    win = "yes";
                }
                else if (kicker1 == winningKickers.get(0)) {
                    if (kicker2 > winningKickers.get(1)) {
                        win = "yes";
                    }
                    else if(kicker2 == winningKickers.get(1)) {
                        if (kicker3 > winningKickers.get(2)) {
                            win = "yes";
                        }
                        else if(kicker3 == winningKickers.get(2)) {
                            if (kicker4 > winningKickers.get(3)) {
                                win = "yes";
                            }
                            else if(kicker4 == winningKickers.get(3)) {
                                if (kicker5 > winningKickers.get(4)) {
                                    win = "yes";
                                }
                                else if(kicker5 == winningKickers.get(4)) {
                                    win = "tie";
                                }
                            }
                        }
                    }
                }
                if (win == "yes" || win == "tie") {
                    if (win == "yes") {
                        winners = new ArrayList<>();
                        winningKickers = new ArrayList<>();
                        winningKickers.add(kicker1);
                        winningKickers.add(kicker2);
                        winningKickers.add(kicker3);
                        winningKickers.add(kicker4);
                        winningKickers.add(kicker5);
                    }
                    winners.add(actOn);
                }
            }
            else if (handEvaluation.get(actOn) > winningHand){
                winners = new ArrayList<>();
                winners.add(actOn);
                winningHand = handEvaluation.get(0);
            }
        }
        return winners;
    }
}
