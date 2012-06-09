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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import splice.ga.Population;
import util.TestChromosomeFactory;

public class RandomSelectorTest {
	Population population;
	final double FITNESS = 0.8;
	RandomSelector selector;
	Random random;

	@Before
	public void setUp() throws Exception {
		random = new Random();
		
		population = new Population();
		population.setSize(300);
		population.setFactory(new TestChromosomeFactory(FITNESS));
		population.setRandom(random);
		population.initialize();
		
		selector = new RandomSelector();
		selector.setRandom(random);
		selector.setPopulation(population);
	}

	@Test
	public void test() {
		assertNotNull(selector.getChromosome());
		assertEquals(FITNESS, selector.getChromosome().calculateFitness(), 0);
	}

}
