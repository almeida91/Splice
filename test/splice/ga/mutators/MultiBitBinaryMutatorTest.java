/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.mutators;

import org.junit.Before;
import org.junit.Test;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @author igor
 */
public class MultiBitBinaryMutatorTest {
    MultiBitBinaryMutator mutator;
    Random random;
    static final int NUM_BITS = 10;

    @Before
    public void setUp() throws Exception {
        random = new Random();

        mutator = new MultiBitBinaryMutator(NUM_BITS);
    }

    @Test
    public void testMutate() throws Exception {
        BigInteger originalValue, value = new BigInteger(512, random);
        originalValue = value.or(BigInteger.ZERO);
        BinaryGene gene = new BinaryGene(value);

        mutator.mutate(gene);

        // verifies that the hamming distance is just one bit, remember it is per nature a random code
        // so we put a delta to consider this variations
        assertEquals(NUM_BITS, gene.getValue().xor(originalValue).bitCount(), 2);
    }

}
