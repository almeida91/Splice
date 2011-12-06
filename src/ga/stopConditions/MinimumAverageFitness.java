package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

public class MinimumAverageFitness extends StopCondition {
	private double minimum;

	public MinimumAverageFitness(double minimum) {
		this.minimum = minimum;
	}

	@Override
	public boolean stop(GenerationData data) {
		return data.getFitnessAverage() >= minimum;
	}

}
