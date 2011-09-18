package ga;

import java.util.ArrayList;

public abstract class PopulationAllocator extends PopulationManipulator {
	public abstract void alocate(ArrayList<Chromossome> newPopulation); 
}
