
import java.util.Scanner;
import java.util.*;

  class PlayerManager {


      //Scanner input = new Scanner("System.in");
      //String player = input.nextLine();

      public static Player pc;

      public Player loadPlayer() {
          pc  = new Player();
          return pc;
      }
  }