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
import splice.ga.genes.BinaryGene;

public class SingleBitBinaryMutator extends MultiBitBinaryMutator {
	public SingleBitBinaryMutator() {
		super(1);
	}
	
	@Override
	public void mutate(BinaryGene g) {
		int i = g.getLength() > 0 ? g.getLength() : 1;
		g.setValue(g.getValue().flipBit(RandomUtil.getRandom().nextInt(i)));
	}
}
