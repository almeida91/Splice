package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

public class MinimumBestFitnessCondition extends StopCondition {
	private double minimum;

	public MinimumBestFitnessCondition(double minimum) {
		this.minimum = minimum;
	}
	
	@Override
	public boolean stop(GenerationData data) {
		return data.getBestChromosome().getFitness() >= minimum;
	}

}
