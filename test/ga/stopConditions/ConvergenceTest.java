package ga.stopConditions;

import static org.junit.Assert.*;
import ga.BasicChromosome;
import ga.GenerationData;

import org.junit.Before;
import org.junit.Test;

import util.TestChromosome;

public class ConvergenceTest {
	Convergence condition;
	GenerationData data;
	BasicChromosome bestStop;
	BasicChromosome bestContinue;
	final int GENERATIONS = 1000;
	final int MAX = 100;
	final double MINIMUM_FITNESS = 0.7;
	final double STEP = 0.1;
	
	@Before
	public void setUp() {
		data = new GenerationData();
		bestContinue = new TestChromosome(MINIMUM_FITNESS - STEP);
		bestStop = new TestChromosome(MINIMUM_FITNESS + STEP); 
	}

	@Test
	public void testStop() {
		condition = new Convergence(GENERATIONS);
		
	}

	@Test
	public void testStopMinFitness() {
		condition = new Convergence(GENERATIONS, MINIMUM_FITNESS);
		
	}
}
