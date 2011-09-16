package ga;

import java.util.ArrayList;

abstract class PopulationManipulator {
	private Population population;

	public void setPopulation(ArrayList<Genome> population) {
		this.population.getGenomes().clear();
		this.population.getGenomes().addAll(population);
	}
	
	public void setPopulation(Population population) {
		this.population = population;
	}

	public Population getPopulation() {
		return population;
	}
}
