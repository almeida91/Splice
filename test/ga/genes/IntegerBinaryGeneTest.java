package ga.genes;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class IntegerBinaryGeneTest {
	IntegerBinaryGene gene;
	final int LENGTH = 512;

	@Before
	public void setUp() throws Exception {
		gene = new IntegerBinaryGene(LENGTH);
		gene.setRandom(new Random());
	}

	@Test
	public void testInitialize() {
		gene.initialize();
		assertNotNull(gene.getValue());
		assertEquals(LENGTH, gene.getValue().bitLength(), 8.0);
	}

}
