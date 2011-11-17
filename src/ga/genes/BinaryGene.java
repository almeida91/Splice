package ga.genes;

import java.math.BigInteger;

import ga.Gene;

/**
 * Base class for genes that stores their informations in a binary way
 * @author igor
 *
 * @param <T>
 */
public abstract class BinaryGene<T extends Number> extends Gene<T> {
	public BinaryGene(T value) {
		super(value);
	}
	
	/**
	 * Currently this is a workarround so the same mutators/crossovers can be applied to different binary types, like integer, double or long 
	 * @return true if the value type is an instance of the BigInteger class
	 */
	public boolean isBigInteger() {
		return getValue() instanceof BigInteger;
	}
}
