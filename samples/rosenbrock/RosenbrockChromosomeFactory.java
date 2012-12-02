/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package rosenbrock;

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;
import splice.ga.crossovers.MultiPointBinaryCrossover;
import splice.ga.genes.BinaryGene;
import splice.ga.mutators.SingleBitBinaryMutator;

public class RosenbrockChromosomeFactory extends ChromosomeFactory<BinaryGene> {

	@Override
	public void initialize() {
		setMutator(new SingleBitBinaryMutator());
		setCrossover(new MultiPointBinaryCrossover(2));
	}

	@Override
	public BasicChromosome getRandomChromosome() {
		RosenbrockChromosome c = new RosenbrockChromosome();
		BinaryGene[] g = new BinaryGene[] {
				new BinaryGene(getRandom().nextInt(Integer.MAX_VALUE)),
				new BinaryGene(getRandom().nextInt(Integer.MAX_VALUE)) };
		c.setGenes(g);
		return c;
	}

}
