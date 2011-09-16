package ga;

import java.util.Comparator;

/**
 * Base class for chromossomes
 * @author Igor Almeida
 *
 */
public abstract class Genome implements Comparable<Genome> {
	/**
	 * the fitness value of the genome, it is protected so subclasses can freely modify its value
	 */
	protected double fitness;
	
	public abstract double calculateFitness();
	protected abstract void mutate();
	public abstract Genome crossover(Genome genome);

	public double getFitness() {
		return fitness;
	}

	@Override
	public int compareTo(Genome o) {
		if (fitness == o.fitness)
			return 0;
		if (fitness > o.fitness)
			return 1;
		return -1;
	}

	public Comparator<Genome> getComparator() {
		return new Comparator<Genome>() {
			@Override
			public int compare(Genome o1, Genome o2) {
				return o1.compareTo(o2);
			}
			
			@Override
			public boolean equals(Object obj) {
				if (obj.getClass()!=Genome.class)
					return false;
				return ((Genome)obj).getFitness() == fitness;
			}
		};
	}

	public void mutate(double chance) {
		if (RandomUtil.getRandom().nextGaussian() < chance)
			mutate();
	}
}
