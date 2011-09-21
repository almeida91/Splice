package ga.allocators;

import ga.Chromosome;
import ga.PopulationAllocator;

import java.util.ArrayList;

/**
 * Allocate the new population simply replacing the old one
 * @author igor
 *
 */
public class ReplaceAllocator extends PopulationAllocator {
	@Override
	public void allocate(ArrayList<Chromosome> newPopulation) {
		this.setPopulation(newPopulation);
	}
}
