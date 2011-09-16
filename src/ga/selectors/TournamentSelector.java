package ga.selectors;

import ga.Genome;
import ga.Selector;

public class TournamentSelector extends Selector {
	public int k;

	public TournamentSelector(int size) {
		k = size;
	}

	@Override
	public Genome getGenome() {
		Genome genome = getPopulation().getRandom(), temp;
		double fitness = genome.getFitness();

		for (int i = 0; i < k; i++) {
			temp = getPopulation().getRandom();
			if (temp.getFitness() > fitness)
				genome = temp;
		}

		return genome;
	}
}
