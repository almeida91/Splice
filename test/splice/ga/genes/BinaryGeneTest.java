/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.genes;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @author igor
 */
public class BinaryGeneTest {
    @Test
    public void testInitialize() throws Exception {

    }

    @Test
    public void testSetLength() throws Exception {

    }

    @Test
    public void testToString() throws Exception {
        BinaryGene gene = new BinaryGene(4);
        assertEquals("100", gene.toString());
    }

    @Test
    public void testToFloat() throws Exception {
        float value = 3.4f;

        BinaryGene gene = new BinaryGene(value);
        assertEquals(value, gene.toFloat(), 0);
    }

    @Test
    public void testToDouble() throws Exception {
        double value = 3.4;

        BinaryGene gene = new BinaryGene(value);
        assertEquals(value, gene.toDouble(), 0);
    }

    @Test
    public void testToInt() throws Exception {
        int value = 3;

        BinaryGene gene = new BinaryGene(value);
        assertEquals(value, gene.toInt());
    }

    @Test
    public void testToLong() throws Exception {
        long value = 6857172311231212313L;

        BinaryGene gene = new BinaryGene(value);
        assertEquals(value, gene.toLong());
    }

    @Test
    public void testToByteArray() throws Exception {

    }
}
