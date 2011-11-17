package ga;

/**
 * Base class for a single chromosome information
 * @author igor
 *
 * @param <T> the type of information value
 */
public abstract class Gene<T> {
	private T value;
	
	public Gene(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
