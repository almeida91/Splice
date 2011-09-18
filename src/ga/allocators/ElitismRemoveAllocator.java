package ga.allocators;

import ga.Chromossome;

import java.util.ArrayList;

public class ElitismRemoveAllocator extends ElitismAllocator {
	private double mFitness;
	
	public ElitismRemoveAllocator(double rate, double minimumFitness) {
		super(rate);
		mFitness = minimumFitness;
	}
	

	@Override
	public void alocate(ArrayList<Chromossome> newPopulation) {
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
