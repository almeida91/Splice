/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.crossovers;

import java.math.BigInteger;

import splice.ga.Crossover;
import splice.ga.Gene;
import splice.ga.genes.BinaryGene;



public class MultiPointBinaryCrossover implements Crossover<BinaryGene> {
	private int points;
	private int length = 0;
	private BigInteger aMask, bMask;
	
	public MultiPointBinaryCrossover(int points) {
		this.points = points + 1;
	}
	
	private void generateMasks() {
		// FIXME: this was a quick fix, maybe a better method? It raises a bug on some occasions
		StringBuilder ones = new StringBuilder(length);
		String one = "1";
		for (int i = 0; i < length; i++) {
			ones.append(one);
		}
		
		if (length == 0) {
			aMask = BigInteger.ZERO;
			bMask = new BigInteger("2");
			return;
		}

		aMask = new BigInteger(ones.toString(), 2);
		
		
		byte[] m = aMask.toByteArray();

		boolean zero = true;

		for (int i = 0, j = 0; i < m.length; i++, j = (j + 1)
				% (m.length / points + 1)) {
			if (j == 0)
				zero = !zero;

			if (zero) {
				m[i] = 0;
			}
		}
		aMask = new BigInteger(m);
		bMask = aMask.negate();
	}
	
	@Override
	public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
		if (a.getLength() != length) {
			length = a.getLength();
			generateMasks();
		}
		
		BigInteger value = a.getValue().and(aMask).xor(b.getValue().and(bMask));
		
		return new BinaryGene(value);
	}

}
