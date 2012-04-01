import java.math.BigInteger;

import ga.BasicChromosome;
import ga.ChromosomeFactory;
import ga.SingleGeneChromosome;
import ga.crossovers.SinglePointBinaryCrossover;
import ga.genes.BinaryGene;
import ga.mutators.SingleBitBinaryMutator;


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
