package ga;

import java.util.ArrayList;

public class MaxmizeGeneticAlgorithm extends GeneticAlgorithm {
	public MaxmizeGeneticAlgorithm(ChromossomeFactory factory,
			PopulationAllocator allocator, Selector selector) {
		super(factory, allocator, selector);
	}

	@Override
	protected ArrayList<Chromossome> doGeneneration() {
		ArrayList<Chromossome> newPopulation = new ArrayList<Chromossome>();
		Chromossome a, b, c;

		getPopulation().sort();

		for (int i = 0; i < getPopulationSize(); i++) {
			a = getChromossome();
			b = getChromossome();
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
	public Chromossome getBest() {
		double fitness = 0;
		Chromossome chromossome = null;
		for (Chromossome g : getPopulation().getChromossomes()) {
			if (g.getFitness() >= fitness) {
				fitness = g.getFitness();
				chromossome = g;
			}
		}
		return chromossome;
	}

	@Override
	public Chromossome getWorst() {
		Chromossome chromossome = getPopulation().getRandom();
		double fitness = chromossome.getFitness();
		for (Chromossome g : getPopulation().getChromossomes()) {
			if (g.getFitness() <= fitness) {
				fitness = g.getFitness();
				chromossome = g;
			}
		}
		return chromossome;
	}

}
