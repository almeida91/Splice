/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package zeros;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.IntegerListGene;
import splice.ga.genes.ListGene;

public class ZerosChromosome extends SingleGeneChromosome<IntegerListGene> {
	@Override
	protected double fitness() {
		double f = 0;
		
		for (int i = 0; i < this.getGene().getSize(); i++) {
			if (this.getGene().get(i) == 0) {
				f++;
			}
		}
		
		return f;
	}
}
