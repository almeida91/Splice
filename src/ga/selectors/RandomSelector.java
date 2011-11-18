package ga.selectors;

import ga.Chromosome;
import ga.Selector;

/**
 * Select a random chromosome
 * @author igor
 *
 */
public class RandomSelector extends Selector {
	@Override
	public Chromosome getChromosome() {
		return getPopulation().getRandomChromosome();
	}
}
