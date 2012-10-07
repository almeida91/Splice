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
import splice.RandomComponentTest;
import splice.ga.genes.BinaryGene;
import util.TestChromosome;

/**
 * @author igor
 */
public class ChromosomeTest {
    Chromosome<BinaryGene> chromosome;

    @Before
    public void setUp() {
        chromosome = new TestChromosome();
    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSetCrossover() throws Exception {

    }

    @Test
    public void testSetMutator() throws Exception {

    }

    @Test
    public void testSetGenes() throws Exception {

    }

    @Test
    public void testCrossover() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

    @Test
    public void testSetRandom() {


        RandomComponentTest.doTest(chromosome);
    }

    @Test
    public void testEquals() throws Exception {

    }
}
