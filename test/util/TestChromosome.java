package util;

import ga.Chromosome;

/**
 * Simple chromosome used to run the tests
 * @author igor almeida
 *
 */
public class TestChromosome extends Chromosome {
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
	public Chromosome crossover(Chromosome chromosome) {
		return null;
	}

}
