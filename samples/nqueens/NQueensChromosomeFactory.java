/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package nqueens;

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;
import splice.ga.crossovers.SinglePointCrossover;
import splice.ga.genes.IntegerListGene;
import splice.ga.mutators.RandomIntegerMutator;

public class NQueensChromosomeFactory extends ChromosomeFactory {
	private int n;

	public NQueensChromosomeFactory(int n) {
		this.n = n;
	}

    @Override
    public void initialize() {
        setMutator(new RandomIntegerMutator(8));
        setCrossover(new SinglePointCrossover<Integer>());
        setSize(2);
        setGene(new IntegerListGene(8, 8));
    }

	@Override
	public BasicChromosome getRandomChromosome() {
		return new NQueensChromosome();
	}

}
