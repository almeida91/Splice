/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import util.TestChromosomeFactory;

public class PopulationTest {
	Population population;
	final int CHROMOSOMES = 300;
	final double FITNESS = 1;
	Random random;
	
	@Before
	public void setUp() throws Exception {
		population = new Population();
		population.setSize(CHROMOSOMES);
		population.setFactory(new TestChromosomeFactory(FITNESS));
		random = new Random();
		population.setRandom(random);
	}
	
	@Test
	public void testCalculateFitnessSum() {
		try{
		testInitializePopulation();
		population.calculateFitnessSum();
		assertEquals("fitness sum not expected", CHROMOSOMES * FITNESS, population.getFitnessSum(), 0);
		assertEquals("fitness average not expected", FITNESS, population.getFitnessAverage(), 0.5);
		}
		catch (Exception ex) {
			assertTrue(false);
		}
	}

	@Test
	public void testInitializePopulation() {
		population.initialize();
		assertEquals(CHROMOSOMES, population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			assertNotNull(population.get(i));
		}
	}

	/**
	 * should always return some chromosome
	 */
	@Test
	public void testGetRandom() {
		testInitializePopulation();
		assertNotNull("no random chromosome", population.getRandomChromosome());
	}

}
