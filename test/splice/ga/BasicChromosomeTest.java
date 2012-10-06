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

import util.TestBasicChromosome;

import java.util.Random;

/**
 * @author igor
 */
public class BasicChromosomeTest {
    TestBasicChromosome chromosome;
    final int MUTATION_UNIVERSE = 100;
    final double MUTATION_PROBABILITY = 0.1;
    Random random;

    @Before
    public void setUp() {
        chromosome = new TestBasicChromosome(1);
        random = new Random();
        chromosome.setRandom(random);
    }

    @Test
    public void testCalculateFitness() {
        assertEquals(0, chromosome.getFitness(), 0);
        assertEquals(1, chromosome.calculateFitness(), 0);
        assertEquals(1, chromosome.getFitness(), 0);
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
    public void testCompareTo() {
        BasicChromosome t0, t1, t2;
        t0 = new TestBasicChromosome(0);
        t1 = new TestBasicChromosome(1);
        t2 = new TestBasicChromosome(2);

        chromosome.calculateFitness();
        t0.calculateFitness();
        t1.calculateFitness();
        t2.calculateFitness();

        assertEquals(-1, chromosome.compareTo(t2));
        assertEquals(0, chromosome.compareTo(t1));
        assertEquals(1, chromosome.compareTo(t0));
    }

}
