package ga.genes;

import java.util.List;

import ga.Gene;

public class ListGene<T> extends Gene<List<T>> {
	public ListGene(List<T> value) {
		super(value);
	}
	
	public T get(int i) {
		return getValue().get(i);
	}
	
	public void set(int i, T value) {
		getValue().set(i, value);
	}
	
	public int getSize() {
		return getValue().size();
	}
	
}
