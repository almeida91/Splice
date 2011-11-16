package knapsack;

import ga.Chromosome;

public class KnapsackChromosome extends Chromosome {

	@Override
	protected double fitness() {
		return 0;
	}

	@Override
	protected void mutate() {
	}

	@Override
	public Chromosome crossover(Chromosome chromosome) {
		return null;
	}

}
