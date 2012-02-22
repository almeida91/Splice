/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.stopConditions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinimumAverageFitnessTest { // FIXME: requires a fake population object, as there's no longer GenerationData class
	final double MINIMUM_FITNESS = 0.5;
	final double STEP = 0.6;
	MinimumAverageFitness condition;

	@Before
	public void setUp() throws Exception {
		condition = new MinimumAverageFitness(MINIMUM_FITNESS);
		
	}

	@Test
	public void testStop() {
	}

}
