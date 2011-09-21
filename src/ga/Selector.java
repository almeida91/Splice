package ga;

/**
 * Selects chromossome's candidates for crossover
 * 
 * @author igor
 * 
 */
public abstract class Selector extends PopulationManipulator {
	/**
	 * The selection logic
	 * @return a chromosome for crossover
	 */
	public abstract Chromosome getChromosome();
}
