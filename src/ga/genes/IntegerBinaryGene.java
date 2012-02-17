package ga.genes;

import java.math.BigInteger;

/**
 * Holds binary integer of arbitrary length
 * @author igor
 *
 */
public class IntegerBinaryGene extends BinaryGene {
	public IntegerBinaryGene(BigInteger value) {
		super(value);
	}

	/**
	 * creates a random bit sequence with specified length
	 * @param length bit sequence length
	 */
	public IntegerBinaryGene(int length) {
		this(null);
		setLength(length);
	}
	
	@Override
	public String toString() {
		return getValue().toString(2);
	}
}
