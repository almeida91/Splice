package ga;

import java.util.Random;

/**
 * Selects chromossome's candidates for crossover
 * 
 * @author igor
 * 
 */
public abstract class Selector extends PopulationManipulator implements RandomComponent {
	private Random random;
	
	/**
	 * The selection logic
	 * @return a chromosome for crossover
	 */
	public abstract Chromosome getChromosome();

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
}
