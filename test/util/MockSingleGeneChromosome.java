package util;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.BinaryGene;

/**
 * @author igor
 */
public class MockSingleGeneChromosome extends SingleGeneChromosome<BinaryGene> {
    @Override
    protected double fitness() {
        return 0;
    }
}
