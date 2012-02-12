package ga.selectors;

import java.util.Random;

import ga.BasicChromosome;
import ga.MaxmizeSelector;
import ga.Population;

/**
 * Selects a chromosome using a k-sized tournament
 * @author igor
 *
 */
public class TournamentSelector implements MaxmizeSelector {
	public int k;
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

	/**
	 * @param size the tournament size
	 */
	public TournamentSelector(int size) {
		k = size;
	}

	@Override
	public BasicChromosome getChromosome() {
		BasicChromosome chromosome = population.getRandomChromosome(), temp;
		double fitness = chromosome.getFitness();

		for (int i = 0; i < k; i++) {
			temp = population.getRandomChromosome();
			if (temp.getFitness() > fitness)
				chromosome = temp;
		}

		return chromosome;
	}
}
