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

import org.junit.Test;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * @author igor
 */
public class MaskBinaryCrossoverTest {
    @Test
    public void testDoCrossover() throws Exception {
        MaskBinaryCrossover crossover = new MaskBinaryCrossover(new BigInteger("111111110000000011111111", 2));

        BinaryGene a = new BinaryGene(new BigInteger("111111111111111111111111", 2));
        BinaryGene b = new BinaryGene(BigInteger.ZERO);

        BinaryGene c = crossover.doCrossover(a, b);

        assertEquals("111111110000000011111111", c.toString());
    }
}
