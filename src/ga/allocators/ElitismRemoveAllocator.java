package ga.allocators;

import ga.Chromosome;

import java.util.ArrayList;

/**
 * The same logic of the elitism but removing the old ones that don't have the minimum fitness
 * @author igor
 *
 */
public class ElitismRemoveAllocator extends ElitismAllocator {
	private double mFitness;
	
	public ElitismRemoveAllocator(double rate, double minimumFitness) {
		super(rate);
		mFitness = minimumFitness;
	}
	

	@Override
	public void allocate(ArrayList<Chromosome> newPopulation) {
		getPopulation().sort();
		int n = (int) (getPopulation().getSize() * getRate());
		for (int i = 1; i < n; i++) {
			newPopulation.add(getPopulation().get(getPopulation().getSize() - i));
		}
		for (int i = 0, j = 0; i < newPopulation.size() & j < n; i++) {
			if (newPopulation.get(i).getFitness() < mFitness) {
				newPopulation.remove(i);
				j++;
			}
		}
		setPopulation(newPopulation);
	}

}
