package ga.selectors;

import ga.BasicChromosome;
import ga.Selector;

/**
 * Selects a chromosome based on the roullete selection
 * @author igor
 *
 */
public class RoulleteSelector extends Selector {
	@Override
	public BasicChromosome getChromosome() {
		int i;
		double aux = 0;
		double limit = getRandom().nextGaussian() * getPopulation().getFitnessSum();

		for (i = 0; i < getPopulation().getSize() & aux < limit; ++i) {
			aux += getPopulation().get(i).getFitness();
		}

		return getPopulation().get(i == 0 ? i : i - 1);
	}
}
