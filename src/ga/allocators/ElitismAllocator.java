package ga.allocators;

import ga.PopulationAllocator;

/**
 * Allocates the new set base on the elistism concept
 * @author igor
 *
 */
public class ElitismAllocator extends PopulationAllocator {
	private double rate;
	
	/**
	 * 
	 * @param rate the percentage of the old population to be kept
	 */
	public ElitismAllocator(double rate) {
		super();
		this.rate = rate;
	}

	@Override
	public void allocate() {
		getPopulation().sort();
		int n = (int)(getPopulation().getSize() * rate);
		for (int i = 1; i < n; i++) {
			getNewPopulation().add(getPopulation().get(getPopulation().getSize() - i));
		}
		setPopulation(getNewPopulation());
	}

	public double getRate() {
		return rate;
	}


}
