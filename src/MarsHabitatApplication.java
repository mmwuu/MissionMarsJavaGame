/**
 * This class is the entry point of your code. This class controls the flow of control for Mission Mars
 */

import java.util.Objects;
import java.util.Scanner;

/**
 * Main class and entry point. Handles the main menu.
 * @author Michael Yixiao Wu, mywu@student.unimelb.edu.au, stuID: 1388097.
 *
 */
public class MarsHabitatApplication{
    MarsHabitat marsHabitat = new MarsHabitat();
    MissionControl missionControl;
    FileManager fileManager = new FileManager();

    /**
     * The main method.
     * @param args is passed to startProgram to allow command line inputs.
     *
     */
    public static void main(String[] args) {
        MarsHabitatApplication application = new MarsHabitatApplication();
        // Runs the main application loop
        application.startProgram(args);
    }

    /**
     * This method controls the main menu.
     * @param args allows command line inputs.
     *
     */
    public void startProgram(String[] args) {
        missionControl = new MissionControl(marsHabitat);
        MarsHabitatApplication application = new MarsHabitatApplication();
        application.displayMessage();
        Scanner scanner = new Scanner(System.in);
        boolean isInitialised = false;

        // Load from command line
        if (args.length == 2) {
            if (Objects.equals(args[0], "--f")) {
                String fileName = args[1];
                marsHabitat.printMap(fileName);
                missionControl.makeEntityList(marsHabitat.getHabitatLayout());
                missionControl.createHabitabilityLog();
                missionControl.printStatus();
                isInitialised = true;
            }
        } else if (args.length == 4) {
            if (Objects.equals(args[0], "--f")) {
                String fileName = args[1];
                marsHabitat.printMap(fileName);
                missionControl.makeEntityList(marsHabitat.getHabitatLayout());
                missionControl.createHabitabilityLog();
                missionControl.printStatus();
                isInitialised = true;
            }
            if (Objects.equals(args[2], "--l")) {
                String fileName = args[3];
                fileManager.printLog(fileName);
            }
        } else if (args.length != 0) {
            System.out.println("Invalid Command");
        }

        // Print load menu text
        if (!isInitialised) {
            System.out.println("Please enter");
            System.out.println("[1] to load Martian map from a file");
            System.out.println("[2] to load default Martian map");

            // Load file menu loop.
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine();
                if (input.equals("1")) {
                    // load from file
                    System.out.println("Enter a file name to setup Martian Land Map");
                    System.out.print("> ");
                    String fileName = scanner.nextLine();
                    marsHabitat.printMap(fileName);
                    missionControl.makeEntityList(marsHabitat.getHabitatLayout());
                    missionControl.createHabitabilityLog();
                    missionControl.printStatus();
                    break;
                } else if (input.equals("2")) {
                    // Load default
                    marsHabitat.printMap("resources/default.in");
                    missionControl.makeEntityList(marsHabitat.getHabitatLayout());
                    missionControl.createHabitabilityLog();
                    missionControl.printStatus();
                    break;
                }
            }
        }

        // Main menu loop
        label:
        while (true) {
            // Print main menu text
            System.out.println("Please enter");
            System.out.println("[1] to move Space Robot");
            System.out.println("[2] to move Space Rover");
            System.out.println("[3] to move Martian animals");
            System.out.println("[4] to print the current habitability stats");
            System.out.println("[5] to print the old habitability stats");
            System.out.println("[6] to exit");
            System.out.print("> ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    missionControl.selectRobot(scanner);
                    break;
                case "2":
                    missionControl.selectRover(scanner);
                    break;
                case "3":
                    missionControl.selectMartianAnimal(scanner);
                    break;
                case "4":
                    missionControl.updateHabitabilityLog();
                    missionControl.printStatus();
                    break;
                case "5":
                    fileManager.printLog("resources/habitability.log");
                    break;
                case "6":
                    fileManager.saveFile(scanner, marsHabitat.getHabitatLayout(), missionControl.getHabitabilityLog());
                    break label;
            }
        }
    }



    /**
         * This method prints the starting welcome message. Do not change this code
         */
    private void displayMessage() {
        System.out.println("         __\n" +
                " _(\\    |@@|\n" +
                "(__/\\__ \\--/ __\n" +
                "   \\___|----|  |   __\n" +
                "       \\ }{ /\\ )_ / _\\\n" +
                "       /\\__/\\ \\__O (_COMP90041\n" +
                "      (--/\\--)    \\__/\n" +
                "      _)(  )(_\n" +
                "     `---''---`");
        System.out.println(
                " /$$      /$$ /$$                    /$$                           /$$      /$$                              \n" +
                        "| $$$    /$$$|__/                   |__/                          | $$$    /$$$                              \n" +
                        "| $$$$  /$$$$ /$$  /$$$$$$$ /$$$$$$$ /$$  /$$$$$$  /$$$$$$$       | $$$$  /$$$$  /$$$$$$   /$$$$$$   /$$$$$$$\n" +
                        "| $$ $$/$$ $$| $$ /$$_____//$$_____/| $$ /$$__  $$| $$__  $$      | $$ $$/$$ $$ |____  $$ /$$__  $$ /$$_____/\n" +
                        "| $$  $$$| $$| $$|  $$$$$$|  $$$$$$ | $$| $$  \\ $$| $$  \\ $$      | $$  $$$| $$  /$$$$$$$| $$  \\__/|  $$$$$$ \n" +
                        "| $$\\  $ | $$| $$ \\____  $$\\____  $$| $$| $$  | $$| $$  | $$      | $$\\  $ | $$ /$$__  $$| $$       \\____  $$\n" +
                        "| $$ \\/  | $$| $$ /$$$$$$$//$$$$$$$/| $$|  $$$$$$/| $$  | $$      | $$ \\/  | $$|  $$$$$$$| $$       /$$$$$$$/\n" +
                        "|__/     |__/|__/|_______/|_______/ |__/ \\______/ |__/  |__/      |__/     |__/ \\_______/|__/      |_______/ ");

        System.out.println();
    }

}