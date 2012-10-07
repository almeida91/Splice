/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package util;

import splice.ga.Chromosome;
import splice.ga.genes.BinaryGene;

/**
 * @author igor
 */
public class TestChromosome extends Chromosome<BinaryGene> {
    @Override
    protected Chromosome getNew() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected double fitness() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
