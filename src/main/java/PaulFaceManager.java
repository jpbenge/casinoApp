import java.io.*;


public class PaulFaceManager {

    AudioManager audMan = new AudioManager("SafetyDance.wav");      //Paul Face Song


    public void paulFaceLoop()
    {
        audMan.play();
        int i = 0;
        while (i < 5 {
            try {

                displayPaulMessage("paulface.txt");
                Thread.currentThread().sleep(1000);
                displayPaulMessage("PaulStraight.txt");
                Thread.currentThread().sleep(1000);
                displayPaulMessage("PaulRight.txt");
                Thread.currentThread().sleep(1000);
                displayPaulMessage("PaulStraight.txt");
                Thread.currentThread().sleep(1000);

            } catch (InterruptedException e) {
                //Perform your exception handling
            }
            //Increase the int so we aren't stuck here forever
            i++;
        }
        audMan.stop();
    }

    public void displayPaulMessage(String file) {// The name of the file to open.
        String fileName = file;

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
}



