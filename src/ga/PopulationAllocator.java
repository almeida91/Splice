package ga;

import java.util.ArrayList;

/**
 * Allocates a new population set to the current population
 * 
 * @author igor
 * 
 */
public abstract class PopulationAllocator extends PopulationManipulator {
	private ArrayList<Chromosome> newPopulation;
	
	/**
	 * Defines the logic of how to allocate the new set
	 * 
	 * @param newPopulation new chromosome's set
	 */
	public abstract void allocate();
	
	/**
	 * Appends a chromosome to the new population
	 * @param chromosome
	 */
	public void append(Chromosome chromosome) {
		chromosome.setRandom(getRandom());
		newPopulation.add(chromosome);
	}

	/**
	 * Returns the bufferized new population
	 * @return
	 */
	public ArrayList<Chromosome> getNewPopulation() {
		return newPopulation;
	}
	
	/**
	 * Resets the buffer, you don't want the population to grow till your memory overflows
	 */
	public void reset() {
		newPopulation = new ArrayList<Chromosome>(getPopulation().getSize());
	}
}
