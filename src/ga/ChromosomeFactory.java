package ga;

import java.util.Random;

/**
 * This class defines the structure for the factories that give chromosomes to
 * fill the population
 * 
 * @author igor
 * 
 */
public abstract class ChromosomeFactory implements RandomComponent, InitializeComponent {
	private Random random;
	
	/**
	 * Generates a new random chromosome
	 * @return
	 */
	public abstract BasicChromosome getRandomChromosome();

	public void initialize() { }

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
}
