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

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;

public class NQueensChromosomeFactory extends ChromosomeFactory {
	private int n;

	public NQueensChromosomeFactory(int n) {
		this.n = n;
	}

	@Override
	public BasicChromosome getRandomChromosome() {
		int[][] queens = new int[n][2];

		for (int i = 0; i < n; i++) {
			queens[i][0] = getRandom().nextInt(n);
			queens[i][1] = getRandom().nextInt(n);
		}

		return new NQueensChromosome(n, queens);
	}

}
