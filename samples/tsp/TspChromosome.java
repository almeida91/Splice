package tsp;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.ListGene;

public class TspChromosome extends SingleGeneChromosome<ListGene<Integer>> {

	@Override
	protected double fitness() {
		return 0;
	}

	@Override
	protected SingleGeneChromosome<ListGene<Integer>> getNew() {
		// TODO Auto-generated method stub
		return null;
	}

}
