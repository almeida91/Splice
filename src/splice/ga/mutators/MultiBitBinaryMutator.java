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

import splice.RandomUtil;
import splice.ga.Mutator;
import splice.ga.genes.BinaryGene;


public class MultiBitBinaryMutator implements Mutator<BinaryGene> {
	private int nBits;

	public MultiBitBinaryMutator(int numBits) {
		nBits = numBits;
	}
	
	@Override
	public void mutate(BinaryGene gene) {
		for (int i = 0; i < nBits; i++) {
			gene.setValue(gene.getValue().flipBit(RandomUtil.getRandom().nextInt(gene.getLength())));
		}
	}
}
