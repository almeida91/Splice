package ga.mutators;

import static org.junit.Assert.*;

import ga.genes.IntegerBinaryGene;

import java.math.BigInteger;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SingleBitBinaryMutatorTest {
	SingleBitBinaryMutator mutator;
	Random random;

	@Before
	public void setUp() throws Exception {
		random = new Random();
		
		mutator = new SingleBitBinaryMutator();
		mutator.setRandom(random);
	}

	@Test
	public void testMutate() {
		BigInteger originalValue, value = new BigInteger(512, random);
		originalValue = value.or(BigInteger.ZERO);
		IntegerBinaryGene gene = new IntegerBinaryGene(value);
		
		mutator.mutate(gene);
		
		assertEquals(1, gene.getValue().xor(originalValue).bitCount());
	}

}
