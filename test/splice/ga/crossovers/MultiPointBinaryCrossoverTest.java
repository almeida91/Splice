package splice.ga.crossovers;

import org.junit.Test;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * @author igor
 */
public class MultiPointBinaryCrossoverTest {
    @Test
    public void testDoCrossover() throws Exception {
        MultiPointBinaryCrossover crossover = new MultiPointBinaryCrossover(2);

        BinaryGene a = new BinaryGene(new BigInteger("111111111111111111111100", 2));
        BinaryGene b = new BinaryGene(BigInteger.ZERO);

        BinaryGene c = crossover.doCrossover(a, b);

        assertEquals("111111110000000011111100", c.toString());
    }
}
