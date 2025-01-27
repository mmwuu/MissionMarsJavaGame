import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import entities.*;

/**
 * This class manages the layout / map of the habitat.
 * @author Michael Yixiao Wu | mywu@student.unimelb.edu.au | 1388097
 *
 */
public class MarsHabitat {

    // Width is the number of rows going down vertically.
    // Length is the number of characters horizontally.
    private int length;
    private int width;
    private char[][] habitatLayout = new char[width][length];


    /**
     * Initialises a 2D array 2D array to represent map layout.
     * Takes in the list of lines from the input file.
     * @param width the width of the layout
     * @param length the length of the layout
     * @param mapTextList contents of the map file we loaded from, stored in list form.
     * @return contents of the map file we loaded from, stored in 2D char array form.
     *
     */
    public char[][] initLayout(int width, int length, List<String> mapTextList) {
        char[][] habitatLayout = new char[width][length];

        // Store the list by char
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                habitatLayout[i][j] = mapTextList.get(i).charAt(j);
            }
        }
        return habitatLayout;
    }


    // Helper method to print the layout of the habitat.
    public void printLayout(char[][] habitatLayout) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(habitatLayout[i][j]);
            }
            System.out.println();
        }
    }


    /**
     * Loads and prints the habitat layout map from a file
     * @param fileName the file that we load the map from.
     * @throws FileNotFoundException when a file of that name is not found.
     *
     */
    public void printMap(String fileName) {
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileReader(fileName));

            List<String> map = new ArrayList<>();
            while (inputStream.hasNextLine()) {
                map.add(inputStream.nextLine());
            }

            if (!map.isEmpty()) {
                boolean invalidFile = false;
                boolean hasUnknownEntity = false;

                // Checks if top and bottom lines are made up of #'s
                String topBorder = map.get(0);
                String bottomBorder = map.get(map.size() - 1);

                // Uses the regular expression of #
                if (!topBorder.matches("^#+$") || !bottomBorder.matches("^#+$")) {
                    invalidFile = true;
                }

                // The length of the first line
                int firstLineLength = map.get(0).length();

                // Checks if the middle lines start and end with '#'
                for (String string : map) {
                    if (firstLineLength != string.length() || string.charAt(0) != '#' || string.charAt(string.length() - 1) != '#') {
                        invalidFile = true;
                        break;
                    }
                }

                // Checks if there are unknown entities present in the Martian land
                for (String s : map) {
                    if (!s.matches("^[.#ZXHJPTORLABECGSD@*]+$")) {
                        hasUnknownEntity = true;
                        break;
                    }
                }

                if (invalidFile) {
                    System.out.println("Invalid file content, Aborting mission.");
                    System.exit(1);
                } else if (hasUnknownEntity){
                    System.out.println("An unknown item found in Martian land. Aborting mission.");
                    System.exit(1);
                } else {
                    System.out.println("Here is a layout of Martian land.");
                    System.out.println();

                    width = map.size();
                    length = firstLineLength;
                    habitatLayout = initLayout(width, length, map);

                    printLayout(habitatLayout);
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found, aborting mission.");
            System.exit(1);
        }
        inputStream.close();
    }

    // Checks if the given position is a boundary wall.
    public boolean isBoundary(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == '#';
    }

    // Checks if the given position is empty.
    public boolean isEmpty(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == '.';
    }

    // Checks if the position to the left of the given position is empty. For robot actions.
    public boolean leftIsEmpty(int newRow, int newCol) {
        return habitatLayout[newRow][newCol - 1] == '.';
    }

    // Checks if the position is occupied by a plant or vegetation.
    public boolean isPlant(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == 'P' ||
                habitatLayout[newRow][newCol] == 'T' ||
                habitatLayout[newRow][newCol] == 'O' ||
                habitatLayout[newRow][newCol] == 'R' ||
                habitatLayout[newRow][newCol] == 'L' ||
                habitatLayout[newRow][newCol] == 'A' ||
                habitatLayout[newRow][newCol] == 'B' ||
                habitatLayout[newRow][newCol] == 'E';
    }

    // Checks if the position is occupied by a cattle / earth animal.
    public boolean isCattle(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == 'C' ||
                habitatLayout[newRow][newCol] == 'G' ||
                habitatLayout[newRow][newCol] == 'S' ||
                habitatLayout[newRow][newCol] == 'D';
    }

    // Rest are self explanatory.
    public boolean isRock(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == '@';
    }

    public boolean isMineral(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == '*';
    }

    public boolean isAnimalNotDog(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == 'C' ||
                habitatLayout[newRow][newCol] == 'G' ||
                habitatLayout[newRow][newCol] == 'S';
    }

    public boolean isDog(int newRow, int newCol) {
        return habitatLayout[newRow][newCol] == 'D';
    }

    public char[][] getHabitatLayout() {
        return habitatLayout;
    }

    public void setHabitatLayout(char[][] habitatLayout) {
        this.habitatLayout = habitatLayout;
    }

}
