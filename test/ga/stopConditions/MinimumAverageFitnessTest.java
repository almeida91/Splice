package ga.stopConditions;

import static org.junit.Assert.*;
import ga.GenerationData;

import org.junit.Before;
import org.junit.Test;

public class MinimumAverageFitnessTest {
	final double MINIMUM_FITNESS = 0.5;
	final double STEP = 0.6;
	MinimumAverageFitness condition;
	GenerationData data;

	@Before
	public void setUp() throws Exception {
		condition = new MinimumAverageFitness(MINIMUM_FITNESS);
		data = new GenerationData();
		
	}

	@Test
	public void testStop() {
		data.setFitnessAverage(MINIMUM_FITNESS + STEP);
		assertTrue(condition.stop(data));
		data.setFitnessAverage(MINIMUM_FITNESS - STEP);
		assertFalse(condition.stop(data));
	}

}