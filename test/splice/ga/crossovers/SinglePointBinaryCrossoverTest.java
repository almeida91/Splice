/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.crossovers;

import org.junit.Before;
import org.junit.Test;
import splice.ga.genes.BinaryGene;

import static org.junit.Assert.*;

import java.math.BigInteger;

/**
 * @author igor
 */
public class SinglePointBinaryCrossoverTest {
    @Test
    public void testCrossover() {
        SinglePointBinaryCrossover crossover = new SinglePointBinaryCrossover();

        BinaryGene a = new BinaryGene(new BigInteger("1111111111111111", 2));
        BinaryGene b = new BinaryGene(BigInteger.ZERO);

        BinaryGene c = crossover.doCrossover(a, b);

        assertEquals("1111111100000000", c.toString());
    }
}
