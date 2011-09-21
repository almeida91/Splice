package ga;

/**
 * Base class to define how the genetic algorithm should stop
 * @author igor
 *
 */
public abstract class StopCondition {
	public abstract boolean stop(GenerationData data);
}
