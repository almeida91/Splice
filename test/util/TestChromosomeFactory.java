package util;

import ga.Chromosome;
import ga.ChromosomeFactory;

public class TestChromosomeFactory extends ChromosomeFactory {
	double value;
	
	public TestChromosomeFactory(double value) {
		this.value = value;
	}
	
	@Override
	public Chromosome getRandomChromosome() {
		return new TestChromosome(value);
	}

}
