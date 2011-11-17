package ga;

/**
 * Defines how to mutate a Gene
 * @author igor
 *
 * @param <T> the Gene type that can be mutated
 */
public interface Mutator<T extends Gene> {
	public void mutate(T gene);
}
