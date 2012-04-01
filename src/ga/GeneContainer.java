package ga;

public interface GeneContainer<T extends Gene> {

	public abstract void setCrossover(Crossover<T> crossover);

	public abstract void setMutator(Mutator<T> mutator);

}