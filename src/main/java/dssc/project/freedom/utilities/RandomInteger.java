package dssc.project.freedom.utilities;

import java.util.Random;

/**
 * Implementation of the interface {@link RandomGenerator} to return random integers.
 */
public class RandomInteger implements RandomGenerator {

    /**
     * Generate a random integer form 0 to a given upper bound.
     * @param upperBound The upper bound of the random integer.
     * @return A random integer form 0 to the given upperbound.
     */
    @Override
    public int getRandomInteger(int upperBound) {
        return new Random().nextInt(upperBound);
    }
}