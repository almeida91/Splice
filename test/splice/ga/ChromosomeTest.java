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

import splice.ga.genes.BinaryGene;

import util.MockChromosome;
import util.MockCrossover;
import util.MockMutator;

/**
 * @author igor
 */
public class ChromosomeTest {
    Chromosome<BinaryGene> chromosome;
    MockCrossover crossover;
    MockMutator mutator;
    BinaryGene[] genes;
    final int LENGTH = 10;

    @Before
    public void setUp() {
        chromosome = new MockChromosome();

        genes = new BinaryGene[LENGTH];

        for (int i = 0; i < genes.length; i++) {
            genes[i] = new BinaryGene(i);
        }

        chromosome.setGenes(genes);

        crossover = new MockCrossover();
        chromosome.setCrossover(crossover);

        mutator = new MockMutator();
        chromosome.setMutator(mutator);
    }

    @Test
    public void testGet() throws Exception {
        for (int i = 0; i < LENGTH; i++) {
            assertEquals(i, chromosome.get(i).getLength());
        }

    }

    @Test
    public void testCrossover() throws Exception {
        Chromosome<?> n = (Chromosome<?>)(chromosome.crossover(chromosome));
        assertEquals(LENGTH, crossover.getTimesCalled());

        for (int i = 0; i < LENGTH; i++) {
            assertEquals(genes[i], n.get(i));
        }
    }

    @Test
    public void testToString() throws Exception {
        String s = "[";

        for (Gene<?> g : genes)
            s += g + ", ";

        s += "]";

        assertEquals(s, chromosome.toString());
    }

    @Test
    public void testEquals() throws Exception {
        MockChromosome c = new MockChromosome();
        c.setGenes(genes.clone());

        assertTrue(c.equals(chromosome));
        assertFalse(c.equals(new Object()));
    }

    @Test
    public void testMutate() throws Exception {
        chromosome.mutate();

        assertTrue(mutator.isCalled());
        assertEquals(LENGTH, mutator.getTimesCalled());
    }
}
