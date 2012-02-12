package ga.allocators;

import ga.PopulationAllocator;

/**
 * Allocates the new chromosome population using the steady state logic
 * @author igor
 *
 */
public class SteadyStateAllocator extends PopulationAllocator {
	public double rate;
	
	public SteadyStateAllocator(double rate) {
		this.rate = rate;
	}

	@Override
	public void allocate() {
		getPopulation().sort();
		sortNewPopulation();
		
		int n = (int)(getPopulation().getSize() * rate);
		
		for (int i = 0; i < n; i++) {
			getPopulation().getChromosomes().set(i, getNewPopulation().get((getNewPopulation().size() - 1) - i));
		}
	}

}
