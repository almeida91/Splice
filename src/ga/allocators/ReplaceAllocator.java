package ga.allocators;

import ga.Genome;
import ga.PopulationAllocator;

import java.util.ArrayList;

public class ReplaceAllocator extends PopulationAllocator {
	@Override
	public void alocate(ArrayList<Genome> newPopulation) {
		this.setPopulation(newPopulation);
	}
}
