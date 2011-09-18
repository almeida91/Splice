package ga.allocators;

import ga.Chromossome;
import ga.PopulationAllocator;

import java.util.ArrayList;

public class ReplaceAllocator extends PopulationAllocator {
	@Override
	public void alocate(ArrayList<Chromossome> newPopulation) {
		this.setPopulation(newPopulation);
	}
}
