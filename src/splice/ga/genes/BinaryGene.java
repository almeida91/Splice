/*
 * Copyright (C) 2012 Igor de Almeida
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.genes;

import java.math.BigInteger;

import splice.RandomUtil;
import splice.ga.Gene;

/**
 * Base class for genes that stores their information in a binary way
 *
 * @author igor
 *
 */
public class BinaryGene extends Gene<BigInteger> {
	private int length = 0;
    private boolean negative;
	private float minFloat, maxFloat;
	private double minDouble, maxDouble;
	private boolean limits = false;

	private static byte[] getBytes(long x) {
		byte[] b = new byte[8];
		b[0] = (byte) (x >> 56);
		b[1] = (byte) (x >> 48);
		b[2] = (byte) (x >> 40);
		b[3] = (byte) (x >> 32);
		b[4] = (byte) (x >> 24);
		b[5] = (byte) (x >> 16);
		b[6] = (byte) (x >> 8);
		b[7] = (byte) (x);
		return b;
	}

	private static byte[] getBytes(int x) {
		byte[] b = new byte[4];
		b[0] = (byte) (x >> 24);
		b[1] = (byte) (x >> 16);
		b[2] = (byte) (x >> 8);
		b[3] = (byte) (x);
		return b;
	}

	public BinaryGene(BigInteger value, boolean negative) {
		super(value);
	    length = value.bitLength();
        this.negative = negative;
	}

    public BinaryGene(BigInteger value) {
        this(value, true);
    }

	public BinaryGene(int length) {
		this(BigInteger.ZERO);
		this.length = length;
	}

    public BinaryGene(BinaryGeneType type) {
        this(BigInteger.ZERO);

		switch (type) {
			case FLOAT:
			case INTEGER:
				length = 32;
				break;
            case DOUBLE:
			case LONG:
				length = 64;
				break;
			case SHORT:
				length = 16;
				break;
		}
    }

	/**
	 * This constructor allows to set the lower and upper bounds for a gene.
	 * This way when you have a range-restricted variable the gene won't return
	 * an invalid value when calling toFloat() method.
	 * @param min the lower bound
	 * @param max the upper bound
	 */
	public BinaryGene(float min, float max) {
		this(BinaryGeneType.FLOAT);

		minFloat = min;
		maxFloat = max;

		limits = true;
		negative = false;
	}

	public BinaryGene(double min, double max) {
		this(BinaryGeneType.FLOAT);

		maxDouble = min;
		minDouble = max;

		limits = true;
		negative = false;
	}

	@Override
	public void initialize() {
		if (length == 0) {
			throw new RuntimeException("BinaryGene must have length set");
        }

        if (getValue().longValue() == 0) {
            setValue(new BigInteger(length, RandomUtil.getRandom()));
        }
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return this.getValue().toString(2);
	}

	/**
	 * Converts the internal value using the built-in JDK's IEEE 754 bit layout
	 *
	 * @return the gene's float value
	 */
	public float toFloat() {
		int intValue = getValue().intValue();

		// if the bit-value will raise an NaN, so we decrease one bit from the exponent
		if ((intValue & 0x7f000000) == 0x7f000000)
			intValue &= 0xfeffffff;

        // here we negate the sign bit
        if (!negative)
            intValue &= 0x7fffffff;

		if (limits) {
			float floatValue = Float.intBitsToFloat(intValue);
			return minFloat + floatValue % (maxFloat - minFloat);
		}

		return Float.intBitsToFloat(intValue);
	}

	/**
	 * Converts the bit-string value to the "double format" of IEEE 754 floating
	 * point bit layout as defined in the JDK
	 *
	 * @return double value represented by the bit-string
	 */
	public double toDouble() {
		long longValue = getValue().longValue();

		// same as the toFloat() method, but with doubles
		if ((longValue & 0x7ff0000000000000L) == 0x7ff0000000000000L)
			longValue &= 0xffefffffffffffffL;

        if (!negative)
            longValue &= 0x7fffffffffffffffL;

		if (limits) {
			double doubleValue = Double.longBitsToDouble(longValue);
			return minDouble + doubleValue % (maxDouble - minDouble);
		}

		return Double.longBitsToDouble(longValue);
	}

	/**
	 * @return conversion to integer value
	 */
	public int toInt() {
		return getValue().intValue();
	}

	/**
	 * @return bit-string value converted to long
	 */
	public long toLong() {
		return getValue().longValue();
	}

	/**
	 * @return the raw byte array bit-string representation
	 */
	public byte[] toByteArray() {
		return getValue().toByteArray();
	}
}
