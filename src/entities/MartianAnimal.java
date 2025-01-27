package entities;

/**
 * This class is the martian animal. It keeps track of its health.
 * @author Michael Yixiao Wu | mywu@student.unimelb.edu.au | 1388097
 */
public abstract class MartianAnimal extends SpaceEntity{
    private int health;

    /**
     * Constructor for MartianAnimal, sets starting health to 15.
     * @param x coordinate
     * @param y coordinate
     */
    public MartianAnimal(int x, int y) {
        super(x, y);
        this.health = 15;
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
