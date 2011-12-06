package util;

import ga.BasicChromosome;
import ga.ChromosomeFactory;

public class TestChromosomeFactory extends ChromosomeFactory {
	double value;
	
	public TestChromosomeFactory(double value) {
		this.value = value;
	}
	
	@Override
	public BasicChromosome getRandomChromosome() {
		return new TestChromosome(value);
	}

}
