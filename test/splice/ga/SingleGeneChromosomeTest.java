package splice.ga;

import org.junit.Before;
import org.junit.Test;
import splice.ga.genes.BinaryGene;
import util.MockCrossover;
import util.MockMutator;
import util.MockSingleGeneChromosome;

import static org.junit.Assert.*;

/**
 * @author igor
 */
public class SingleGeneChromosomeTest {
    private MockSingleGeneChromosome chromosome;
    private BinaryGene gene;
    private MockCrossover crossover;
    private MockMutator mutator;

    @Before
    public void setUp() throws Exception {
        chromosome = new MockSingleGeneChromosome();
        gene = new BinaryGene(42);
        crossover = new MockCrossover();
        mutator = new MockMutator();

        chromosome.setGene(gene);
        chromosome.setCrossover(crossover);
        chromosome.setMutator(mutator);
    }

    @Test
    public void testGetGene() throws Exception {
        assertEquals(gene, chromosome.getGene());
    }

    @Test
    public void testCrossover() throws Exception {
        MockSingleGeneChromosome c = (MockSingleGeneChromosome) chromosome.crossover(chromosome);

        assertEquals(chromosome, c);
        assertEquals(gene, c.getGene());

        assertTrue(crossover.isCalled());
        assertEquals(1, crossover.getTimesCalled());
    }

    @Test
    public void testMutate() throws Exception {
        chromosome.mutate();
        assertTrue(mutator.isCalled());
        assertEquals(1, mutator.getTimesCalled());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(gene.toString(), chromosome.toString());
    }

    @Test
    public void testEquals() throws Exception {
        assertFalse(chromosome.equals(new Object()));
        assertTrue(chromosome.equals(chromosome));
    }
}
