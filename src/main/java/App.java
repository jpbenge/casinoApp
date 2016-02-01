import java.util.*;

public class App {


    public static void main(String[] args) {

        PaulFaceManager pf = new PaulFaceManager();
        pf.paulFaceLoop();                      //Play dancing Paul face.

        AudioManager ambience = new AudioManager("casinoAmbience.wav");
        ambience.loop();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n                     __ __  ____     __  _          ____          __   ____  _____ ____  ____    ___  \n" +
                "                    |  |  ||    \\   /  ]| |        |    \\        /  ] /    |/ ___/|    ||    \\  /   \\ \n" +
                "                    |  |  ||  _  | /  / | |        |  o  )      /  / |  o  (   \\_  |  | |  _  ||     |\n" +
                "                    |  |  ||  |  |/  /  | |___     |   _/      /  /  |     |\\__  | |  | |  |  ||  O  |\n" +
                "                    |  :  ||  |  /   \\_ |     |    |  |       /   \\_ |  _  |/  \\ | |  | |  |  ||     |\n" +
                "                    |     ||  |  \\     ||     |    |  |       \\     ||  |  |\\    | |  | |  |  ||     |\n" +
                "                     \\__,_||__|__|\\____||_____|    |__|        \\____||__|__| \\___||____||__|__| \\___/ \n" +
                "                                                                                                       \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        PlayerManager playerManager = new PlayerManager();
        GameManager gameManager = new GameManager();


        playerManager.loadPlayer();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name to load or create your profile:  ");
        while(!scan.hasNext("[a-zA-Z]+")){
            System.out.println("Please only use letters");
            scan.nextLine();
        }
        String name = scan.nextLine();

        PlayerManager.pc.setName(name);


        gameManager.start();
    }
}