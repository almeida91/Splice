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

import util.MockGene;


/**
 * @author igor
 */
public class GeneTest {
    final int VALUE = 42;
    Gene<Integer> gene;

    @Before
    public void setUp() {
        gene = new MockGene<Integer>(42);
    }

    @Test
    public void testSetValue() {
        gene.setValue(10);
        assertEquals(10, gene.getValue().longValue());
    }

    @Test
    public void testEquals() {
        assertTrue(gene.equals(new MockGene<Integer>(42)));
        assertFalse(gene.equals(new MockGene<Integer>(77)));
        assertFalse(gene.equals(new Object()));
    }

    @Test
    public void testToString() {
        assertEquals("42", gene.toString());
    }

    @Test
    public void testInitialize() throws Exception {
        gene.initialize();
        assertEquals(VALUE, gene.getValue().longValue());
    }
}
