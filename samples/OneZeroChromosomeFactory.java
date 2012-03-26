import java.math.BigInteger;
import java.util.Random;

import ga.BasicChromosome;
import ga.ChromosomeFactory;
import ga.SingleGeneChromosome;
import ga.genes.IntegerBinaryGene;


public class OneZeroChromosomeFactory extends ChromosomeFactory {
	private int bitSize;
	
	public OneZeroChromosomeFactory(int size) {
		bitSize = size;
	}
	
	
	@Override
	public BasicChromosome getRandomChromosome() {
		SingleGeneChromosome<IntegerBinaryGene> c = new OneZeroChromosome();
		c.setGene(new IntegerBinaryGene(new BigInteger(bitSize, getRandom())));
		
		return c;
	}

}
