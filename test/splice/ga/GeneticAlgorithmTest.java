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
import util.*;

public class GeneticAlgorithmTest {
	GeneticAlgorithm ga;
    MockAllocator allocator;
    MockSelector selector;
    MockBasicChromosomeFactory factory;
    DataManipulator manipulator;
    StopCondition stopCondition;


	@Before
	public void setUp() {
        allocator = new MockAllocator();
        selector = new MockSelector();
        factory = new MockBasicChromosomeFactory(0);
        manipulator = new MockDataManipulator();
        stopCondition = new MockStopCondition(false);

        ga = new GeneticAlgorithm(factory, allocator, selector);
        ga.setStopCondition(stopCondition);
	}

	@Test
	public void testDoGeneration() {
        allocator.setPopulation(new MockPopulation(0.5,10));
        allocator.reset();
		ga.doGeneration(0);
        assertEquals(10, allocator.getNewPopulation().size());
	}

	@Test
	public void testInitialize() {
		ga.initialize();

        assertTrue(factory.isInitialized());

        assertNotNull(allocator.getPopulation());
        assertNotNull(selector.getPopulation());
        assertNotNull(stopCondition.getPopulation());
        assertNotNull(allocator.getPopulation());

        assertTrue(factory.isInitialized());
        assertTrue(allocator.isInitialized());
        assertTrue(selector.isInitialized());

        assertNotNull(allocator.getProblemType());
        assertNotNull(stopCondition.getProblemType());
        assertNotNull(selector.getProblemType());

        assertTrue(allocator.getProblemType().isMaximization());
        assertTrue(stopCondition.getProblemType().isMaximization());
        assertTrue(selector.getProblemType().isMaximization());
	}
}
