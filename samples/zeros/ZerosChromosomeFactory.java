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
import splice.ga.genes.ListGene;
import splice.ga.mutators.GaussianMutator;


@SuppressWarnings("rawtypes")
public class ZerosChromosomeFactory extends ChromosomeFactory {
	private int size;
	private int maxValue;
	
	public ZerosChromosomeFactory(int size, int maxValue) {
		this.size = size;
		this.maxValue = maxValue;
	}
	

	@SuppressWarnings({ "unchecked" })
	@Override
	public BasicChromosome getRandomChromosome() {
		ZerosChromosome c = new ZerosChromosome();
		List<Integer> numbers = new ArrayList<Integer>();
		
		Mutator mutator = new GaussianMutator(100);
		Crossover crossover = null;
		
		for (int i = 0; i < size; i++) {
			numbers.add(getRandom().nextInt(maxValue));
		}
		
		c.setGene(new ListGene<Integer>(numbers));
		c.setMutator(mutator);
		c.setCrossover(crossover);
		
		return c;
	}

}
