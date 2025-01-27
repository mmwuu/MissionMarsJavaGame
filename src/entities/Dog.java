package entities;

/**
 * This class is the Dog. It keeps track of its health.
 * @author Michael Yixiao Wu | mywu@student.unimelb.edu.au | 1388097
 */
public class Dog extends EarthAnimalEntity{
    private int health;

    /**
     * Constructor for Dog, sets starting health to 10.
     * @param row position in array map
     * @param col position in array map
     */
    public Dog(int row, int col) {
        super(row, col);
        this.health = 10;
    }

    public void increaseHealth(int increment) {
        this.health += increment;
    }

    public void decreaseHealth(int decrement) {
        this.health += decrement;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
