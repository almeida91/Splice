package ga;

public interface Mutator<T extends Gene> {
	public void mutate(T gene);
}
