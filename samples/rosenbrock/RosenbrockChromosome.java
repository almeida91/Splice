/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package rosenbrock;

import splice.ga.Chromosome;
import splice.ga.genes.BinaryGene;

public class RosenbrockChromosome extends Chromosome<BinaryGene> {
	@Override
	protected double fitness() {
		double x = get(0).toFloat();
		double y = get(1).toFloat();
		
		return Math.pow(1 - x, 2) + 100 * Math.pow(y - Math.pow(x, 2), 2);
	}

    @Override
    public String toString() {
        return  "f(" + get(0).toFloat() + ", " + get(1).toFloat() + ") = " + getFitness();
    }
}
