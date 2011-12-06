package ga;

import java.util.Random;

/**
 * This class defines the structure for the factories that give chromosomes to
 * fill the population
 * 
 * @author igor
 * 
 */
public abstract class ChromosomeFactory implements RandomComponent {
	private Random random;
	
	/**
	 * Generates a new random chromosome
	 * @return
	 */
	public abstract BasicChromosome getRandomChromosome();
	/**
	 * Holds any logic to be done before the GA's execution.
	 * It should be noted that when this is called there's a Random instance setted while this is not true in the constructor
	 */
	public void initialize() { }

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
}
