import java.math.BigInteger;

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;
import splice.ga.SingleGeneChromosome;
import splice.ga.crossovers.SinglePointBinaryCrossover;
import splice.ga.genes.BinaryGene;
import splice.ga.mutators.SingleBitBinaryMutator;


public class OneZeroChromosomeFactory extends ChromosomeFactory<BinaryGene> {
	private int limit;
	
	public OneZeroChromosomeFactory(int limit) {
		this.limit = limit;
	}
	
	@Override
	public void initialize() {
		setMutator(new SingleBitBinaryMutator());
		setCrossover(new SinglePointBinaryCrossover());
	}
	
	@Override
	public BasicChromosome getRandomChromosome() {
		SingleGeneChromosome<BinaryGene> c = new OneZeroChromosome();
		c.setGene(new BinaryGene(new BigInteger(String.valueOf(getRandom().nextInt(limit)))));
		return c;
	}
}
