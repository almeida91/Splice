package splice.ga.crossovers;

import org.junit.Test;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * @author igor
 */
public class MaskBinaryCrossoverTest {
    @Test
    public void testDoCrossover() throws Exception {
        MaskBinaryCrossover crossover = new MaskBinaryCrossover(new BigInteger("111111110000000011111111", 2));

        BinaryGene a = new BinaryGene(new BigInteger("111111111111111111111111", 2));
        BinaryGene b = new BinaryGene(BigInteger.ZERO);

        BinaryGene c = crossover.doCrossover(a, b);

        assertEquals("111111110000000011111111", c.toString());
    }
}
