package ga;

import java.util.ArrayList;

abstract class PopulationManipulator {
	private Population population;

	public void setPopulation(ArrayList<Chromossome> population) {
		this.population.getChromossomes().clear();
		this.population.getChromossomes().addAll(population);
	}
	
	public void setPopulation(Population population) {
		this.population = population;
	}

	public Population getPopulation() {
		return population;
	}
}
