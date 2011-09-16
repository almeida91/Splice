package ga;

import java.util.ArrayList;
import java.util.Collections;

public class Population {
	private ArrayList<Genome> genomes;
	private double fitnessSum;
	private double fitnessAverage;
	private int size;
	private GenomeFactory factory;

	public Population(int size, GenomeFactory factory) {
		this.size = size;
		this.factory = factory;
	}

	public void calculateFitnessSum() {
		fitnessSum = 1E0;
		for (int i = 0; i < genomes.size(); i++) {
			fitnessSum += genomes.get(i).calculateFitness();
		}
		fitnessAverage = fitnessSum / genomes.size();
	}

	public void initializePopulation() {
		genomes = new ArrayList<Genome>(size);

		for (int i = 0; i < size; i++) {
			genomes.add(factory.getRandomGenome());
		}
	}

	public void sort() {
		Collections.sort(genomes, factory.getRandomGenome().getComparator());
	}

	public ArrayList<Genome> getGenomes() {
		return genomes;
	}

	public double getFitnessSum() {
		return fitnessSum;
	}

	public double getFitnessAverage() {
		calculateFitnessSum();
		return fitnessAverage;
	}

	public int getSize() {
		return genomes.size();
	}

	public Genome get(int i) {
		return genomes.get(i);
	}
	
	public Genome getRandom() {
		return this.get(RandomUtil.getRandom().nextInt(getSize()));
	}
}
