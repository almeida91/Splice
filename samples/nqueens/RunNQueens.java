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

import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitistAllocator;
import splice.ga.parallel.ParallelPopulation;
import splice.ga.selectors.MinimizeTournamentSelector;
import splice.stopCondition.Iterations;

public class RunNQueens {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(new NQueensChromosomeFactory(8), new ElitistAllocator(0.1), new MinimizeTournamentSelector());
        ga.setPopulation(new ParallelPopulation());
		ga.setStopCondition(new Iterations(10000));
        ga.setPopulationSize(100);
		ga.execute();
		
		System.out.println(ga.getPopulation().getMaximum());
        System.out.println(ga.getLastTime());
    }
}
