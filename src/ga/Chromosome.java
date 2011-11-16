package ga;

import java.util.Comparator;

/**
 * Base class for chromosomes
 * 
 * @author Igor Almeida
 * 
 */
public abstract class Chromosome implements Comparable<Chromosome> {
	private double fitness;

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
	public abstract Chromosome crossover(Chromosome chromosome);

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
	public int compareTo(Chromosome o) {
		if (fitness == o.fitness)
			return 0;
		if (fitness > o.fitness)
			return 1;
		return -1;
	}

	public Comparator<Chromosome> getComparator() {
		return new Comparator<Chromosome>() {
			@Override
			public int compare(Chromosome o1, Chromosome o2) {
				return o1.compareTo(o2);
			}

			@Override
			public boolean equals(Object obj) {
				if (!(obj instanceof Chromosome))
					return false;
				return ((Chromosome) obj).getFitness() == fitness;
			}
		};
	}

	/**
	 * Mutates the chromosome with a given probability
	 * @param chance the probability of mutation
	 */
	public void mutate(double chance) {
		if (RandomUtil.getRandom().nextGaussian() < chance)
			mutate();
	}
}
