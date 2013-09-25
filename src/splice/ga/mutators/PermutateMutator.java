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
import splice.ga.Mutator;
import splice.ga.genes.ListGene;


public class PermutateMutator<T> implements Mutator<ListGene<T>> {
	@Override
	public void mutate(ListGene<T> gene) {
		T temp;
		int i,j;
		
		i = RandomUtil.getRandom().nextInt(gene.getSize());
		j = RandomUtil.getRandom().nextInt(gene.getSize());
		
		temp = gene.get(i);
		gene.set(i, gene.get(j));
		gene.set(j, temp);
	}

}
