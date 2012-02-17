package ga;

/**
 * Selects chromossome's candidates for crossover
 * 
 * @author igor
 * 
 */
public interface Selector extends PopulationManipulator, RandomComponent {
	/**
	 * The selection logic
	 * @return a chromosome for crossover
	 */
	public BasicChromosome getChromosome();
	public void beforeGeneration();
}
