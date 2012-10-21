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
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import splice.RandomComponentTest;
import util.MockBasicChromosome;
import util.MockBasicChromosomeFactory;

public class PopulationTest {
	Population population;
	final int CHROMOSOMES = 300;
	final double FITNESS = 1;
	Random random;
	
	@Before
	public void setUp() throws Exception {
		population = new Population();
		population.setSize(CHROMOSOMES);
		population.setFactory(new MockBasicChromosomeFactory(FITNESS));
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
	 * must always return some chromosome
	 */
	@Test
	public void testGetRandom() {
		testInitializePopulation();
		assertNotNull("no random chromosome", population.getRandomChromosome());
	}

    public void fill() throws Exception{
        population.initialize();
        population.getChromosomes().clear();

        for (int i = 0; i < CHROMOSOMES; i++) {
            population.getChromosomes().add(new MockBasicChromosome(i));
        }

        population.calculateFitnessSum();
    }

    @Test
    public void testSort() throws Exception {
        fill();

        population.sort();

        for (int i = 0; i < CHROMOSOMES; i++) {
            assertEquals(i, population.get(i).getFitness(), 0);
        }
    }

    @Test
    public void testGetMaximum() throws Exception {
        fill();

        assertEquals(CHROMOSOMES - 1, population.getMaximum().getFitness(), 0);
    }

    @Test
    public void testGetMinimum() throws Exception {
        fill();

        assertEquals(0, population.getMinimum().getFitness(), 0);
    }

    @Test
    public void testGetChromosomesTest() throws Exception {
        population.initialize();
        population.getChromosomes().clear();

        for (int i = 0; i < CHROMOSOMES; i++) {
            population.getChromosomes().add(new MockBasicChromosome(1));
        }

        population.calculateFitnessSum();

        Set<BasicChromosome> set = population.getChromosomesSet();

        assertEquals(1, set.size());
    }

    @Test
    public void testRandom() {
        RandomComponentTest.doTest(population);
    }
}
