package ga.allocators;

import ga.Chromossome;
import ga.PopulationAllocator;

import java.util.ArrayList;

public class ElitismAllocator extends PopulationAllocator {
	private double rate;
	
	public ElitismAllocator(double rate) {
		this.rate = rate;
	}

	@Override
	public void alocate(ArrayList<Chromossome> newPopulation) {
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
