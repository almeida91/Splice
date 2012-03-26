/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.mutators;

import java.util.Random;

import ga.Mutator;
import ga.Gene;
import ga.genes.ListGene;

public class GaussianMutator implements Mutator<ListGene> { 
	private Random random;
	private double x,y;
	
	public GaussianMutator(double max) {
		this(0,max);
	}
	
	public GaussianMutator(double min, double max) {
		this.x = min;
		this.y = max;
	}

	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}

	@Override
	public void mutate(ListGene gene) {
		gene.set(random.nextInt(gene.getSize()), ((random.nextGaussian() * (y - x)) + x));
	}

}
