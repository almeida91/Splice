package ga.mutators;

import ga.genes.BinaryGene;

public class SingleBitBinaryMutator extends MultiBitBinaryMutator {
	public SingleBitBinaryMutator() {
		super(1);
	}
	
	@Override
	public void mutate(BinaryGene gene) {
		gene.setValue(gene.getValue().flipBit(getRandom().nextInt(gene.getLength())));
	}
}
