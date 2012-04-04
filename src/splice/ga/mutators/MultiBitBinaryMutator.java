/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.mutators;

import java.util.Random;

import splice.ga.Gene;
import splice.ga.Mutator;
import splice.ga.genes.BinaryGene;


public class MultiBitBinaryMutator implements Mutator<BinaryGene> {
	private int nBits;
	private Random random;
	
	public MultiBitBinaryMutator(int numBits) {
		nBits = numBits;
	}
	
	@Override
	public void mutate(BinaryGene gene) {
		for (int i = 0; i < nBits; i++) {
			gene.setValue(gene.getValue().flipBit(getRandom().nextInt(gene.getLength())));
		}
	}

	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}
}
