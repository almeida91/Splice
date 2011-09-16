package ga;

import java.util.ArrayList;

public class MaxmizeGeneticAlgorithm extends GeneticAlgorithm {
	public MaxmizeGeneticAlgorithm(GenomeFactory factory,
			PopulationAllocator allocator, Selector selector) {
		super(factory, allocator, selector);
	}

	@Override
	protected ArrayList<Genome> doGeneneration() {
		ArrayList<Genome> newPopulation = new ArrayList<Genome>();
		Genome a, b, c;

		getPopulation().sort();

		for (int i = 0; i < getPopulationSize(); i++) {
			a = getGenome();
			b = getGenome();
			c = a.crossover(b);
			mutate(c);
			newPopulation.add(c);

			if (RandomUtil.getRandom().nextDouble() < getCrossoverRate()) {
				c = b.crossover(a);
				mutate(c);
				newPopulation.add(c);
				i++;
			}
		}

		return newPopulation;
	}

	@Override
	public Genome getBest() {
		double fitness = 0;
		Genome genome = null;
		for (Genome g : getPopulation().getGenomes()) {
			if (g.calculateFitness() >= fitness) {
				fitness = g.getFitness();
				genome = g;
			}
		}
		return genome;
	}

	@Override
	public Genome getWorst() {
		Genome genome = getPopulation().getRandom();
		double fitness = genome.getFitness();
		for (Genome g : getPopulation().getGenomes()) {
			if (g.getFitness() <= fitness) {
				fitness = g.getFitness();
				genome = g;
			}
		}
		return genome;
	}

}
