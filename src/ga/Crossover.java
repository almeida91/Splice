package ga;

public interface Crossover<T extends Gene> {
	public T doCrossover(T a, T b);
}
