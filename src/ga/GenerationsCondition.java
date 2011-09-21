package ga;

public class GenerationsCondition extends StopCondition {
	private int generations;

	public GenerationsCondition(int generations) {
		this.generations = generations;
	}

	@Override
	public boolean stop(GenerationData data) {
		return data.getGeneration() >= generations;
	}
}
