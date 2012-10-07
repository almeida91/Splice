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

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import splice.ProblemTypeTest;
import splice.RandomComponentTest;
import util.TestAllocator;
import util.TestBasicChromosome;
import util.TestPopulation;

import java.util.ArrayList;

public class PopulationAllocatorTest {
	Population population;
	PopulationAllocator allocator;
    final int POPULATION_SIZE = 10;

	@Before
	public void setUp() {
		population = new TestPopulation(0.0, POPULATION_SIZE);
		population.initialize();
		
		allocator = new TestAllocator();
        allocator.setPopulation(population);
	}

	@Test
	public void testAppend() {
        testReset();
		allocator.append(new TestBasicChromosome(1));

        assertEquals(1, allocator.getNewPopulation().get(0).calculateFitness(), 0);
	}

	@Test
	public void testReset() {
        assertNull(allocator.getNewPopulation());
        allocator.reset();
		assertNotNull(allocator.getNewPopulation());
	}
	
	@Test
	public void testSetPopulation() {
        ArrayList<BasicChromosome> list = new ArrayList<BasicChromosome>();

        for (int i = 0; i < POPULATION_SIZE; i++) {
            list.add(new TestBasicChromosome(1));
        }

        allocator.setPopulation(list);

        for (BasicChromosome c : population.getChromosomes()) {
            assertEquals(1, c.calculateFitness(), 0);
        }
	}

    @Test
    public void testRandom() {
        RandomComponentTest.doTest(allocator);
    }

    @Test
    public void testProblemType() {
        ProblemTypeTest.doTest(allocator);
    }
}
