package ga.genes;

import java.math.BigInteger;

/**
 * Holds binary integer of arbitrary length
 * @author igor
 *
 */
public class IntegerBinaryGene extends BinaryGene<BigInteger> {

	public IntegerBinaryGene(BigInteger value) {
		super(value);
	}

	/**
	 * creates a random bit sequence with specified length
	 * @param length bit sequence length
	 */
	public IntegerBinaryGene(int length) {
		this(null); // TODO: needs a random object to make a new BigInteger instance
	}
	
	@Override
	public String toString() {
		return getValue().toString(2);
	}
}
