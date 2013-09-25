/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitismAllocator;
import splice.ga.selectors.MinimizeTournamentSelector;
import splice.ga.stopConditions.Convergence;
import splice.ga.stopConditions.Generations;

public class RunOneZero {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(new OneZeroChromosomeFactory(255), new ElitismAllocator(0.3), new MinimizeTournamentSelector());
		ga.setStopCondition(new Generations(100));
		ga.execute();
		
		System.out.println();
		System.out.println(ga.getPopulation().getMaximum());
		System.out.println(ga.getPopulation().getMinimum());
		System.out.println(ga.getPopulation().getChromosomesSet().size());
	}
}
