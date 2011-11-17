package ga.genes;

import java.math.BigInteger;

public class IntegerBinaryGene extends BinaryGene<BigInteger> {

	public IntegerBinaryGene(BigInteger value) {
		super(value);
	}

	/**
	 * creates a random bit sequence with specified lenght
	 * @param lenght bit sequence lenght
	 */
	public IntegerBinaryGene(int lenght) {
		this(null); // TODO: needs a random object to make a new BigInteger instance
	}
}
