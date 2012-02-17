package ga;

/**
 * defines how the genetic algorithm should stop
 * @author igor
 *
 */
public interface StopCondition {
	public boolean stop(GenerationData data);
}
