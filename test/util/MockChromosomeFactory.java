package util;

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;
import splice.ga.genes.BinaryGene;

/**
 * @author igor
 */
public class MockChromosomeFactory extends ChromosomeFactory<BinaryGene> {

    @Override
    public BasicChromosome getRandomChromosome() {
        return new MockChromosome();
    }
}
