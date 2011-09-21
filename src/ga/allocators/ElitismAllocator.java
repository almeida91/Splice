package ga.allocators;

import ga.Chromosome;
import ga.PopulationAllocator;

import java.util.ArrayList;

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
		this.rate = rate;
	}

	@Override
	public void allocate(ArrayList<Chromosome> newPopulation) {
		getPopulation().sort();
		int n = (int)(getPopulation().getSize() * rate);
		for (int i = 1; i < n; i++) {
			newPopulation.add(getPopulation().get(getPopulation().getSize() - i));
		}
		setPopulation(newPopulation);
	}

	public double getRate() {
		return rate;
	}


}
