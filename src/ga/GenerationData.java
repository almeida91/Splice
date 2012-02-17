/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga;

/**
 * The information produced in a single generation
 * @author igor
 *
 */
public class GenerationData {
	private BasicChromosome bestChromosome, worstChromosome;
	private Population population;
	private double fitnessAverage;
	private int generation;

	public BasicChromosome getBestChromosome() {
		return bestChromosome;
	}

	public void setBestChromosome(BasicChromosome bestChromosome) {
		this.bestChromosome = bestChromosome;
	}

	public BasicChromosome getWorstChromosome() {
		return worstChromosome;
	}

	public void setWorstChromosome(BasicChromosome worstChromosome) {
		this.worstChromosome = worstChromosome;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	public double getFitnessAverage() {
		return fitnessAverage;
	}

	public void setFitnessAverage(double fitnessAverage) {
		this.fitnessAverage = fitnessAverage;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

}
