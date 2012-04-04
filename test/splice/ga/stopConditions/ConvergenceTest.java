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
import splice.ga.stopConditions.Convergence;
import util.TestChromosome;

public class ConvergenceTest { // TODO: unimplemented
	Convergence condition;
	BasicChromosome bestStop;
	BasicChromosome bestContinue;
	final int GENERATIONS = 1000;
	final int MAX = 100;
	final double MINIMUM_FITNESS = 0.7;
	final double STEP = 0.1;
	
	@Before
	public void setUp() {
		bestContinue = new TestChromosome(MINIMUM_FITNESS - STEP);
		bestStop = new TestChromosome(MINIMUM_FITNESS + STEP); 
	}

	@Test
	public void testStop() {
		condition = new Convergence(GENERATIONS);
	}

	@Test
	public void testStopMinFitness() {
		condition = new Convergence(GENERATIONS, MINIMUM_FITNESS);
		
	}
}
