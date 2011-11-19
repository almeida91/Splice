package ga;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import util.TestChromosomeFactory;

public class PopulationTest {
	Population population;
	final int CHROMOSOMES = 300;
	final double FITNESS = 1;
	Random random;
	
	@Before
	public void setUp() throws Exception {
		population = new Population(CHROMOSOMES, new TestChromosomeFactory(FITNESS));
		random = new Random();
		population.setRandom(random);
	}
	
	@Test
	public void testCalculateFitnessSum() {
		testInitializePopulation();
		population.calculateFitnessSum();
		assertEquals("fitness sum not expected", CHROMOSOMES * FITNESS, population.getFitnessSum(), 0);
		assertEquals("fitness average not expected", FITNESS, population.getFitnessAverage(), 0.5);
	}

	@Test
	public void testInitializePopulation() {
		population.initializePopulation();
		assertEquals(CHROMOSOMES, population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			assertNotNull(population.get(i));
		}
	}

	/**
	 * should always return some chromosome
	 */
	@Test
	public void testGetRandom() {
		testInitializePopulation();
		assertNotNull("no random chromosome", population.getRandomChromosome());
	}

}
