/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.genes;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class IntegerBinaryGeneTest {
	IntegerBinaryGene gene;
	final int LENGTH = 512;

	@Before
	public void setUp() throws Exception {
		gene = new IntegerBinaryGene(LENGTH);
		gene.setRandom(new Random());
	}

	@Test
	public void testInitialize() {
		gene.initialize();
		assertNotNull(gene.getValue());
		assertEquals(LENGTH, gene.getValue().bitLength(), 8.0);
	}

}
