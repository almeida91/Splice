/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;
import splice.ga.SingleGeneChromosome;
import splice.ga.crossovers.SinglePointBinaryCrossover;
import splice.ga.genes.BinaryGene;
import splice.ga.mutators.SingleBitBinaryMutator;


public class OneZeroChromosomeFactory extends ChromosomeFactory<BinaryGene> {
	private int limit;
	
	public OneZeroChromosomeFactory(int limit) {
		this.limit = limit;
	}
	
	@Override
	public void initialize() {
		setMutator(new SingleBitBinaryMutator());
		setCrossover(new SinglePointBinaryCrossover());
	}
	
	@Override
	public BasicChromosome getRandomChromosome() {
		SingleGeneChromosome<BinaryGene> c = new OneZeroChromosome();
		c.setGene(new BinaryGene(getRandom().nextInt(limit)));
		return c;
	}
}
