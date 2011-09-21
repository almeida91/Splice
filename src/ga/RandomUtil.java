package ga;

import java.util.Random;

/**
 * A singleton for a random object, so other classes don't have to create new
 * objects
 * 
 * @author igor
 * 
 */
public final class RandomUtil {
	private static Random random;

	public static Random getRandom() {
		if (random == null)
			random = new Random();
		return random;
	}
}
