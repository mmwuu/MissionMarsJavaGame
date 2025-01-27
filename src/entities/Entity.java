package entities;

/**
 * You should derive all your entities from this class.
 */

/**
 * This overarching class represents all the entities on the map. Each has a position.
 * @author Michael Yixiao Wu, mywu@student.unimelb.edu.au, stuID: 1388097.
 */
public abstract class Entity {
    private int row;
    private int col;

    /**
     * Each entity has a row and col position,
     * corresponding to their position on the map.
     * @param row row position
     * @param col col position
     */
    public Entity(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    // Updating the position according to the move performed.
    public void moveNorth() {
        this.row--;
    }
    public void moveWest() {
        this.col--;
    }
    public void moveEast() {
        this.col++;
    }
    public void moveSouth() {
        this.row++;
    }
    public void moveNorthwest() {
        this.row--;
        this.col--;
    }
    public void moveSouthwest() {
        this.row++;
        this.col--;
    }
    public void moveNortheast() {
        this.row--;
        this.col++;
    }
    public void moveSoutheast() {
        this.row++;
        this.col++;;
    }
}