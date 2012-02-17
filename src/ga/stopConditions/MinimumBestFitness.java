package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

public class MinimumBestFitness implements StopCondition {
	private double minimum;

	public MinimumBestFitness(double minimum) {
		this.minimum = minimum;
	}
	
	@Override
	public boolean stop(GenerationData data) {
		return data.getBestChromosome().getFitness() >= minimum;
	}

}
