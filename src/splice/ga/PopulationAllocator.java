/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Allocates a new population set to the current population
 * 
 * @author igor
 * 
 */
public abstract class PopulationAllocator implements RandomComponent, PopulationManipulator {
	private ArrayList<BasicChromosome> newPopulation;
	private Population population;
	private Random random;
	
	public void setPopulation(ArrayList<BasicChromosome> population) {
		this.population.getChromosomes().clear();
		this.population.getChromosomes().addAll(population);
	}
	
	public void setPopulation(Population population) {
		this.population = population;
	}
	
	public Population getPopulation() {
		return this.population;
	}
	
	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}
	
	/**
	 * Defines the logic of how to allocate the new set
	 * 
	 * @param newPopulation new chromosome's set
	 */
	public abstract void allocate();
	
	/**
	 * Appends a chromosome to the new population
	 * @param chromosome
	 */
	public void append(BasicChromosome chromosome) {
		chromosome.setRandom(getRandom());
		newPopulation.add(chromosome);
	}

	/**
	 * Returns the bufferized new population
	 * @return
	 */
	public ArrayList<BasicChromosome> getNewPopulation() {
		return newPopulation;
	}
	
	/**
	 * Resets the buffer, you don't want the population to grow till your memory overflows
	 */
	public void reset() {
		newPopulation = new ArrayList<BasicChromosome>(population.getSize());
	}
	
	/**
	 * sorts the the new population buffer
	 */
	public void sortNewPopulation() {
		Collections.sort(newPopulation, newPopulation.get(0).getComparator());
	}
	
	
}
