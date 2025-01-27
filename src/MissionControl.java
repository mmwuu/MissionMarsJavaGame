import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Mission Control class is where the robots, rovers and martian animals are controlled.
 * This class manages their movements, sub menus and updates the habitability.
 * @author Michael Yixiao Wu, mywu@student.unimelb.edu.au, stuID: 1388097.
 *
 */
public class MissionControl {

    public static final int VEGETATION = 2;
    public static final int EARTHANIMAL = 5;
    public static final int PLANT_FEED = 1;
    public static final int ROCK = 1;
    public static final int MINERAL = 2;
    public static final int MARTIANANIMAL = 7;
    private int numMinerals;

    private ArrayList<Entity> entities; // Vegetation and Earth entities
    private ArrayList<Entity> spaceRobotsList;
    private ArrayList<Entity> spaceRoverList;
    private ArrayList<Entity> martianAnimalList;
    private List<String> habitabilityLog;
    public static Habitability habitability = new Habitability();
    private MarsHabitat habitat = new MarsHabitat();

    /**
     * Constructor of Mission Control. Creates lists and arraylists to keep track
     * of the entities.
     * @param habitat the instance of a Mars habitat. A new section of land that
     * we want to control.
     *
     */
    public MissionControl(MarsHabitat habitat) {
        this.habitat = habitat;
        entities = new ArrayList<Entity>(); // Vegetation and Earth entities
        spaceRobotsList = new ArrayList<Entity>();
        spaceRoverList = new ArrayList<Entity>();
        martianAnimalList = new ArrayList<Entity>();
        habitabilityLog = new ArrayList<String>();
    }

    // Creates list of vegetation and earth animal entities.
    public void makeEntityList(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                switch (map[i][j]) {
                    case 'P' -> entities.add(new Potato(i, j));
                    case 'D' -> entities.add(new Dog(i, j));
                    case 'C' -> entities.add(new Cow(i, j));
                    case 'S' -> entities.add(new Sheep(i, j));
                    case 'T' -> entities.add(new Tomato(i, j));
                    case 'O' -> entities.add(new Onion(i, j));
                    case 'R' -> entities.add(new Rose(i, j));
                    case 'L' -> entities.add(new Lily(i, j));
                    case 'A' -> entities.add(new Apple(i, j));
                    case 'B' -> entities.add(new Banana(i, j));
                    case 'E' -> entities.add(new Eucalyptus(i, j));
                    case 'G' -> entities.add(new Goat(i, j));
                    case '*' -> numMinerals++; // Increment total mineral count.
                }
            }
        }
    }

    /**
     * Populates the habitability log by counting
     * the entities in the entities list
     *
     */
    public void createHabitabilityLog() {

        int potato = 0;
        int tomato = 0;
        int onion = 0;
        int rose = 0;
        int lily = 0;
        int apple = 0;
        int banana = 0;
        int eucalyptus = 0;
        int cow = 0;
        int goat = 0;
        int sheep = 0;
        int dog = 0;

        for (Entity entity : entities) {
            if (entity instanceof Potato) {
                potato++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Tomato) {
                tomato++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Onion) {
                onion++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Rose) {
                rose++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Lily) {
                lily++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Apple) {
                apple++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Banana) {
                banana++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Eucalyptus) {
                eucalyptus++;
                habitability.increaseBy(VEGETATION);
            } else if (entity instanceof Cow) {
                cow++;
                habitability.increaseBy(EARTHANIMAL);
            } else if (entity instanceof Goat) {
                goat++;
                habitability.increaseBy(EARTHANIMAL);
            } else if (entity instanceof Sheep) {
                sheep++;
                habitability.increaseBy(EARTHANIMAL);
            } else if (entity instanceof Dog) {
                dog++;
                habitability.increaseBy(EARTHANIMAL);
            }
        }

        if (potato != 0) {
            habitabilityLog.add("POTATO = " + potato);
        } if (numMinerals != 0) {
            habitabilityLog.add("MINERAL = " + numMinerals);
        } if (sheep != 0) {
            habitabilityLog.add("SHEEP = " + sheep);
        } if (cow != 0) {
            habitabilityLog.add("COW = " + cow);
        } if (onion != 0) {
            habitabilityLog.add("ONION = " + onion);
        } if (lily != 0) {
            habitabilityLog.add("LILY = " + lily);
        } if (eucalyptus != 0) {
            habitabilityLog.add("EUCALYPTUS = " + eucalyptus);
        } if (rose != 0) {
            habitabilityLog.add("ROSE = " + rose);
        } if (apple != 0) {
            habitabilityLog.add("APPLE = " + apple);
        } if (banana != 0) {
            habitabilityLog.add("BANANA = " + banana);
        } if (goat != 0) {
            habitabilityLog.add("GOAT = " + goat);
        } if (dog != 0) {
            habitabilityLog.add("DOG = " + dog);
        } if (tomato != 0) {
            habitabilityLog.add("TOMATO = " + tomato);
        }

    }

    /**
     * Updates the habitability log for main menu item 4.
     *
     */
    public void updateHabitabilityLog() {

        habitabilityLog.clear();
        List<String> updatedLog = new ArrayList<>();
        int potato = 0;
        int tomato = 0;
        int onion = 0;
        int rose = 0;
        int lily = 0;
        int apple = 0;
        int banana = 0;
        int eucalyptus = 0;
        int cow = 0;
        int goat = 0;
        int sheep = 0;
        int dog = 0;

        for (Entity entity : entities) {
            if (entity instanceof Potato) {
                potato++;
            } else if (entity instanceof Tomato) {
                tomato++;
            } else if (entity instanceof Onion) {
                onion++;
            } else if (entity instanceof Rose) {
                rose++;
            } else if (entity instanceof Lily) {
                lily++;
            } else if (entity instanceof Apple) {
                apple++;
            } else if (entity instanceof Banana) {
                banana++;
            } else if (entity instanceof Eucalyptus) {
                eucalyptus++;
            } else if (entity instanceof Cow) {
                cow++;
            } else if (entity instanceof Goat) {
                goat++;
            } else if (entity instanceof Sheep) {
                sheep++;
            } else if (entity instanceof Dog) {
                dog++;
            }
        }

        if (potato != 0) {
            updatedLog.add("POTATO = " + potato);
        } if (numMinerals != 0) {
            updatedLog.add("MINERAL = " + numMinerals);
        } if (sheep != 0) {
            updatedLog.add("SHEEP = " + sheep);
        } if (cow != 0) {
            updatedLog.add("COW = " + cow);
        } if (onion != 0) {
            updatedLog.add("ONION = " + onion);
        } if (lily != 0) {
            updatedLog.add("LILY = " + lily);
        } if (eucalyptus != 0) {
            updatedLog.add("EUCALYPTUS = " + eucalyptus);
        } if (rose != 0) {
            updatedLog.add("ROSE = " + rose);
        } if (apple != 0) {
            updatedLog.add("APPLE = " + apple);
        } if (banana != 0) {
            updatedLog.add("BANANA = " + banana);
        } if (goat != 0) {
            updatedLog.add("GOAT = " + goat);
        } if (dog != 0) {
            updatedLog.add("DOG = " + dog);
        } if (tomato != 0) {
            updatedLog.add("TOMATO = " + tomato);
        }

        habitabilityLog = updatedLog;
    }


    // Prints the habitability status.
    public void printStatus() {
        System.out.println("Habitability Status");
        System.out.println("======================");

        for (String entity : habitabilityLog) {
            System.out.println(entity);
        }

        System.out.println();
        System.out.println("Total Habitability Score: " + habitability.getScore());
    }

    public List<String> getHabitabilityLog() {
        return habitabilityLog;
    }

    /////////////////////////
    ////// SPACE ROBOT //////
    /////////////////////////

    // Makes a list of the Space Robot entities
    private void makeSpaceRobotsList(char[][] map) {
        spaceRobotsList.clear();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'Z') {
                    spaceRobotsList.add(new SpaceRobot(i, j));
                }
            }
        }
    }

    /**
     * Enters the menu sequence for Space Robots.
     * Allows the user to select which one on the map.
     * @param scanner passes the scanner to avoid error of
     * multiple scanners.
     */
    public void selectRobot(Scanner scanner) {
        makeSpaceRobotsList(habitat.getHabitatLayout());

        if (spaceRobotsList.isEmpty()) {
            System.out.println("Space robot list not properly set.");
            return;
        } else {
            // Display menu for choosing which one
            System.out.println("There are " + spaceRobotsList.size() + " Space Robot found. Select");
        }
        for (int i = 0; i < spaceRobotsList.size(); i++) {
            Entity spaceRobot = spaceRobotsList.get(i);
            String coordinates = "(" + spaceRobot.getCol() + ", " + spaceRobot.getRow() + ")";
            System.out.println("[" + (i + 1) + "] for Space Robot at position " + coordinates);
        }
        System.out.print("> ");

        // Take user's choice of robot.
        int robotChoice = scanner.nextInt();
        scanner.nextLine();
        if (robotChoice > spaceRobotsList.size() || robotChoice <= 0) {
            System.out.println("Invalid Command");
        }

        // store the choice of robot.
        Entity spaceRobot = null;
        for (int i = 0; i < spaceRobotsList.size(); i++) {
            if ((i + 1) == robotChoice) {
                spaceRobot = spaceRobotsList.get(i);

            }
        }
        if (spaceRobot == null) {
            System.out.println("robot of choice is not found.");
        } else {
            // Enter the menu sequence for moving the entity.
            robotMoveMenu(scanner, spaceRobot);
        }
    }

    /**
     * Handles the movement logic of robots and subsequent actions.
     * @param direction The direction that the user wants to move in.
     * @param scanner for taking input
     * @param entity The entity object that we are moving.
     * @param currentRow The row position of the object
     * @param currentCol The col position of the object
     * @return the new row and col position of the entity, stored in an in array.
     */
    private int[] moveRobot(String direction, Scanner scanner, Entity entity, int currentRow, int currentCol) {
        int newRow = -1;
        int newCol = -1;

        // Set the new position we will to be at based on the direction requested.
        switch (direction) {
            case "north" -> {
                newRow = currentRow - 1;
                newCol = currentCol;
            }
            case "west" -> {
                newRow = currentRow;
                newCol = currentCol - 1;
            }
            case "east" -> {
                newRow = currentRow;
                newCol = currentCol + 1;
            }
            case "south" -> {
                newRow = currentRow + 1;
                newCol = currentCol;
            }
            case "north-west" -> {
                newRow = currentRow - 1;
                newCol = currentCol - 1;
            }
            case "south-west" -> {
                newRow = currentRow + 1;
                newCol = currentCol - 1;
            }
            case "north-east" -> {
                newRow = currentRow - 1;
                newCol = currentCol + 1;
            }
            case "south-east" -> {
                newRow = currentRow + 1;
                newCol = currentCol + 1;
            }
        }


        // check for boundary
        if (habitat.isBoundary(newRow, newCol)) {
            System.out.println("Invalid Location, Boundary reached.");
        } else if (habitat.isPlant(newRow, newCol)) {
            // Menu loop for watering a plant.
            while (true) {
                System.out.println("Do you want to water the plant?Enter Y for yes, N for No");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    habitability.increaseBy(PLANT_FEED);
                    System.out.println("You watered a plant. It will grow");
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    // Go back to move menu
                    break;
                } else {
                    // print error and ask again.
                    System.out.println("Invalid Command");
                }
            }
        } else if (habitat.isCattle(newRow, newCol)) {
            // Menu loop for feeding cattle. Including dog.
            while (true) {
                System.out.println("Do you want to feed the animals?Enter Y for yes, N for No");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Y")) {
                    habitability.increaseBy(PLANT_FEED);
                    System.out.println("You have fed the cattle. It will grow");
                    if (habitat.isDog(newRow, newCol)) {
                        // Increase health of dog after being fed.
                        for (Entity ent: entities) {
                            if (ent.getRow() == newRow && ent.getCol() == newCol) {
                                if (ent instanceof Dog) {
                                    Dog dog = (Dog) ent;
                                    dog.increaseHealth(1);
                                }
                            }
                        }
                    }
                    break;
                } else if (choice.equalsIgnoreCase("N")) {
                    // Go back to move menu
                    break;
                } else {
                    // print error and ask again.
                    System.out.println("Invalid Command");
                }
            }
        } else if (habitat.isEmpty(newRow, newCol)) {

            // updates the position of the entity based on direction.
            switch (direction) {
                case "north" -> {
                    entity.moveNorth();
                }
                case "west" -> {
                    entity.moveWest();
                }
                case "east" -> {
                    entity.moveEast();
                }
                case "south" -> {
                    entity.moveSouth();
                }
                case "north-west" -> {
                    entity.moveNorthwest();
                }
                case "south-west" -> {
                    entity.moveSouthwest();
                }
                case "north-east" -> {
                    entity.moveNortheast();
                }
                case "south-east" -> {
                    entity.moveSoutheast();
                }
            }

            // updates the habitability layout map
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, 'Z');

            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // Find the entity in the list.
            int index = -1;
            for (int i = 0; i < spaceRobotsList.size(); i++) {
                if (spaceRobotsList.get(i).getRow() == currentRow && spaceRobotsList.get(i).getCol() == currentCol) {
                    index = i;
                    break;
                }
            }

            // Remove this entity from the list and add updated entity.
            if (index >= 0 && index < spaceRobotsList.size()) {
                spaceRobotsList.remove(index);
            }
            spaceRobotsList.add(entity);

            // Performs action on the left location.
            if (habitat.leftIsEmpty(newRow, newCol)) {
                robotActionMenu(scanner, newRow, newCol);
            }
        } else {
            System.out.println("You cannot move to this location.");
        }

        // Print the updated map and the menu options after every move.
        System.out.println("Here is a layout of Martian land.");
        System.out.println();
        habitat.printLayout(habitat.getHabitatLayout());
        System.out.println();

        return new int[]{currentRow, currentCol};
    }

    /**
     * Displays all the directions that the entity can move in, and calls further menus.
     * @param scanner for inputs
     * @param entity instance of the entity we want to move.
     */
    private void robotMoveMenu(Scanner scanner, Entity entity) {
        int currentRow = entity.getRow();
        int currentCol = entity.getCol();

        // loop for the move direction menu
        label:
        while (true) {
            displayMoveMenu("SpaceRobot");
            System.out.print("> ");
            String input = scanner.nextLine();

            switch (input) {
                case "1": {
                    int[] newPos = moveRobot("north", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "2": {
                    int[] newPos = moveRobot("west", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "3": {
                    int[] newPos = moveRobot("east", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "4": {
                    int[] newPos = moveRobot("south", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "5": {
                    int[] newPos = moveRobot("north-west", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "6": {
                    int[] newPos = moveRobot("south-west", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "7": {
                    int[] newPos = moveRobot("north-east", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "8": {
                    int[] newPos = moveRobot("south-east", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "0":
                    // return to prev menu
                    break label;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }

    /**
     * Menu that allows robot to perform actions on the left space such as
     * planting and feeding
     * @param scanner allows input
     * @param newRow the new row that the robot as just moved to.
     * @param newCol the new column that the robot as just moved to.
     */
    private void robotActionMenu(Scanner scanner, int newRow, int newCol) {
        label:
        while (true) {
            displayRobotMenu();
            System.out.print("> ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    // Plant something.
                    plantingMenu(scanner, newRow, newCol - 1);
                    break;
                case "2":
                    // Rear cattle.
                    cattleMenu(scanner, newRow, newCol - 1);
                    break;
                case "0":
                    // Return to prev menu.
                    break label;
            }
        }
    }

    /**
     * Allows the user to plant a variety of plants.
     * @param scanner takes input
     * @param plantRow row where plant is planted.
     * @param plantCol col where plant is planted
     */
    private void plantingMenu(Scanner scanner, int plantRow, int plantCol) {
        label:
        while (true) {
            displayPlantMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    // plant potato
                    entities.add(new Potato(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'P');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("A Potato has been planted.");
                    break label;
                case "2":
                    // plant tomato
                    entities.add(new Tomato(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'T');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("A Tomato has been planted.");
                    break label;
                case "3":
                    // plant onion
                    entities.add(new Onion(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'O');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("An Onion has been planted.");
                    break label;
                case "4":
                    // plant apple
                    entities.add(new Apple(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'A');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("An Apple has been planted.");
                    break label;
                case "5":
                    // plant banana
                    entities.add(new Banana(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'B');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("A Banana has been planted.");
                    break label;
                case "6":
                    // plant lily
                    entities.add(new Lily(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'L');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("A Lily has been planted.");
                    break label;
                case "7":
                    // plant rose
                    entities.add(new Rose(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'R');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("A Rose has been planted.");
                    break label;
                case "8":
                    // plant eucalyptus
                    entities.add(new Eucalyptus(plantRow, plantCol));
                    insertSymbol(plantRow, plantCol, 'E');
                    habitability.increaseBy(VEGETATION);
                    System.out.println("Eucalyptus has been planted.");
                    break label;
                case "0":
                    break label;
            }
        }
    }

    /**
     * The cattle menu allows users to place cattle on the map.
     * @param scanner takes input for cattle choice.
     * @param cattleRow row where cattle is placed.
     * @param cattleCol col where cattle is placed.
     */
    private void cattleMenu(Scanner scanner, int cattleRow, int cattleCol) {
        label:
        while (true) {
            displayCattleMenu();
            System.out.print("> ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    // add goat
                    entities.add(new Goat(cattleRow, cattleCol));
                    insertSymbol(cattleRow, cattleCol, 'G');
                    habitability.increaseBy(EARTHANIMAL);
                    System.out.println("A Goat has been added.");
                    break label;
                case "2":
                    // add sheep
                    entities.add(new Sheep(cattleRow, cattleCol));
                    insertSymbol(cattleRow, cattleCol, 'S');
                    habitability.increaseBy(EARTHANIMAL);
                    System.out.println("A Sheep has been added.");
                    break label;
                case "3":
                    // add cow
                    entities.add(new Cow(cattleRow, cattleCol));
                    insertSymbol(cattleRow, cattleCol, 'C');
                    habitability.increaseBy(EARTHANIMAL);
                    System.out.println("A Cow has been added.");
                    break label;
                case "4":
                    // add dog
                    entities.add(new Dog(cattleRow, cattleCol));
                    insertSymbol(cattleRow, cattleCol, 'D');
                    habitability.increaseBy(EARTHANIMAL);
                    System.out.println("A Dog has been added.");
                    break label;
                case "0":
                    break label;
            }
        }
    }

    // Some helper functions to print the menus.
    private void displayCattleMenu() {
        System.out.println("Let's add some cattle");
        System.out.println("[1] to add a goat");
        System.out.println("[2] to add a sheep");
        System.out.println("[3] to add cow");
        System.out.println("[4] to add a dog");
        System.out.println("[0] to go back to previous menu");
    }

    private void displayPlantMenu() {
        System.out.println("Let's Plant something");
        System.out.println("[1] to plant a potato");
        System.out.println("[2] to plant a tomato");
        System.out.println("[3] to plant an onion");
        System.out.println("[4] to plant an apple tree");
        System.out.println("[5] to plant a banana tree");
        System.out.println("[6] to plant a lily");
        System.out.println("[7] to plant a rose");
        System.out.println("[8] to plant a eucalyptus tree");
        System.out.println("[0] to go back to previous menu");
    }

    private void displayRobotMenu() {
        System.out.println("Please select");
        System.out.println("[1] to plant a tree");
        System.out.println("[2] to rear cattle");
        System.out.println("[0] to go back to previous menu");
    }

    private void displayMoveMenu(String entityType) {
        System.out.println(entityType + " can move in following directions");
        System.out.println("[1] to move north.");
        System.out.println("[2] to move west.");
        System.out.println("[3] to move east.");
        System.out.println("[4] to move south.");
        System.out.println("[5] to move north-west.");
        System.out.println("[6] to move south-west.");
        System.out.println("[7] to move north-east.");
        System.out.println("[8] to move south-east.");
        System.out.println("[0] to go back to main menu");
        System.out.println("Please enter a direction.");
    }

    /////////////////////////
    ////// SPACE ROVER //////
    /////////////////////////

    // Make a list of the rovers on the map.
    private void makeSpaceRoverList(char[][] map) {
        spaceRoverList.clear();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'X') {
                    spaceRoverList.add(new SpaceRover(i, j));
                }
            }
        }
    }

    /**
     * Enters the menu sequence for Space Rovers.
     * Allows the user to select which one on the map.
     * @param scanner passes the scanner to avoid error of
     * multiple scanners.
     */
    public void selectRover(Scanner scanner) {
        makeSpaceRoverList(habitat.getHabitatLayout());
        if (spaceRoverList.isEmpty()) {
            System.out.println("No space rover found to move.");
            return;
        } else {
            // Display menu for choosing which one
            System.out.println("There are " + spaceRoverList.size() + " Space Rover found. Select");
        }
        for (int i = 0; i < spaceRoverList.size(); i++) {
            Entity spaceRover = spaceRoverList.get(i);
            String coordinates = "(" + spaceRover.getCol() + ", " + spaceRover.getRow() + ")";
            System.out.println("[" + (i + 1) + "] for Space Rover at position " + coordinates);
        }

        System.out.print("> ");
        int roverChoice = scanner.nextInt();
        scanner.nextLine();
        if (roverChoice > spaceRoverList.size() || roverChoice <= 0) {
            System.out.println("Invalid rover choice");
        }
        Entity spaceRover = null;
        // store the choice of rover in a local instance of spaceRover.
        for (int i = 0; i < spaceRoverList.size(); i++) {
            if ((i + 1) == roverChoice) {
                spaceRover = spaceRoverList.get(i);
            }
        }

        if (spaceRover == null) {
            System.out.println("rover of choice is not found.");
        } else {
            // Enter the menu sequence for moving the entity.
            roverMoveMenu(scanner, spaceRover);
        }
    }

    /**
     * Handles the movement logic of rovers
     * @param direction The direction that the user wants to move in.
     * @param scanner for taking input
     * @param entity The entity object that we are moving.
     * @param currentRow The row position of the object
     * @param currentCol The col position of the object
     * @return the new row and col position of the entity, stored in an in array.
     */
    private int[] moveRover(String direction, Scanner scanner, Entity entity, int currentRow, int currentCol) {
        int newRow = -1;
        int newCol = -1;
        switch (direction) {
            case "north" -> {
                newRow = currentRow - 1;
                newCol = currentCol;
            }
            case "west" -> {
                newRow = currentRow;
                newCol = currentCol - 1;
            }
            case "east" -> {
                newRow = currentRow;
                newCol = currentCol + 1;
            }
            case "south" -> {
                newRow = currentRow + 1;
                newCol = currentCol;
            }
            case "north-west" -> {
                newRow = currentRow - 1;
                newCol = currentCol - 1;
            }
            case "south-west" -> {
                newRow = currentRow + 1;
                newCol = currentCol - 1;
            }
            case "north-east" -> {
                newRow = currentRow - 1;
                newCol = currentCol + 1;
            }
            case "south-east" -> {
                newRow = currentRow + 1;
                newCol = currentCol + 1;
            }
        }

        // check for boundary
        if (habitat.isBoundary(newRow, newCol)) {
            System.out.println("Invalid Location, Boundary reached.");
        } else if (habitat.isRock(newRow, newCol)) {
            System.out.println("We found a plain rock, Rover will destroy it now.");
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, 'X');

            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // Find this rover in the list and update it.
            int index = -1;
            for (int i = 0; i < spaceRoverList.size(); i++) {
                if (spaceRoverList.get(i).getRow() == currentRow && spaceRoverList.get(i).getCol() == currentCol) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 && index < spaceRoverList.size()) {
                spaceRoverList.remove(index);
            }
            spaceRoverList.add(entity);

            // update habitability
            habitability.increaseBy(ROCK);

        } else if (habitat.isMineral(newRow, newCol)) {
            System.out.println("We found a mineral, Rover will collect it now.");
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, 'X');

            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // Find this rover in the list and update it.
            int index = -1;
            for (int i = 0; i < spaceRoverList.size(); i++) {
                if (spaceRoverList.get(i).getRow() == currentRow && spaceRoverList.get(i).getCol() == currentCol) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 && index < spaceRoverList.size()) {
                spaceRoverList.remove(index);
            }
            spaceRoverList.add(entity);

            // update habitability
            habitability.increaseBy(MINERAL);

        } else if (habitat.isEmpty(newRow, newCol)) {
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, 'X');

            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // Find this rover in the list and update it.
            int index = -1;
            for (int i = 0; i < spaceRoverList.size(); i++) {
                if (spaceRoverList.get(i).getRow() == currentRow && spaceRoverList.get(i).getCol() == currentCol) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 && index < spaceRoverList.size()) {
                spaceRoverList.remove(index);
            }
            spaceRoverList.add(entity);

        } else {
            System.out.println("You cannot move to this location.");
        }

        // Print the updated map, then the menu options after every move.
        System.out.println("Here is a layout of Martian land.");
        System.out.println();
        habitat.printLayout(habitat.getHabitatLayout());
        System.out.println();

        // return updated pos.
        return new int[]{currentRow, currentCol};
    }

    /**
     * Displays all the directions that the entity can move in, and calls further menus.
     * @param scanner for inputs
     * @param entity instance of the entity we want to move.
     */
    private void roverMoveMenu(Scanner scanner, Entity entity) {
        int currentRow = entity.getRow();
        int currentCol = entity.getCol();

        // loop for direction menu
        label:
        while (true) {
            displayMoveMenu("SpaceRover");
            System.out.print("> ");
            String input = scanner.nextLine();

            switch (input) {
                case "1": {
                    int[] newPos = moveRover("north", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "2": {
                    int[] newPos = moveRover("west", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "3": {
                    int[] newPos = moveRover("east", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "4": {
                    int[] newPos = moveRover("south", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "5": {
                    int[] newPos = moveRover("north-west", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "6": {
                    int[] newPos = moveRover("south-west", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "7": {
                    int[] newPos = moveRover("north-east", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "8": {
                    int[] newPos = moveRover("south-east", scanner, entity, currentRow, currentCol);
                    currentRow = newPos[0];
                    currentCol = newPos[1];
                    break;
                }
                case "0":
                    // return to prev menu
                    break label;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }

    ////////////////////////
    //// MARTIAN ANIMAL ////
    ////////////////////////

    // Makes a list of heebies and jeebies that are on the map.
    private void makeMartianAnimalList(char[][] map) {
        martianAnimalList.clear();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'H') {
                    martianAnimalList.add(new Heebie(i, j));
                } else if (map[i][j] == 'J') {
                    martianAnimalList.add(new Jeebie(i, j));
                }
            }
        }
    }

    /**
     * Enters the menu sequence for martian animals.
     * Allows the user to select which one on the map.
     * @param scanner passes the scanner to avoid error of
     * multiple scanners.
     */
    public void selectMartianAnimal(Scanner scanner) {
        makeMartianAnimalList(habitat.getHabitatLayout());

        if (martianAnimalList.isEmpty()) {
            System.out.println("No martian animal found to move.");
            return;
        } else {
            // Display menu for choosing which one
            System.out.println("There are " + martianAnimalList.size() + " Martian animal found. Select");
        }
        for (int i = 0; i < martianAnimalList.size(); i++) {
            Entity martianAnimal = martianAnimalList.get(i);
            String animalType = "UNKNOWN";
            if (martianAnimal instanceof Heebie) {
                animalType = "HEEBIE";
            }
            else if (martianAnimal instanceof Jeebie) {
                animalType = "JEEBIE";
            }
            String coordinates = "(" + martianAnimal.getCol() + ", " + martianAnimal.getRow() + ")";
            System.out.println("[" + (i + 1) + "] for " + animalType  + " at position " + coordinates);
        }

        System.out.print("> ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > martianAnimalList.size() || choice <= 0) {
            System.out.println("Invalid Command");
        }

        Entity martianAnimal = null;
        for (int i = 0; i < martianAnimalList.size(); i++) {
            if ((i + 1) == choice) {
                martianAnimal = martianAnimalList.get(i);

            }
        }

        if (martianAnimal == null) {
            System.out.println("martianAnimal of choice is not found.");
        } else {
            // Enter the menu sequence for moving the entity.
            martianAnimalMoveMenu(scanner, martianAnimal);
        }
    }

    /**
     * Handles the movement logic of martian animals and
     * fight with dog.
     * @param direction The direction that the user wants to move in.
     * @param scanner for taking input
     * @param entity The entity object that we are moving.
     * @param currentRow The row position of the object
     * @param currentCol The col position of the object
     * @return the new row and col position of the entity, stored in an in array.
     */
    private int[] moveMartianAnimal(String direction, Scanner scanner, Entity entity, int currentRow, int currentCol) {

        char symbol;
        if (entity instanceof Heebie) {
            symbol = 'H';
        } else {
            symbol = 'J';
        }

        int newRow = -1;
        int newCol = -1;
        switch (direction) {
            case "north" -> {
                newRow = currentRow - 1;
                newCol = currentCol;
            }
            case "west" -> {
                newRow = currentRow;
                newCol = currentCol - 1;
            }
            case "east" -> {
                newRow = currentRow;
                newCol = currentCol + 1;
            }
            case "south" -> {
                newRow = currentRow + 1;
                newCol = currentCol;
            }
            case "north-west" -> {
                newRow = currentRow - 1;
                newCol = currentCol - 1;
            }
            case "south-west" -> {
                newRow = currentRow + 1;
                newCol = currentCol - 1;
            }
            case "north-east" -> {
                newRow = currentRow - 1;
                newCol = currentCol + 1;
            }
            case "south-east" -> {
                newRow = currentRow + 1;
                newCol = currentCol + 1;
            }
        }


        // check for boundary
        if (habitat.isBoundary(newRow, newCol)) {
            System.out.println("Invalid Location, Boundary reached.");
        } else if (habitat.isPlant(newRow, newCol)) {
            System.out.println("The plantation are eaten by the martian animals.");
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, symbol);

            // remove plant in list of entities.
            int index = -1;
            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i).getRow() == newRow && entities.get(i).getCol() == newCol) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 && index < entities.size()) {
                entities.remove(index);
            }

            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // update martian animal in list.
            int ind = -1;
            for (int i = 0; i < martianAnimalList.size(); i++) {
                if (martianAnimalList.get(i).getRow() == currentRow && martianAnimalList.get(i).getCol() == currentCol) {
                    ind = i;
                    break;
                }
            }
            if (ind >= 0 && ind < martianAnimalList.size()) {
                martianAnimalList.remove(ind);
            }
            martianAnimalList.add(entity);

            // Increase martian animal health
            if (entity instanceof Heebie) {
                Heebie heebie = (Heebie) entity;
                heebie.increaseHealth(2);
            } else if (entity instanceof Jeebie) {
                Jeebie jeebie = (Jeebie) entity;
                jeebie.increaseHealth(2);
            }

            // update habitability score
            habitability.decreaseBy(VEGETATION);

        } else if (habitat.isAnimalNotDog(newRow, newCol)) {
            System.out.println("The cattle are killed by the martian animals.");
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, symbol);

            // remove plant in list of entities.
            int index = -1;
            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i).getRow() == newRow && entities.get(i).getCol() == newCol) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 && index < entities.size()) {
                entities.remove(index);
            }

            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // update the martian animal list.
            int ind = -1;
            for (int i = 0; i < martianAnimalList.size(); i++) {
                if (martianAnimalList.get(i).getRow() == currentRow && martianAnimalList.get(i).getCol() == currentCol) {
                    ind = i;
                    break;
                }
            }
            if (ind >= 0 && ind < martianAnimalList.size()) {
                martianAnimalList.remove(ind);
            }
            martianAnimalList.add(entity);

            // Increase martian animal health
            if (entity instanceof Heebie) {
                Heebie heebie = (Heebie) entity;
                heebie.increaseHealth(2);
            } else if (entity instanceof Jeebie) {
                Jeebie jeebie = (Jeebie) entity;
                jeebie.increaseHealth(2);
            }

            // update habitability score
            habitability.decreaseBy(EARTHANIMAL);

        } else if (habitat.isDog(newRow, newCol)) {

            // Handles the Martian Animal vs Dog Fight
            System.out.println("Martian animal and Dog has entered a fight");

            // Get the health of both parties and store locally.
            int dogHealth = 0;
            int martianAnimalHealth = 0;
            for (Entity ent: entities) {
                if (ent.getRow() == newRow && ent.getCol() == newCol) {
                    if (ent instanceof Dog) {
                        Dog dog = (Dog) ent;
                        dogHealth = dog.getHealth();
                    }
                }
            }
            if (entity instanceof Heebie) {
                Heebie heebie = (Heebie) entity;
                martianAnimalHealth = heebie.getHealth();
            } else if (entity instanceof Jeebie) {
                Jeebie jeebie = (Jeebie) entity;
                martianAnimalHealth = jeebie.getHealth();
            }

            // Fight sequence
            while (dogHealth > 0 && martianAnimalHealth > 0) {
                dogHealth -= 2;
                System.out.println("Martian Animal attacked dog. Health of dog reduced by 2, Present Health: " + dogHealth);

                if (dogHealth > 0 && martianAnimalHealth > 0) {
                    martianAnimalHealth -= 2;
                    System.out.println("Dog attacked Martian Animal. Martian Animal's health reduced by 2, Present Health: " + martianAnimalHealth);
                }

                // Dog loses :(
                if (dogHealth <= 0) {
                    System.out.println("Dog died");
                    System.out.println();

                    // delete from map and entity list.
                    deleteSymbol(newRow, newCol);
                    habitability.decreaseBy(EARTHANIMAL);
                    int index = -1;
                    for (int i = 0; i < entities.size(); i++) {
                        if (entities.get(i).getRow() == newRow && entities.get(i).getCol() == newCol) {
                            index = i;
                            break;
                        }
                    }
                    if (index >= 0 && index < entities.size()) {
                        entities.remove(index);
                    }

                    // Update health of martian animal entity
                    if (entity instanceof Heebie) {
                        Heebie heebie = (Heebie) entity;
                        heebie.setHealth(martianAnimalHealth);
                    } else if (entity instanceof Jeebie) {
                        Jeebie jeebie = (Jeebie) entity;
                        jeebie.setHealth(martianAnimalHealth);
                    }

                }

                // Martian animal loses.
                if (martianAnimalHealth <= 0) {
                    System.out.println("Martian Animal died");
                    System.out.println();

                    // delete from map and entity list.
                    deleteSymbol(currentRow, currentCol);
                    habitability.decreaseBy(MARTIANANIMAL);
                    int index = -1;
                    for (int i = 0; i < martianAnimalList.size(); i++) {
                        if (martianAnimalList.get(i).getRow() == currentRow && martianAnimalList.get(i).getCol() == currentCol) {
                            index = i;
                            break;
                        }
                    }
                    if (index >= 0 && index < martianAnimalList.size()) {
                        martianAnimalList.remove(index);
                    }

                    // update dog health
                    for (Entity ent : entities) {
                        if (ent.getRow() == newRow && ent.getCol() == newCol) {
                            if (ent instanceof Dog) {
                                Dog dog = (Dog) ent;
                                dog.setHealth(dogHealth);
                            }
                            break;
                        }
                    }
                }
            }
        } else if (habitat.isEmpty(newRow, newCol)) {

            // updates the position of the entity.
            switch (direction) {
                case "north" -> {
                    entity.moveNorth();
                }
                case "west" -> {
                    entity.moveWest();
                }
                case "east" -> {
                    entity.moveEast();
                }
                case "south" -> {
                    entity.moveSouth();
                }
                case "north-west" -> {
                    entity.moveNorthwest();
                }
                case "south-west" -> {
                    entity.moveSouthwest();
                }
                case "north-east" -> {
                    entity.moveNortheast();
                }
                case "south-east" -> {
                    entity.moveSoutheast();
                }
            }

            // updates the map
            deleteSymbol(currentRow, currentCol);
            insertSymbol(newRow, newCol, symbol);
            // new position is now the current position.
            currentRow = newRow;
            currentCol = newCol;

            // Manage the entity list.
            int index = -1;
            for (int i = 0; i < martianAnimalList.size(); i++) {
                if (martianAnimalList.get(i).getRow() == currentRow && martianAnimalList.get(i).getCol() == currentCol) {
                    index = i;
                    break;
                }
            }
            if (index >= 0 && index < martianAnimalList.size()) {
                martianAnimalList.remove(index);
            }
            martianAnimalList.add(entity);

        } else {
            System.out.println("You cannot move to this location.");
        }

        // Print the updated map, then the menu options after every move.
        System.out.println("Here is a layout of Martian land.");
        System.out.println();
        habitat.printLayout(habitat.getHabitatLayout());
        System.out.println();

        return new int[]{currentRow, currentCol};
    }

    /**
     * Displays all the directions that the entity can move in, and calls further menus.
     * @param scanner for inputs
     * @param entity instance of the entity we want to move.
     */
    private void martianAnimalMoveMenu(Scanner scanner, Entity entity) {

        int currentRow = entity.getRow();
        int currentCol = entity.getCol();

        // loop for direction menu
        while (true) {
            displayMoveMenu("MartianAnimal");
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equals("1")) {
                int[] newPos = moveMartianAnimal("north", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("2")) {
                int[] newPos = moveMartianAnimal("west", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("3")) {
                int[] newPos = moveMartianAnimal("east", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("4")) {
                int[] newPos = moveMartianAnimal("south", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("5")) {
                int[] newPos = moveMartianAnimal("north-west", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("6")) {
                int[] newPos = moveMartianAnimal("south-west", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("7")) {
                int[] newPos = moveMartianAnimal("north-east", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("8")) {
                int[] newPos = moveMartianAnimal("south-east", scanner, entity, currentRow, currentCol);
                currentRow = newPos[0];
                currentCol = newPos[1];
            } else if (input.equals("0")) {
                // return to prev menu
                break;
            } else {
                System.out.println("Invalid Command");
            }
        }
    }

    /**
     * Deletes symbol at given position from the map.
     * @param row given row.
     * @param col given column.
     */
    private void deleteSymbol(int row, int col) {
        char[][] map = habitat.getHabitatLayout();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == row && j == col) {
                    map[i][j] = '.';
                }
            }
        }
        habitat.setHabitatLayout(map);
    }

    /**
     * inserts provided symbol at the given position
     * @param row given row.
     * @param col given column.
     * @param symbol provided symbol.
     */
    private void insertSymbol(int row, int col, char symbol) {
        char[][] map = habitat.getHabitatLayout();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == row && j == col) {
                    map[i][j] = symbol;
                }
            }
        }
        habitat.setHabitatLayout(map);
    }

}
