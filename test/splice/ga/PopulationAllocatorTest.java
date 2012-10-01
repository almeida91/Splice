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

import util.TestAllocator;
import util.TestPopulation;

public class PopulationAllocatorTest {
	Population population;
	PopulationAllocator allocator;
	ChromosomeFactory<?> factory;
	
	@Before
	public void setUp() {
		population = new TestPopulation(0.0, 10);
		population.initialize();
		
		allocator = new TestAllocator();
	}

	@Test
	public void testAppend() {
		allocator.setPopulation(population);
		
	}

	@Test
	public void testReset() {
		allocator.setPopulation(population);
		
		
	}
	
	@Test
	public void testSetPopulation() {
		fail("Not yet implemented");
	}

}
