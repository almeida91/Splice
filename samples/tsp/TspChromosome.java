/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package tsp;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.ListGene;

public class TspChromosome extends SingleGeneChromosome<ListGene<Integer>> {

	@Override
	protected double fitness() {
		return 0;
	}

	@Override
	protected SingleGeneChromosome<ListGene<Integer>> getNew() {
		// TODO Auto-generated method stub
		return null;
	}

}
