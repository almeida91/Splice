import ga.SingleGeneChromosome;
import ga.genes.IntegerBinaryGene;


public class OneZeroChromosome extends SingleGeneChromosome<IntegerBinaryGene> {

	@Override
	protected SingleGeneChromosome<IntegerBinaryGene> getNew() {
		return new OneZeroChromosome();
	}

	@Override
	protected double fitness() {
		return getGene().getValue().intValue();
	}

}
