package ga.allocators;

import ga.PopulationAllocator;


/**
 * Allocate the new population simply replacing the old one
 * @author igor
 *
 */
public class ReplaceAllocator extends PopulationAllocator {
	@Override
	public void allocate() {
		this.setPopulation(getNewPopulation());
	}
}
