package ga;

/**
 * Defines how to mutate a Gene
 * @author igor
 *
 * @param <T> the Gene type that can be mutated
 */
@SuppressWarnings("rawtypes")
public interface Mutator<T extends Gene> extends RandomComponent {
	public void mutate(T gene);
}
