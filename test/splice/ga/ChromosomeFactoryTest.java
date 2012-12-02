package splice.ga;

import org.junit.Before;
import org.junit.Test;
import splice.RandomComponentTest;
import util.MockBasicChromosomeFactory;
import util.MockCrossover;
import util.MockMutator;

import static org.junit.Assert.*;

/**
 * @author igor
 */
public class ChromosomeFactoryTest {
    private MockBasicChromosomeFactory factory;
    private Mutator mutator;

    @Before
    public void setUp() throws Exception {
        factory = new MockBasicChromosomeFactory(0.5);
    }

    @Test
    public void testGenerateChromosome() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testInitialize() throws Exception {
        fail("Not yet implemented");
    }

    @Test
    public void testSetRandom() throws Exception {
        RandomComponentTest.doTest(factory);
    }

    @Test
    public void testSetMutator() throws Exception {
        factory.setMutator(new MockMutator());
        assertNotNull(factory.getMutator());
    }

    @Test
    public void testSetCrossover() throws Exception {
        factory.setCrossover(new MockCrossover());
        assertNotNull(factory.getCrossover());
    }
}
