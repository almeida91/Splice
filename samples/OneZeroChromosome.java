import splice.ga.SingleGeneChromosome;
import splice.ga.genes.BinaryGene;

public class OneZeroChromosome extends SingleGeneChromosome<BinaryGene> {
	@Override
	protected SingleGeneChromosome<BinaryGene> getNew() {
		return new OneZeroChromosome();
	}

	@Override
	protected double fitness() {
		return getGene().getValue().intValue();
	}
}
