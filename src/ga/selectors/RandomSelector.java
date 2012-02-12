package ga.selectors;

import java.util.Random;

import ga.BasicChromosome;
import ga.MaxmizeSelector;
import ga.MinimizeSelector;
import ga.Population;

/**
 * Select a random chromosome
 * @author igor
 *
 */
public class RandomSelector implements MinimizeSelector, MaxmizeSelector {
	private Population population;
	private Random random;
	
	@Override
	public BasicChromosome getChromosome() {
		return population.getRandomChromosome();
	}

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
}
