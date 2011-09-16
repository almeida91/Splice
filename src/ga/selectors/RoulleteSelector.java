package ga.selectors;

import ga.Genome;
import ga.RandomUtil;
import ga.Selector;

public class RoulleteSelector extends Selector {
	@Override
	public Genome getGenome() {
		int i;
		double aux = 0;
		double limit = RandomUtil.getRandom().nextGaussian() * getPopulation().getFitnessSum();

		for (i = 0; i < getPopulation().getSize() & aux < limit; ++i) {
			aux += getPopulation().get(i).getFitness();
		}

		return getPopulation().get(i == 0 ? i : i - 1);
	}
}
