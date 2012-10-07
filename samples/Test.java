
/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import java.math.BigInteger;

import splice.ga.crossovers.SinglePointBinaryCrossover;
import splice.ga.genes.BinaryGene;


public class Test {
	public static void main(String[] args) {
		/*
		GeneticAlgorithm ga = new GeneticAlgorithm(
				new TestChromosomeFactory(),
				new ElitismAllocator(0.3), 
				new TournamentSelector(3));
		ga.setStopCondition(new Generations(10000));
		ga.execute();
		/*
		 * TestGenome g = new TestGenome(); for (int i = 0; i < 10; i++) {
		 * g=(TestGenome)g.getRandomGenome(); System.out.println(g); }
		 
		System.out.println(ga.getPopulation().getMaximum());
		*/
		
		SinglePointBinaryCrossover crossover = new SinglePointBinaryCrossover();
		BinaryGene a = new BinaryGene(new BigInteger("1111111111111111", 2));
		BinaryGene b = new BinaryGene(BigInteger.ZERO);
		
		System.out.println(crossover.doCrossover(a, b));
	}
}
