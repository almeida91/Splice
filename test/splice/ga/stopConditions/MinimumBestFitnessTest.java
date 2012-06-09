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


import org.junit.Before;
import org.junit.Test;

import splice.ga.BasicChromosome;
import util.TestChromosome;

public class MinimumBestFitnessTest {
	BasicChromosome bestStop, bestContinue;
	MinimumBestFitness condition;
	final double MINIMUM_FITNESS = 0.7;
	final double STEP = 0.1;

	@Before
	public void setUp() throws Exception {
		condition = new MinimumBestFitness(MINIMUM_FITNESS);
		bestStop = new TestChromosome(MINIMUM_FITNESS + STEP);
		bestContinue = new TestChromosome(MINIMUM_FITNESS - STEP); 
		bestStop.calculateFitness();
		bestContinue.calculateFitness();
	}

	@Test
	public void testStop() {
		// FIXME: needs refactor
		//data.setBestChromosome(bestStop);
		//assertTrue("don't stop", condition.stop(data));
		//data.setBestChromosome(bestContinue);
		//assertFalse("premature stop", condition.stop(data));
	}

}
