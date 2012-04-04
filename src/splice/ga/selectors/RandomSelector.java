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

import java.util.Random;

import splice.ga.BasicChromosome;
import splice.ga.MaxmizeSelector;
import splice.ga.MinimizeSelector;
import splice.ga.Population;


/**
 * Select a random chromosome
 * @author igor
 *
 */
public class RandomSelector implements MinimizeSelector, MaxmizeSelector {
	private Population population;
	private Random random;
	
	@Override
	public BasicChromosome getChromosome() {
		return population.getRandomChromosome();
	}

	@Override
	public void setPopulation(Population population) {
		this.population = population;
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
	public Population getPopulation() {
		return population;
	}

	@Override
	public void beforeGeneration() { }
}
