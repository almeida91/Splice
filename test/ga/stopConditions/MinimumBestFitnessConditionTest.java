package ga.stopConditions;

import static org.junit.Assert.*;

import ga.BasicChromosome;
import ga.GenerationData;

import org.junit.Before;
import org.junit.Test;

import util.TestChromosome;

public class MinimumBestFitnessConditionTest {
	GenerationData data;
	BasicChromosome bestStop, bestContinue;
	MinimumBestFitness condition;
	final double MINIMUM_FITNESS = 0.7;
	final double STEP = 0.1;

	@Before
	public void setUp() throws Exception {
		condition = new MinimumBestFitness(MINIMUM_FITNESS);
		data = new GenerationData();
		bestStop = new TestChromosome(MINIMUM_FITNESS + STEP);
		bestContinue = new TestChromosome(MINIMUM_FITNESS - STEP); 
		bestStop.calculateFitness();
		bestContinue.calculateFitness();
	}

	@Test
	public void testStop() {
		data.setBestChromosome(bestStop);
		assertTrue("don't stop", condition.stop(data));
		data.setBestChromosome(bestContinue);
		assertFalse("premature stop", condition.stop(data));
	}

}
