package tsp;

import splice.ga.BasicChromosome;

public class TspChromosome extends BasicChromosome {

	@Override
	protected double fitness() {
		return 0;
	}

	@Override
	protected void mutate() {
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		return null;
	}

}
