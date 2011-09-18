package ga;

import java.util.ArrayList;
import java.util.Collections;

public class Population {
	private ArrayList<Chromossome> chromossomes;
	private double fitnessSum;
	private double fitnessAverage;
	private int size;
	private ChromossomeFactory factory;

	public Population(int size, ChromossomeFactory factory) {
		this.size = size;
		this.factory = factory;
	}

	public void calculateFitnessSum() {
		fitnessSum = 1E0;
		for (int i = 0; i < chromossomes.size(); i++) {
			fitnessSum += chromossomes.get(i).calculateFitness();
		}
		fitnessAverage = fitnessSum / chromossomes.size();
	}

	public void initializePopulation() {
		chromossomes = new ArrayList<Chromossome>(size);

		for (int i = 0; i < size; i++) {
			chromossomes.add(factory.getRandomChromossome());
		}
	}

	public void sort() {
		Collections.sort(chromossomes, factory.getRandomChromossome().getComparator());
	}

	public ArrayList<Chromossome> getChromossomes() {
		return chromossomes;
	}

	public double getFitnessSum() {
		return fitnessSum;
	}

	public double getFitnessAverage() {
		calculateFitnessSum();
		return fitnessAverage;
	}

	public int getSize() {
		return chromossomes.size();
	}

	public Chromossome get(int i) {
		return chromossomes.get(i);
	}
	
	public Chromossome getRandom() {
		return this.get(RandomUtil.getRandom().nextInt(getSize()));
	}
}
