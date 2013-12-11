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

import org.junit.Before;
import org.junit.Test;
import util.MockBasicChromosome;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * @author igor
 */
public class ChromosomeComparatorTest {
    ChromosomeFitnessComparator comparator;
    BasicChromosome t0, t1, t2;
    double value = 1;

    @Before
    public void setUp() {
        comparator = new ChromosomeFitnessComparator(value);

        t0 = new MockBasicChromosome(value - 1);
        t1 = new MockBasicChromosome(value);
        t2 = new MockBasicChromosome(value + 1);

        t0.calculateFitness();
        t1.calculateFitness();
        t2.calculateFitness();
    }

    @Test
    public void testCompare() {
        assertEquals(-1, comparator.compare(t1, t2));
        assertEquals(0, comparator.compare(t1, t1));
        assertEquals(1, comparator.compare(t1, t0));
    }

    @Test
    public void testEquals() {
        assertTrue(comparator.equals(t1));
    }

    public static void doTest(Comparator<BasicChromosome> comparator, double value) {
        ChromosomeComparatorTest test = new ChromosomeComparatorTest();
        test.value = value;
        test.setUp();
        test.comparator = (ChromosomeFitnessComparator)comparator;
        test.testCompare();
        test.testEquals();
    }
}
