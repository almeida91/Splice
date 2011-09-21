package ga;

import java.util.ArrayList;

/**
 * base class for classes that needs access to the population
 * @author igor
 *
 */
abstract class PopulationManipulator {
	private Population population;

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
}
