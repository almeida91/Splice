package ga;

import java.util.ArrayList;
import java.util.Random;

/**
 * base class for classes that needs access to the population
 * @author igor
 *
 */
abstract class PopulationManipulator implements RandomComponent {
	private Population population;
	private Random random;

	public void setPopulation(ArrayList<Chromosome> population) {
		this.population.getChromosomes().clear();
		this.population.getChromosomes().addAll(population);
	}
	
	public void setPopulation(Population population) {
		this.population = population;
	}

	public Population getPopulation() {
		return population;
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
