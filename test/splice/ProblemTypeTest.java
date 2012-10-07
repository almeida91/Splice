/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * @author igor
 */
public class ProblemTypeTest extends TestCase {
    ProblemType type;

    @Before
    public void setUp() {
        type = new ProblemType();
    }

    @Test
    public void testSetMaximization() {
        type.setMaximization();

        assertTrue(type.isMaximization());
        assertFalse(type.isMinimization());
    }

    @Test
    public void testSetMinimization() {
        type.setMinimization();

        assertTrue(type.isMinimization());
        assertFalse(type.isMaximization());
    }

    public static void doTest(ProblemTypeComponent component) {
        component.setProblemType(new ProblemType());
        assertNotNull(component.getProblemType());
    }
}
