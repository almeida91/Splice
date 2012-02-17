package ga.selectors;

import static org.junit.Assert.*;

import java.util.Random;

import ga.Population;

import org.junit.Before;
import org.junit.Test;

import util.TestChromosomeFactory;

public class RandomSelectorTest {
	Population population;
	final double FITNESS = 0.8;
	RandomSelector selector;
	Random random;

	@Before
	public void setUp() throws Exception {
		random = new Random();
		
		population = new Population();
		population.setSize(300);
		population.setFactory(new TestChromosomeFactory(FITNESS));
		population.setRandom(random);
		population.initialize();
		
		selector = new RandomSelector();
		selector.setRandom(random);
		selector.setPopulation(population);
	}

	@Test
	public void test() {
		assertNotNull(selector.getChromosome());
		assertEquals(FITNESS, selector.getChromosome().calculateFitness(), 0);
	}

}
