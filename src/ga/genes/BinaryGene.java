package ga.genes;

import java.math.BigInteger;

import ga.Gene;

/**
 * Base class for genes that stores their informations in a binary way
 * @author igor
 *
 * @param <T>
 */
public abstract class BinaryGene extends Gene<BigInteger> {
	private int length;
	
	public BinaryGene(BigInteger value) {
		super(value);
		if (value != null)
			length = value.bitLength();
	}
	
	public int getLength() {
		return length;
	}

	protected void setLength(int length) {
		this.length = length;
	}
}
