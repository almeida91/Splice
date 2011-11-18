package ga.selectors;

import ga.Chromosome;
import ga.Selector;

/**
 * Selects a chromosome using a k-sized tournament
 * @author igor
 *
 */
public class TournamentSelector extends Selector {
	public int k;

	/**
	 * @param size the tournament size
	 */
	public TournamentSelector(int size) {
		k = size;
	}

	@Override
	public Chromosome getChromosome() {
		Chromosome chromosome = getPopulation().getRandomChromosome(), temp;
		double fitness = chromosome.getFitness();

		for (int i = 0; i < k; i++) {
			temp = getPopulation().getRandomChromosome();
			if (temp.getFitness() > fitness)
				chromosome = temp;
		}

		return chromosome;
	}
}
