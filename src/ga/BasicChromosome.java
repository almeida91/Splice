package ga;

import java.util.Comparator;
import java.util.Random;

/**
 * Base class for chromosomes
 * 
 * @author Igor Almeida
 * 
 */
public abstract class BasicChromosome implements Comparable<BasicChromosome>, RandomComponent {
	private double fitness;
	private Random random;

	/**
	 * Implementation of the fitness function
	 * 
	 * @return
	 */
	protected abstract double fitness();

	/**
	 * Implementation of the chromosome's mutation logic
	 */
	protected abstract void mutate();

	/**
	 * Performs the chromosome's crossover with a given
	 * 
	 * @param chromosome
	 * @return
	 */
	public abstract BasicChromosome crossover(BasicChromosome chromosome);

	/**
	 * Calculate the chromosome's fitness
	 * @return
	 */
	public double calculateFitness() {
		fitness = fitness();
		return fitness;
	}

	public double getFitness() {
		return fitness;
	}

	@Override
	public int compareTo(BasicChromosome o) {
		if (fitness == o.fitness)
			return 0;
		if (fitness > o.fitness)
			return 1;
		return -1;
	}

	public Comparator<BasicChromosome> getComparator() {
		return new Comparator<BasicChromosome>() {
			@Override
			public int compare(BasicChromosome o1, BasicChromosome o2) {
				return o1.compareTo(o2);
			}

			@Override
			public boolean equals(Object obj) {
				if (!(obj instanceof BasicChromosome))
					return false;
				return ((BasicChromosome) obj).getFitness() == fitness;
			}
		};
	}

	/**
	 * Mutates the chromosome with a given probability
	 * @param chance the probability of mutation
	 */
	public void mutate(double chance) {
		if (getRandom().nextGaussian() < chance)
			mutate();
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
