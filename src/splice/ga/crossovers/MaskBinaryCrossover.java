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

import splice.ga.Crossover;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

/**
 * @author igor
 */
public class MaskBinaryCrossover implements Crossover<BinaryGene> {
    protected BigInteger aMask, bMask;

    public MaskBinaryCrossover(BigInteger mask) {
        aMask = mask;
        if (aMask != null)
            bMask = aMask.not();
    }

    @Override
    public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
        BigInteger value = a.getValue().and(aMask).xor(b.getValue().and(bMask));
        BinaryGene g = new BinaryGene(value);
        g.setLength(a.getLength());

        return g;
    }
}
