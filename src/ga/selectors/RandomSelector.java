package ga.selectors;

import ga.BasicChromosome;
import ga.Selector;

/**
 * Select a random chromosome
 * @author igor
 *
 */
public class RandomSelector extends Selector {
	@Override
	public BasicChromosome getChromosome() {
		return getPopulation().getRandomChromosome();
	}
}
