package ga;

import java.util.Comparator;

/**
 * Base class for chromossomes
 * 
 * @author Igor Almeida
 * 
 */
public abstract class Chromossome implements Comparable<Chromossome> {
	private double fitness;

	protected abstract double fitness();
	protected abstract void mutate();
	public abstract Chromossome crossover(Chromossome genome);
	
	public double calculateFitness() {
		fitness = fitness();
		return fitness;
	}
	
	public double getFitness() {
		return fitness;
	}

	@Override
	public int compareTo(Chromossome o) {
		if (fitness == o.fitness)
			return 0;
		if (fitness > o.fitness)
			return 1;
		return -1;
	}

	public Comparator<Chromossome> getComparator() {
		return new Comparator<Chromossome>() {
			@Override
			public int compare(Chromossome o1, Chromossome o2) {
				return o1.compareTo(o2);
			}

			@Override
			public boolean equals(Object obj) {
				if (obj.getClass() != Chromossome.class)
					return false;
				return ((Chromossome) obj).getFitness() == fitness;
			}
		};
	}

	public void mutate(double chance) {
		if (RandomUtil.getRandom().nextGaussian() < chance)
			mutate();
	}
}
