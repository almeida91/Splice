package splice.ga.selectors;

import java.util.Random;

import splice.ga.BasicChromosome;
import splice.ga.MinimizeSelector;
import splice.ga.Population;


public class MinimizeTournametSelector implements MinimizeSelector {
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
	public Population getPopulation() {
		return population;
	}

	@Override
	public void beforeGeneration() { }
	
	@Override
	public BasicChromosome getChromosome() {
		BasicChromosome a,b;
		a = population.getRandomChromosome();
		b = population.getRandomChromosome();
		
		if (a.getFitness() < b.getFitness())
			return a;
		else
			return b;
	}
}
