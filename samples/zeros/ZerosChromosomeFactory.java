package zeros;

import java.util.ArrayList;
import java.util.List;

import ga.BasicChromosome;
import ga.ChromosomeFactory;
import ga.genes.ListGene;
import ga.mutators.GaussianMutator;

public class ZerosChromosomeFactory extends ChromosomeFactory {
	private int size;
	private int maxValue;
	
	public ZerosChromosomeFactory(int size, int maxValue) {
		this.size = size;
		this.maxValue = maxValue;
	}
	

	@Override
	public BasicChromosome getRandomChromosome() {
		ZerosChromosome c = new ZerosChromosome();
		List<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 0; i < size; i++) {
			numbers.add(getRandom().nextInt(maxValue));
		}
		
		c.setGene(new ListGene<Integer>(numbers));
		
		return c;
	}

}
