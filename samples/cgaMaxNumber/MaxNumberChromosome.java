package cgaMaxNumber;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.BinaryGene;

public class MaxNumberChromosome extends SingleGeneChromosome<BinaryGene> {
    @Override
    protected double fitness() {
        return getGene().toInt();
    }
}
