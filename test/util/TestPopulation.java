package util;

import splice.ga.Population;

public class TestPopulation extends Population {
	double average;
	
	public TestPopulation(double average) {
		this.average = average;
	}
	
	@Override
	public double getFitnessAverage() {
		return average;
	}
}
