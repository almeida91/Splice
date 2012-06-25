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

import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ReplaceAllocator;
import splice.ga.selectors.MinimizeTournamentSelector;
import splice.ga.stopConditions.Generations;

public class RunRosenbrock {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(new RosenbrockChromosomeFactory(), new ReplaceAllocator(), new MinimizeTournamentSelector());
		ga.setStopCondition(new Generations(1000));
		ga.execute();
		System.out.println(ga.getPopulation().getMinimum());
	}
}
