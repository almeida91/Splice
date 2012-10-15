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

import static org.junit.Assert.*;

import splice.RandomComponentTest;
import splice.ga.genes.BinaryGene;

import util.TestChromosome;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author igor
 */
public class ChromosomeTest {
    Chromosome<BinaryGene> chromosome;
    final int LENGTH = 10;

    @Before
    public void setUp() {
        chromosome = new TestChromosome();
        chromosome.setRandom(new Random());

        BinaryGene[] genes = new BinaryGene[LENGTH];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = new BinaryGene(i);
        }

        chromosome.setGenes(genes);
    }

    @Test
    public void testGet() throws Exception {
        for (int i = 0; i < LENGTH; i++) {
            assertEquals(i, chromosome.get(i).toInt());
        }
    }

    @Test
    public void testSetCrossover() throws Exception {

    }

    @Test
    public void testSetMutator() throws Exception {

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
