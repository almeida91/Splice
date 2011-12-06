package knapsack;

import ga.BasicChromosome;

public class KnapsackChromosome extends BasicChromosome {

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
