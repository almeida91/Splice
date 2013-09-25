package splice.ga;

import org.junit.Test;
import splice.ga.genes.BinaryGene;
import util.*;

import static org.junit.Assert.*;

/**
 * @author igor
 */
public class ChromosomeFactoryTest {
    final int GENES_SIZE = 4;

    @Test
    public void testWithBasicChromosome() throws Exception {
        MockBasicChromosomeFactory factory = new MockBasicChromosomeFactory(0.5);
        assertNotNull(factory.generateChromosome());
        assertEquals(ChromosomeType.BASIC, factory.getChromosomeType());
    }

    @Test
    public void testWithChromosome() throws Exception {
        MockChromosomeFactory factory = new MockChromosomeFactory();

        factory.setGene(new BinaryGene(0));
        factory.setSize(GENES_SIZE);
        factory.setMutator(new MockMutator());
        factory.setCrossover(new MockCrossover());

        MockChromosome chromosome = (MockChromosome)factory.generateChromosome();

        assertEquals(ChromosomeType.NORMAL, factory.getChromosomeType());
        assertNotNull(chromosome);
    }
}
