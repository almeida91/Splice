package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

public class MinimumAverageFitnessCondition extends StopCondition {
	private double minimum;

	public MinimumAverageFitnessCondition(double minimum) {
		this.minimum = minimum;
	}

	@Override
	public boolean stop(GenerationData data) {
		return data.getFitnessAverage() >= minimum;
	}

}
