package ga;

/**
 * Defines how to do the crossover of two Genes
 * @author igor
 *
 * @param <T> the Gene type that the crossover can be applied
 */
@SuppressWarnings("rawtypes")
public interface Crossover<T extends Gene> {
	public T doCrossover(T a, T b);
}
