package zeros;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.ListGene;

public class ZerosChromosome extends SingleGeneChromosome<ListGene<Integer>> {
	@Override
	protected SingleGeneChromosome<ListGene<Integer>> getNew() {
		return new ZerosChromosome();
	}

	@Override
	protected double fitness() {
		double f = 0;
		
		for (int i = 0; i < this.getGene().getSize(); i++) {
			if (this.getGene().get(i) == 0) {
				f++;
			}
		}
		
		return f;
	}
}
