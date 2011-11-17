package ga.genes;

import java.math.BigInteger;

import ga.Gene;

public abstract class BinaryGene<T> extends Gene<T> {
	public BinaryGene(T value) {
		super(value);
	}
	
	public boolean isBigInteger() {
		return getValue() instanceof BigInteger;
	}
}
