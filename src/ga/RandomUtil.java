package ga;

import java.util.Random;

public final class RandomUtil {
	private static Random random;
	
	public static Random getRandom() {
		if (random==null)
			random=new Random();
		return random;
	}
}
