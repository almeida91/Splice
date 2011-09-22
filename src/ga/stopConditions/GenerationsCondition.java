package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

/**
 * Stops the execution when a number of generations is achieved
 * @author igor
 *
 */
public class GenerationsCondition extends StopCondition {
	private int generations;

	public GenerationsCondition(int generations) {
		this.generations = generations;
	}

	@Override
	public boolean stop(GenerationData data) {
		return data.getGeneration() >= generations;
	}

	public int getGenerations() {
		return generations;
	}
}
