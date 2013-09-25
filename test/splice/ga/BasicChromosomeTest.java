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

import util.MockBasicChromosome;

import java.util.Random;

/**
 * @author igor
 */
public class BasicChromosomeTest {
    MockBasicChromosome chromosome;
    final int MUTATION_UNIVERSE = 100;
    final double MUTATION_PROBABILITY = 0.1;
    final double FITNESS = 1;
    Random random;

    @Before
    public void setUp() {
        chromosome = new MockBasicChromosome(FITNESS);
        random = new Random();
    }

    @Test
    public void testCalculateFitness() {
        assertEquals(Double.MIN_VALUE, chromosome.getFitness(), 0);
        assertEquals(FITNESS, chromosome.calculateFitness(), 0);
        assertEquals(FITNESS, chromosome.getFitness(), 0);
    }

    @Test
    public void testMutate() {
        double mutatedTimes = 0;

        for (int i = 0; i < MUTATION_UNIVERSE; i++) {
            setUp();
            chromosome.mutate(MUTATION_PROBABILITY);
            if (chromosome.isMutated())
                mutatedTimes++;
        }

        assertEquals(MUTATION_PROBABILITY, mutatedTimes / MUTATION_UNIVERSE, 0.1);
    }

    @Test
    public void testGetComparator() throws Exception {
        double value = chromosome.calculateFitness();
        ChromosomeComparatorTest.doTest(chromosome.getComparator(), chromosome.getFitness());
    }

    @Test
    public void testInitialize() throws Exception {
        assertEquals(Double.MIN_VALUE, chromosome.getFitness(), 0);
        chromosome.initialize();
        assertEquals(Double.MIN_VALUE, chromosome.getFitness(), 0);
    }
}
