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
import ga.GenerationData;

import org.junit.Before;
import org.junit.Test;

public class GenerationsTest {
	Generations condition;
	GenerationData data;
	final int GENERATIONS = 1000;
	final int MAX = 100;

	@Before
	public void setUp() throws Exception {
		condition = new Generations(GENERATIONS);
		data = new GenerationData();
	}

	@Test
	public void testStop() {
		for (int i = 0; i < GENERATIONS + MAX; i++) {
			data.setGeneration(i);
			if (i < GENERATIONS)
				assertFalse(condition.stop(data));
			else
				assertTrue(condition.stop(data));
		}
	}

}
