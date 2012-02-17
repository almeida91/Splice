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
