/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package nqueens;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.IntegerListGene;

/**
 * This is just a test needs heavy refactory
 * @author igor
 *
 */
public class NQueensChromosome extends SingleGeneChromosome<IntegerListGene> {
	public boolean line(int ax, int ay, int bx, int by) {
		return ax == bx;
	}

	public boolean column(int ax, int ay, int bx, int by) {
		return ay == by;
	}

	public boolean diagonal(int ax, int ay, int bx, int by) {
		return ax - bx == ay - by | ax + ay == bx + by;
	}


    @Override
    protected double fitness() {
        double f = 0;

        for (int i = 0; i < getGene().getSize(); i++) {
            for (int j = 0; j < getGene().getSize(); j++) {
                if (i != j) {
                    if (line(i, getGene().get(i), j, getGene().get(j))) {
                        f += 1;
                    }
                    if (column(i, getGene().get(i), j, getGene().get(j))) {
                        f += 1;
                    }
                    if (diagonal(i, getGene().get(i), j, getGene().get(j))) {
                        f += 1;
                    }
                }
            }
        }

        return f;
    }
}
