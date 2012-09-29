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
 * Selects a chromosome based on the roullete selection
 * @author igor
 *
 */
public class RouletteSelector extends Selector {
	@Override
	public BasicChromosome getChromosome() {
		int i;
		double aux = 0;
		double limit = getRandom().nextGaussian() * getPopulation().getFitnessSum();

		for (i = 0; i < getPopulation().getSize() & aux < limit; ++i) {
			aux += getPopulation().get(i).getFitness();
		}

		return getPopulation().get(i == 0 ? i : i - 1);
	}
	
	@Override
	public void beforeGeneration() { 
		getPopulation().sort();
	}
	
	@Override
	public void initialize() {
		getProblemType().setMaxmization();
	}
}
