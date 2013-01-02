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


@SuppressWarnings("rawtypes")
public class GaussianMutator implements Mutator<ListGene> { 
	private double x,y;
	
	public GaussianMutator(double max) {
		this(0, max);
	}
	
	public GaussianMutator(double min, double max) {
		this.x = min;
		this.y = max;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void mutate(ListGene gene) {
		gene.set(RandomUtil.getRandom().nextInt(gene.getSize()), ((RandomUtil.getRandom().nextGaussian() * (y - x)) + x));
	}

}
