package util;

import ga.BasicChromosome;

/**
 * Simple chromosome used to run the tests
 * @author igor almeida
 *
 */
public class TestChromosome extends BasicChromosome {
	double value;
	
	public TestChromosome(double value) {
		this.value = value;
	}
	
	@Override
	protected double fitness() {
		return value;
	}

	@Override
	protected void mutate() {
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		return null;
	}

}
