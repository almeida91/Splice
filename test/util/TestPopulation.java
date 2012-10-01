package util;

import splice.ga.Population;

public class TestPopulation extends Population {
	double average;
	
	public TestPopulation(double average, int size) {
		this.average = average;
		setSize(size);
	}
	
	public TestPopulation(double average) {
		this(average, 0);
	}
	
	@Override
	public void initialize() {
		if (getFactory() == null)
			setFactory(new TestChromosomeFactory(average));
		
		super.initialize();
	}
}
