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
import ga.genes.ListGene;

public class PermutateMutator<T> implements Mutator<ListGene<T>> {
	private Random random;
	
	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}

	@Override
	public void mutate(ListGene<T> gene) {
		T temp;
		int i,j;
		
		i = random.nextInt(gene.getValue().size());
		j = random.nextInt(gene.getValue().size());
		
		temp = gene.get(i);
		gene.set(i, gene.get(j));
		gene.set(j, temp);
	}

}
