package ga;

/**
 * This class defines the structure for the factories that give chromosomes to
 * fill the population
 * 
 * @author igor
 * 
 */
public abstract class ChromosomeFactory {
	/**
	 * Generates a new random chromosome
	 * @return
	 */
	public abstract Chromosome getRandomChromosome();
}
