package ga.selectors;

import java.util.Random;

import ga.BasicChromosome;
import ga.MaxmizeSelector;
import ga.Population;

/**
 * Selects a chromosome based on the roullete selection
 * @author igor
 *
 */
public class RoulleteSelector implements MaxmizeSelector {
	private Population population;
	private Random random;
	
	@Override
	public void setPopulation(Population population) {
		this.population = population;
	}

	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}
	
	@Override
	public BasicChromosome getChromosome() {
		int i;
		double aux = 0;
		double limit = getRandom().nextGaussian() * population.getFitnessSum();

		for (i = 0; i < population.getSize() & aux < limit; ++i) {
			aux += population.get(i).getFitness();
		}

		return population.get(i == 0 ? i : i - 1);
	}
}
