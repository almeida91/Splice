/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
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
		// TODO: there's no value
	}
	
	@Override
	public String toString() {
		return getValue().toString(2);
	}
}
