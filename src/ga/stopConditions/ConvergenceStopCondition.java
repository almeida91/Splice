package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

/**
 * Stops the genetic algorithm when after n-generations no evolution is achieved
 * shouldn't used with non-elitist allocators as the values may change so it
 * will come to an infinite loop.
 * This condition considers evolution the increase in the population's best fitness
 * @author igor
 *
 */
public class ConvergenceStopCondition extends StopCondition {
	private int maxGenerations;
	private double minFitness = 0;
	
	private double bestFitness;
	private int generations = 0; 
	
	public ConvergenceStopCondition(int maxGenerations) {
		this.maxGenerations = maxGenerations;
	}
	
	/**
	 * like the default constructor, but it will not stop if the minimum fitness
	 * has not been achieved 
	 * @param maxGenerations
	 * @param minFitness
	 */
	public ConvergenceStopCondition(int maxGenerations, double minFitness) {
		this.maxGenerations = maxGenerations;
		this.minFitness = minFitness;
	}
	
	@Override
	public boolean stop(GenerationData data) {
		double fitness = data.getBestChromosome().getFitness();
		
		if (fitness == bestFitness)
			generations++;
		if (fitness > bestFitness) {
			bestFitness = fitness;
			generations = 0;
		}
		
		return generations >= maxGenerations & bestFitness >= minFitness;
	}

}
