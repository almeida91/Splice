/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

/**
 * Stops the genetic algorithm when after n-generations no evolution is achieved
 * shouldn't used with non-elitist allocators as the values may change so it
 * will come to an infinite loop.
 * This condition considers evolution the increase in the population's best fitness
 * @author igor
 *
 */
public class Convergence implements StopCondition {
	private int maxGenerations;
	private double minFitness = 0;
	
	private double bestFitness;
	private int generations = 0; 
	
	public Convergence(int maxGenerations) {
		this.maxGenerations = maxGenerations;
	}
	
	/**
	 * like the default constructor, but it will not stop if the minimum fitness
	 * has not been achieved 
	 * @param maxGenerations
	 * @param minFitness
	 */
	public Convergence(int maxGenerations, double minFitness) {
		this.maxGenerations = maxGenerations;
		this.minFitness = minFitness;
	}
	
	@Override
	public boolean stop(GenerationData data) {
		double fitness = data.getBestChromosome().getFitness();
		
		if (fitness == bestFitness)
			generations++;
		if (fitness > bestFitness) {
			bestFitness = fitness;
			generations = 0;
		}
		
		return generations >= maxGenerations & bestFitness >= minFitness;
	}

}
