import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * This class manages the loading and saving of files.
 * @author Michael Yixiao Wu | mywu@student.unimelb.edu.au | 1388097
 *
 */
public class FileManager {

    /**
     * Saves the current layout to a file.
     * Saves the current habitability log and score to resources.habitability.log
     * @param habitatLayout is the current layout.
     * @param habitabilityLog is the current log
     *
     */
    public void saveFile(Scanner scanner, char [][] habitatLayout, List<String> habitabilityLog) {

        System.out.println("Enter a filename for saving Martian Land Map");
        System.out.print("> ");
        String fileName = scanner.nextLine();

        if (fileName.isEmpty()) {
            System.out.println("Cannot create file for Martian Land Map.");
            System.out.println("Terminating the mission for now. See you next time.");
            return;
        }

        // Save habitat layout.
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter(fileName));
            for (int i = 0; i < habitatLayout.length; i++) {
                for (int j = 0; j < habitatLayout[i].length; j++) {
                    outputStream.print(habitatLayout[i][j]);
                }
                outputStream.println();
            }
            outputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot write Martian Land Map to the file.");
            System.out.println("Terminating the mission for now. See you next time.");
            return;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (habitabilityLog.isEmpty() || habitabilityLog == null) {
            System.out.println("Cannot create file for Habitability Status Log.");
            System.out.println("Terminating the mission for now. See you next time.");
            return;
        }

        // Save habitability log.
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter("resources/habitability.log", true));
            outputStream.println("==START==");
            for (String entity : habitabilityLog) {
                outputStream.println(entity);
            }
            outputStream.println("SCORE = " + MissionControl.habitability.getScore());
            outputStream.println("==END==");
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Cannot write Habitability Status Log in a file.");
            System.out.println("Terminating the mission for now. See you next time.");
        }

        System.out.println("Terminating the mission for now. See you next time.");
    }

    /**
     * Main menu item 5, print the old habitability los.
     * @param fileName is the filename that the old logs are saved in.
     *
     */
    public void printLog(String fileName) {

        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileReader(fileName));
            int programCount = 1;

            while(inputStream.hasNext()) {
                String line = inputStream.nextLine();

                if(line.equals("==START==")) {
                    System.out.println("Program Run :" + programCount);
                    System.out.println("Habitability Status");
                    System.out.println("======================");
                } else if(line.equals("==END==")) {
//                    System.out.println();
                    programCount++;
                } else {
                    String[] parts = line.split("=");
                    if(parts[0].equals("SCORE ")) {
                        System.out.println();
                        System.out.println("Total Habitability Score:" + parts[1]);
                    } else {
                        System.out.println(parts[0] + "=" + parts[1]);
                    }
                }
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found, aborting mission.");
            System.exit(1);
        }
    }
}
