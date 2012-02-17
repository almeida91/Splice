package ga;

import java.util.Comparator;

public class ChromosomeComparator implements Comparator<BasicChromosome> {
	private double fitness;
	
	public ChromosomeComparator(double fitness) {
		this.fitness = fitness;
	}
	
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
}
