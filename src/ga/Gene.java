package ga;

import java.util.Random;

/**
 * Base class for a single chromosome information
 * @author igor
 *
 * @param <T> the type of information value
 */
public abstract class Gene<T> implements RandomComponent {
	private T value;
	private Random random;
	
	public Gene(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
}
