package ga.selectors;

import ga.Chromossome;
import ga.Selector;

public class TournamentSelector extends Selector {
	public int k;

	public TournamentSelector(int size) {
		k = size;
	}

	@Override
	public Chromossome getChromossome() {
		Chromossome chromossome = getPopulation().getRandom(), temp;
		double fitness = chromossome.getFitness();

		for (int i = 0; i < k; i++) {
			temp = getPopulation().getRandom();
			if (temp.getFitness() > fitness)
				chromossome = temp;
		}

		return chromossome;
	}
}
