
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
import splice.ga.dataManipulators.GenerationPopulationOutput;
import splice.ga.selectors.NeighborhoodSelector;
import splice.ga.selectors.TournamentSelector;
import splice.ga.stopConditions.Generations;

public class TestSin {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(
				new SinChromosomeFactory(),
				new ElitismAllocator(0.3),
				new TournamentSelector(3)
				//new NeighborhoodSelector(5)
		);
		ga.setStopCondition(new Generations(1000));
		//ga.setDataManipulator(new GenerationPopulationOutput("/Users/igor/test"));
		
		ga.execute();
		System.out.println(ga.getLastTime() / 1000 + " s");
		System.out.println(ga.getPopulation().getMaximum());
		System.out.println(ga.getPopulation().getChromosomesSet().size());
	}
}
