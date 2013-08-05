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

import java.util.ArrayList;
import java.util.List;

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;
import splice.ga.Crossover;
import splice.ga.Mutator;
import splice.ga.crossovers.SinglePointBinaryCrossover;
import splice.ga.crossovers.SinglePointCrossover;
import splice.ga.genes.IntegerListGene;
import splice.ga.genes.ListGene;
import splice.ga.mutators.GaussianMutator;
import splice.ga.mutators.RandomIntegerMutator;


@SuppressWarnings("rawtypes")
public class ZerosChromosomeFactory extends ChromosomeFactory {
	private int size;
	private int maxValue;
	
	public ZerosChromosomeFactory(int size, int maxValue) {
		this.size = size;
		this.maxValue = maxValue;
	}

    public void initialize() {
        setMutator(new RandomIntegerMutator(maxValue));
        setCrossover(new SinglePointCrossover<Integer>());
        setGene(new IntegerListGene(size, maxValue));
    }
	

	@Override
	public BasicChromosome getRandomChromosome() {
		return new ZerosChromosome();
	}

}
