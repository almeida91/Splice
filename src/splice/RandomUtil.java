package splice;

import java.util.Random;

/**
 * @author igor
 */
public class RandomUtil {
    private static Random iRandom = null;

    public static Random getInternalRandom() {
        if (iRandom == null)
            iRandom = new Random();

        return iRandom;
    }

    public static void setInternalRandom(Random internalRandom) {
        iRandom = internalRandom;
    }

    public synchronized static Random getRandom() {
        return new Random(getInternalRandom().nextLong());
    }
}
