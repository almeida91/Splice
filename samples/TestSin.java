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
import splice.ga.allocators.ElitistAllocator;
import splice.ga.selectors.TournamentSelector;
import splice.stopCondition.Iterations;

public class TestSin {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(
				new SinChromosomeFactory(),
				new ElitistAllocator(0.3),
				new TournamentSelector(3)
		);
		ga.setStopCondition(new Iterations(100000));


        double begin = System.currentTimeMillis();
		ga.execute();
        double end = System.currentTimeMillis();

		System.out.println(ga.getLastTime() / 1000 + " s");
        System.out.println((end - begin) / 1000 + " s");

		System.out.println(ga.getPopulation().getMaximum().calculateFitness());
		System.out.println(ga.getPopulation().getChromosomesSet().size());
	}
}
