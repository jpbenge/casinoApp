import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by rkelly on 1/29/16.
 */

public class SlotMachines extends ChanceGames implements Slots, Cloneable {
    //ArrayList<String> reel1 = new ArrayList<String>(Arrays.asList("Diamond","Orange","Lemon","Money","Cherry","Heart","Orange","Diamond","Lemon","Cherry","Money","Heart","Orange","Seven","Diamond","Orange","Lemon","Money","Cherry","Heart","Diamond","Bar","Lemon","Money","Seven","Heart","Diamond","Orange","Lemon","Money","Seven","Heart","Cherry"));
    //ArrayList<String> reelOther = new ArrayList<String>(Arrays.asList("Lemon","Diamond","Orange","Heart","Cherry","Money","Lemon","Heart","Diamond","Orange","Seven","Money","Lemon","Heart","Diamond","Orange","Cherry","Money","Lemon","Heart","Diamond","Orange","Bar","Money","Lemon","Heart","Diamond","Orange","Cherry","Money","Lemon","Heart","Diamond","Orange","Money"));
    ArrayList<String> reel1 = new ArrayList<String>(Arrays.asList("Diamond","Money","Cherry","Heart","Diamond","Cherry","Money","Heart","Seven","Diamond","Money","Cherry","Heart","Diamond","Bar","Money","Seven","Heart","Diamond","Money","Seven","Heart","Cherry"));
    ArrayList<String> reelOther = new ArrayList<String>(Arrays.asList("Diamond","Heart","Cherry","Money","Heart","Diamond","Seven","Money","Heart","Diamond","Cherry","Money","Heart","Diamond","Bar","Money","Heart","Diamond","Cherry","Money","Heart","Diamond","Money"));

    ArrayList<ArrayList<String>> reels = new ArrayList<ArrayList<String>>();

    int totalReels;

    public void start(int totalReels) {
        reels.clear();
        this.totalReels = totalReels;
        String a;
        boolean b = false;
        int c = 0;
        while (!b){
            try {
                a = getBet();
                c = Integer.parseInt(a);
                if (PlayerManager.pc.getChips()-c >= 0) {
                    b = true;
                }
                else if (PlayerManager.pc.getChips() < minLimit) {
                    System.out.println("Error: you do not have enough chips to continue.");
                    exit();
                    break;
                }
                else {
                    System.out.println("Error: you do not have that many chips.");
                }
            } catch (Exception e) {
                System.out.println("Error: please enter a valid number.");
            }
        }

        if (PlayerManager.pc.getChips() > minLimit) {
            setCurrentBet(c, PlayerManager.pc);

            ArrayList<Integer> rotations = spin(totalReels);
            ArrayList<ArrayList> temp = new ArrayList<ArrayList>();
            for (int i = 0; i < totalReels; i++) {
                if (i == 0) {
                    Collections.rotate(reel1, rotations.get(0));
                    reels.add(reel1);
                } else {
                    ArrayList copy = (ArrayList) reelOther.clone();
                    //System.out.println(copy.toString());
                    Collections.rotate(copy, rotations.get(i));
                    //System.out.println(copy.toString());
                    reels.add(copy);
                }
            }
            System.out.println(reels.toString());
        }
    }

    public void exit() {
        if (PlayerManager.pc.getChips() > 0 ) {
            System.out.println("You have cashed out with $" + PlayerManager.pc.getChips());
        }
    }

    public void display(String winner){
        ArrayList curReel = new ArrayList();
        ArrayList<String[]> displayAscii = new ArrayList<String[]>();
        for (int i = 0; i < totalReels; i ++) {
            curReel = (ArrayList)reels.get(i); //Entire reel for each iteration
            String landedOn = (String) curReel.get(0);
            displayAscii.add(changeToAscii(landedOn));  // sends entire reel
        }

        for (int i = 0; i < 10; i ++) {
            String line = new String();
            for (int j = 0; j < displayAscii.size(); j++) {
                String[] l = displayAscii.get(j);
                line += l[i];
            }
            System.out.println(line);
        }

        String winShow = new String();
        if (winner == "yes") {
            winShow = "#      # ##### #   # #   # #### ###   #\n" +
                    "#      #   #   ##  # ##  # #    #  #  #\n" +
                    "#  ##  #   #   # # # # # # ###  ###   #\n" +
                    "# #  # #   #   #  ## #  ## #    #  #   \n"+
                    " #    #  ##### #   # #   # #### #  #  #";
        }
        else {
            winShow = "##### ###  #   #   ###  ####  ###  ##### #   #\n"+
                    "  #   #  #  # #   #   # #    #   #   #   ##  #\n" +
                    "  #   ###    #    ##### # ## #####   #   # # #\n" +
                    "  #   #  #   #    #   # #  # #   #   #   #  ##\n" +
                    "  #   #  #   #    #   # #### #   # ##### #   #";
        }
        System.out.println();
        System.out.println(winShow.toString());
    }


    public String[] changeToAscii(String word) {
        String[] display = new String[10];
        if (word == "Bar") {
            //-_-_-_-_-_-_-_-_-_
            display[0] = "####################     ";
            display[1] = "                         ";
            display[2] = "###     ##    ####       ";
            display[3] = "#  #   #  #   #   #      ";
            display[4] = "####  ######  ####       ";
            display[5] = "#  #  ##  ##  #   #      ";
            display[6] = "###   #    #  #   #      ";
            display[7] = "                         ";
            display[8] = "####################     ";
            display[9] = "";
        } else if (word == "Lemon") {
            //-_-_-_-_-_-_-_-_-_
            display[0] = "     ###                 ";
            display[1] = "    ##########           ";
            display[2] = "   #############         ";
            display[3] = "   ##############        ";
            display[4] = "   ###############       ";
            display[5] = "    ###############      ";
            display[6] = "     ###############     ";
            display[7] = "       #############     ";
            display[8] = "        ###########      ";
            display[9] = "               ###       ";
        } else if (word == "Seven") {
            //-_-_-_-_-_-_-_-_-_
            display[0] = "                         ";
            display[1] = "      #############      ";
            display[2] = "               ###       ";
            display[3] = "              ###        ";
            display[4] = "             ###         ";
            display[5] = "            ###          ";
            display[6] = "           ###           ";
            display[7] = "          ###            ";
            display[8] = "         ###             ";
            display[9] = "                         ";
        }
        else if (word == "Cherry" ) {
            //-_-_-_-_-_-_-_-_-_
            display[0] = "            ##           ";
            display[1] = "            ##           ";
            display[2] = "          #####          ";
            display[3] = "         ##  ##          ";
            display[4] = "        ##    ##         ";
            display[5] = "      ####   #####       ";
            display[6] = "     ###### #######      ";
            display[7] = "     ###### #######      ";
            display[8] = "     ###### #######      ";
            display[9] = "      ####   #####       ";
        }
        else if (word == "Orange") {
            //-_-_-_-_-_-_-_-_-_
            display[0] = "                         ";
            display[1] = "    #############        ";
            display[2] = "  #################      ";
            display[3] = " ###################     ";
            display[4] = " ###################     ";
            display[5] = " ###################     ";
            display[6] = " ###################     ";
            display[7] = "  #################      ";
            display[8] = "    #############        ";
            display[9] = "                         ";
        }
        else if (word == "Money") {
                          //-_-_-_-_-_-_-_-_-_
            display[0] = "         ##              ";
            display[1] = "     #########           ";
            display[2] = "    ##   ##  ##          ";
            display[3] = "     ##  ##              ";
            display[4] = "       ######            ";
            display[5] = "         ## ##           ";
            display[6] = "    ##   ##  ##          ";
            display[7] = "     #########           ";
            display[8] = "         ##              ";
            display[9] = "         ##              ";
        }
        else if (word == "Heart") {
                          //-_-_-_-_-_-_-_-_-_
            display[0] = "                         ";
            display[1] = "    ####    ####         ";
            display[2] = "   ######  ######        ";
            display[3] = "   ##############        ";
            display[4] = "    ############         ";
            display[5] = "     ##########          ";
            display[6] = "      ########           ";
            display[7] = "       ######            ";
            display[8] = "        ####             ";
            display[9] = "         ##              ";

        }
        else if(word == "Diamond") {
            //-_-_-_-_-_-_-_-_-_
            display[0] = "    ###########          ";
            display[1] = "   #############         ";
            display[2] = "  ###############        ";
            display[3] = "   #############         ";
            display[4] = "    ###########          ";
            display[5] = "     #########           ";
            display[6] = "      #######            ";
            display[7] = "       #####             ";
            display[8] = "        ###              ";
            display[9] = "         #               ";
        }
        return display;
    }

    public ArrayList spin(int reels) {
        Random rand = new Random();
        ArrayList<Integer> rotations = new ArrayList<Integer>();
        for (int i = 0; i < reels; i++) {
            int r = rand.nextInt(23)+1;
            rotations.add(r);
        }
        return rotations;
    }



    public void payOut(int a, Player player) {
        System.out.println("You have won $" + Integer.toString(a) + "!");
        super.payOut(a, player);
    }

    public String calculateResults(ArrayList payOuts){
        String winner = "no";
        for (int i = 0; i < 50;i++) {
            System.out.println();
        }
        double top_win = 0;
        for (int i = 0; i < payOuts.size(); i ++) {
            int winning = 0;//Compared to reelsTotal
            ArrayList x = (ArrayList)payOuts.get(i);
            for (int j = 0; j < totalReels; j++ ) {
                ArrayList y = reels.get(j);
                String p = (String)x.get(j);
                String q = (String)y.get(0);
                if (q.equals(p) || p == "") {
                    winning ++;
                }
                else {
                    break;
                }
            }
            if (winning == totalReels) {
                double ab = new Double(x.get(x.size() - 1).toString());
                if (ab > top_win) {
                    top_win = ab;
                }
            }
        }
        if (top_win > 0) {
            int pay = (int)(top_win * (double)currentBet);
            payOut(pay, PlayerManager.pc);
            winner = "yes";
        }
        return winner;
    }


}
