package ga;

import java.util.ArrayList;

/**
 * Allocates a new population set to the current population
 * 
 * @author igor
 * 
 */
public abstract class PopulationAllocator extends PopulationManipulator {
	/**
	 * Defines the logic of how to allocate the new set
	 * 
	 * @param newPopulation new chromosome's set
	 */
	public abstract void allocate(ArrayList<Chromosome> newPopulation);
}
