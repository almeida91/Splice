package ga.mutators;

import java.util.Random;

import ga.Mutator;
import ga.genes.ListGene;

public class GaussianMutator implements Mutator<ListGene<Number>> {
	private Random random;
	private double x,y;

	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}

	@Override
	public void mutate(ListGene<Number> gene) {
		gene.set(random.nextInt(gene.getSize()), ((random.nextGaussian() * (y - x)) + x));
	}

}
