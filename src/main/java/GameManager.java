import java.io.PrintWriter;
import java.util.Scanner;

public class GameManager {
    private static Game curGame;
    private static String gameType;

    private void chooseGame() {
        Scanner sc = new Scanner(System.in);
        while (gameType == null) {
            if (PlayerManager.pc.getChips() <= 0) {
                exit();
                break;
            }
            System.out.println("Would you like to play a table game, slots, or leave the Casino?");
            gameType = sc.nextLine().toLowerCase();
            if (gameType.contains("table")) {
                System.out.println("What game would you like to play?\n\n BlackJack or 5 card stud?");
                String gameChoice = sc.nextLine().toLowerCase();

                System.out.println("Would you like to play or see rules?");
                String process = sc.nextLine();
                if (process.contains("rule")) {
                    Rules rule = new Rules();
                    rule.rules(gameChoice);
                }
                switch (gameChoice) {
                    case "blackjack":
                        System.out.println(PlayerManager.pc.getName() + "'s current Chip Count: $" + PlayerManager.pc.getChips());
                        BlackJack blackJack = new BlackJack();
                        blackJack.start();

                        break;
                    case "5 card stud":
                        System.out.println(PlayerManager.pc.getName() + "'s current Chip Count: $" + PlayerManager.pc.getChips());
                        FiveCardStud fiveCardStud = new FiveCardStud();
                        fiveCardStud.start();
                        exit();
                        break;
                    default:
                        System.out.println("That game does not exist in our Casino.");
                        break;
                }
                System.out.println(PlayerManager.pc.getName() + "'s current Chip Count: $" + PlayerManager.pc.getChips());
                gameType = null;
            }
            else if(gameType.contains("slots")) {
                System.out.println("What game would you like to play?\n\n 3 Reel or 5 Reel slots?");
                String gameChoice = sc.nextLine().toLowerCase();
                System.out.println("Would you like to play or see rules?");
                String process  = sc.nextLine();
                if (process.contains("rule")) {
                    Rules rule = new Rules();
                    rule.rules(gameChoice);
                }
                int gameMin = 10;
                if (gameChoice.contains("5")) {
                    while(true) {
                        try {

                            System.out.println("Would you like to play 1 dollar slots, 5 dollar slots, or 10 dollar slots?");
                            String gameMinString = sc.nextLine();
                            gameMin = Integer.valueOf(gameMinString);
                            if (gameMin != 1 && gameMin != 5 && gameMin != 10) {
                                System.out.println("Error: That was not an option.");
                                continue;
                            }
                            break;
                        } catch(Exception e) {
                            System.out.println("Please enter only an integer.");
                        }
                    }
                    System.out.println(PlayerManager.pc.getName() + "'s current Chip Count: $" + PlayerManager.pc.getChips());
                    FiveReelSlot slot = new FiveReelSlot();
                    slot.start(gameMin, gameMin * 10);
                } else if (gameChoice.contains("3")) {
                    while(true) {
                        try {
                            System.out.println("Would you like to play 1 dollar slots, 5 dollar slots, or 10 dollar slots?");
                            String gameMinString = sc.nextLine();
                            gameMin = Integer.valueOf(gameMinString);
                            if (gameMin != 1 && gameMin != 5 && gameMin != 10) {
                                System.out.println("Error: That was not an option.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Please enter only an integer.");
                        }
                    }
                    System.out.println(PlayerManager.pc.getName() + "'s current Chip Count: $" + PlayerManager.pc.getChips());
                    ClassicSlot slot = new ClassicSlot();
                    slot.start(gameMin, gameMin * 10);
                } else {
                    System.out.println("That game does not exist in our Casino.");
                }
                gameType = null;
            }
            else if(gameType.contains("leave")){
                exit();
                break;
            }
            else {
                System.out.println("Invalid Game Type.");
                gameType = null;
            }
            gameType = null;
        }

    }

    public void start() {
        chooseGame();
    }

    public void exit() {
        System.out.println(PlayerManager.pc.getName() + ", you have cashed out with $" +PlayerManager.pc.getChips());

        try {
            PrintWriter writer = null;
            writer = new PrintWriter(PlayerManager.pc.getName() + ".txt", "UTF-8");
            writer.print(PlayerManager.pc.getChips());
            writer.close();
        } catch (Exception e) {
            System.out.println("Error Saving profile");
        }
    }

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        gm.start();
    }
}