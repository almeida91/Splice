/*
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

	public BinaryGene(BigInteger value) {
		super(value);
	    length = value.bitLength();
	}

	public BinaryGene(int value) {
		this(new BigInteger(getBytes(value)));
		length = 32;
	}

	public BinaryGene(long value) {
		this(new BigInteger(getBytes(value)));
		length = 64;
	}

	public BinaryGene(double value) {
		this(new BigInteger(getBytes(Double.doubleToLongBits(value))));
		length = 64;
	}

	public BinaryGene(float value) {
		this(new BigInteger(getBytes(Float.floatToIntBits(value))));
		length = 32;
	}

    public BinaryGene(BinaryGeneType type) {
        this(BigInteger.ZERO);
        if (type == BinaryGeneType.DOUBLE || type == BinaryGeneType.LONG) {
            length = 64;
        }
        else if (type == BinaryGeneType.FLOAT || type == BinaryGeneType.INTEGER) {
            length = 32;
        }
        else if (type == BinaryGeneType.SHORT) {
            length = 16;
        }
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
		return Float.intBitsToFloat(getValue().intValue());
	}

	/**
	 * Converts the bit-string value to the "double format" of IEEE 754 floating
	 * point bit layout as defined in the JDK
	 * 
	 * @return double value represented by the bit-string
	 */
	public double toDouble() {
		return Double.longBitsToDouble(getValue().longValue());
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
