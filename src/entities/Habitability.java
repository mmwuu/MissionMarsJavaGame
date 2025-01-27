package entities;

/**
 * This class handles the habitability score.
 * @author Michael Yixiao Wu | mywu@student.unimelb.edu.au | 1388097
 *
 */
public class Habitability {

    private int habitabilityScore = 0;

    public int getScore(){
        return habitabilityScore;
    }

    public void increaseBy(int increment) {
        habitabilityScore += increment;
    }

    public void decreaseBy(int decrement) {
        habitabilityScore -= decrement;
    }
}
