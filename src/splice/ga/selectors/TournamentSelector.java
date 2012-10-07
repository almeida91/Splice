/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.selectors;

import splice.ga.BasicChromosome;
import splice.ga.Selector;


/**
 * Selects a chromosome using a k-sized deterministic tournament
 * @author igor
 *
 */
public class TournamentSelector extends Selector {
	private int k;
	/**
	 * @param size the tournament size
	 */
	public TournamentSelector(int size) {
		k = size;
	}

	@Override
	public BasicChromosome getChromosome() {
		BasicChromosome chromosome = getPopulation().getRandomChromosome(), temp;
		double fitness = chromosome.getFitness();

		for (int i = 0; i < k; i++) {
			temp = getPopulation().getRandomChromosome();
			if (temp.getFitness() > fitness)
				chromosome = temp;
		}

		return chromosome;
	}
	
	@Override
	public void beforeGeneration() { }
	
	@Override
	public void initialize() {
		getProblemType().setMaximization();
	}
}
