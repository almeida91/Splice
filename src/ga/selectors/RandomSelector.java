package ga.selectors;

import ga.Chromossome;
import ga.Selector;

public class RandomSelector extends Selector {
	@Override
	public Chromossome getChromossome() {
		return getPopulation().getRandom();
	}
}
