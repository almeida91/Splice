package ga;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The chromosome's collection
 * @author igor
 *
 */
public class Population {
	/**
	 * this contains all the chromosomes
	 */
	private ArrayList<Chromosome> chromosomes;
	/**
	 * the sum of all fitnesses it's used in roullette selection and in the average calculation
	 */
	private double fitnessSum;
	/**
	 * population's average fitness
	 */
	private double fitnessAverage;
	/**
	 * population's size
	 */
	private int size;
	private ChromosomeFactory factory;

	/**
	 * Defaul constructor
	 * @param size the size to initialize the population
	 * @param factory the factory to fill the initial population
	 */
	public Population(int size, ChromosomeFactory factory) {
		this.size = size;
		this.factory = factory;
	}

	/**
	 * Calculates the chromosome's fitness as well their averages
	 */
	public void calculateFitnessSum() {
		fitnessSum = 0;
		for (int i = 0; i < chromosomes.size(); i++) {
			fitnessSum += chromosomes.get(i).calculateFitness();
		}
		fitnessAverage = fitnessSum / chromosomes.size();
	}

	/**
	 * 
	 */
	public void initializePopulation() {
		chromosomes = new ArrayList<Chromosome>(size);

		for (int i = 0; i < size; i++) {
			chromosomes.add(factory.getRandomChromosome());
		}
	}
	
	/**
	 * Sorts the population based on the chromosome's comparator
	 */
	public void sort() {
		Collections.sort(chromosomes, factory.getRandomChromosome().getComparator());
	}

	/**
	 * @return the chromosome's collection
	 */
	public ArrayList<Chromosome> getChromosomes() {
		return chromosomes;
	}

	public double getFitnessSum() {
		return fitnessSum;
	}

	public double getFitnessAverage() {
		return fitnessAverage;
	}

	public int getSize() {
		return chromosomes.size();
	}

	public Chromosome get(int i) {
		return chromosomes.get(i);
	}
	
	public Chromosome getRandom() {
		return this.get(RandomUtil.getRandom().nextInt(getSize()));
	}
}
