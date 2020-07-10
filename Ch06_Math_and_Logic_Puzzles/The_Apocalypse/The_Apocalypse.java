import java.util.Random;

/**
 * Simulation of a population when it is enforced for all families to have one daughter, this means that a family keeps getting children until they get a girl,
 * The chances for a boy or a girl are each 0.5.
 * This method simulates the gender ratio for the new generation.
 * 
 * @author Gillis Werrebrouck
 */

public class The_Apocalypse {
    public static void main(final String args[]) {
        simulatePopulation(10000000);
    }

    private static boolean randomGender() {
        Random random = new Random();
        // true = male, false = female
        return random.nextBoolean();
    }

    private static void simulatePopulation(int maxPopulation) {
        int maleCount = 0;
        int femaleCount = 0;

        while((maleCount + femaleCount) < maxPopulation) {
            boolean isBoy = randomGender();
            while(isBoy) {
                maleCount++;
                isBoy = randomGender();
            }
            femaleCount++;
        }

        double totalCount = maleCount + femaleCount;

        System.out.println("# Male: " + Integer.toString(maleCount));
        System.out.println("% Male: " + (double)(maleCount / totalCount * 100) + " %");
        System.out.println("# Female: " + Integer.toString(femaleCount));
        System.out.println("% Female: " + (double)(femaleCount / totalCount * 100) + " %");
    }
}
