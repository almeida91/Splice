/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.stopConditions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import splice.ga.Population;
import splice.ga.stopConditions.MinimumAverageFitness;
import util.TestPopulation;

public class MinimumAverageFitnessTest {
	final double MINIMUM_FITNESS = 0.5;
	final double STEP = 0.3;
	MinimumAverageFitness condition;
	Population populationContinue, populationStop;

	@Before
	public void setUp() throws Exception {
		condition = new MinimumAverageFitness(MINIMUM_FITNESS);
		populationContinue = new TestPopulation(MINIMUM_FITNESS - STEP);
		populationStop = new TestPopulation(MINIMUM_FITNESS + STEP);
	}

	@Test
	public void testStop() {
		condition.setPopulation(populationContinue);
		assertFalse(condition.stop(0));
		condition.setPopulation(populationStop);
		assertTrue(condition.stop(0));
	}

}
