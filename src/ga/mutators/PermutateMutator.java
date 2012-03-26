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

public class PermutateMutator<T> implements Mutator<ListGene> {
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
	public void mutate(ListGene gene) {
		ListGene<Object> g = (ListGene<Object>)gene;
		Object temp;
		int i,j;
		
		i = random.nextInt(g.getValue().size());
		j = random.nextInt(g.getValue().size());
		
		temp = g.get(i);
		g.set(i, g.get(j));
		g.set(j, temp);
	}

}
