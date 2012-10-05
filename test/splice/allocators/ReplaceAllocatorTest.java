/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.allocators;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import splice.ga.BasicChromosome;
import splice.ga.Population;
import splice.ga.allocators.ReplaceAllocator;
import util.TestChromosome;
import util.TestPopulation;

public class ReplaceAllocatorTest {
    ReplaceAllocator allocator;
    Population population;
    final int POPULATION_SIZE = 10;
	
	@Before
	public void setUp() {
	    allocator = new ReplaceAllocator();
        population = new TestPopulation(0.0, POPULATION_SIZE);
        population.initialize();
        allocator.setPopulation(population);
        allocator.reset();
	}

	@Test
	public void testAllocate() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            allocator.append(new TestChromosome(1));
        }

        allocator.allocate();

        for (BasicChromosome c : population.getChromosomes()) {
            assertEquals(c.calculateFitness(), 1, 0);
        }
	}

	@Test
	public void testComplete() {
        for (int i = 0; i < POPULATION_SIZE; i++) {
            allocator.append(new TestChromosome(1));
        }
        assertTrue(allocator.complete());
	}
}
