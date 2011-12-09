package ga.mutators;

import java.util.Random;

import ga.Mutator;
import ga.genes.BinaryGene;

public class MultiBitBinaryMutator implements Mutator<BinaryGene> {
	private int nBits;
	private Random random;
	
	public MultiBitBinaryMutator(int numBits) {
		nBits = numBits;
	}
	
	@Override
	public void mutate(BinaryGene gene) {
		for (int i = 0; i < nBits; i++) {
			gene.getValue().flipBit(random.nextInt(gene.getLength()));
		}
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
