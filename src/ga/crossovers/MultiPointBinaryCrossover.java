/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.crossovers;

import java.math.BigInteger;

import ga.Crossover;
import ga.Gene;
import ga.genes.BinaryGene;


public class MultiPointBinaryCrossover implements Crossover<BinaryGene> {
	private int points;
	private int length = 0;
	private BigInteger aMask, bMask;
	
	public MultiPointBinaryCrossover(int points) {
		this.points = points;
	}
	
	private void generateMasks() {
		int step = length / (points + 1);
		
		for (int i = 0, j = 0; i < length; i++, j = (j + 1) % step) {
			// TODO: where's the implementation?
		}
	}
	
	@Override
	public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
		if (a.getLength() != length) {
			length = a.getLength();
			generateMasks();
		}
		
		BigInteger value = a.getValue().and(aMask).xor(b.getValue().and(bMask));
		
		BinaryGene c = null;
		
		return c;
	}

}
