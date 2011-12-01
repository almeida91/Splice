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
		getNewPopulation().addAll(getPopulation().getChromosomes().subList(getPopulation().getSize() - n, getPopulation().getSize()));
		setPopulation(getNewPopulation());
	}

	public double getRate() {
		return rate;
	}


}
