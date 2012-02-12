package ga.mutators;

import java.util.Random;

import ga.Mutator;
import ga.genes.ListGene;

public class PermutateMutator<T> implements Mutator<ListGene<T>> {
	private Random random;
	
	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}

	@Override
	public void mutate(ListGene<T> gene) {
		T temp;
		int i,j;
		
		i = random.nextInt(gene.getValue().size());
		j = random.nextInt(gene.getValue().size());
		
		temp = gene.get(i);
		gene.set(i, gene.get(j));
		gene.set(j, temp);
	}

}
