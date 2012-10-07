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

import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;
import splice.RandomComponent;

/**
 * Allocates a new population set to the current population
 * 
 * @author igor
 * 
 */
public abstract class PopulationAllocator extends PopulationManipulator implements RandomComponent, InitializeComponent, ProblemTypeComponent {
	private ArrayList<BasicChromosome> newPopulation;
	private Population population;
	private Random random;
	private ProblemType problemType;

    /**
     * This method replaces the current population with other chromosomes,
     * but keeps the reference to the old population object
     * @param population
     */
	public void setPopulation(ArrayList<BasicChromosome> population) {
		this.population.getChromosomes().clear();
		this.population.getChromosomes().addAll(population);
	}

    /**
     * Changes the allocator's population reference
     * @param population which one will have chromosomes allocated
     */
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
	 */
	public abstract void allocate();
	
	/**
	 * 
	 * @return true if the buffer has been filled
	 */
	public abstract boolean complete();
	
	/**
	 * Appends a chromosome to the new population
	 * @param chromosome one chromosome
	 */
	public void append(BasicChromosome chromosome) {
		chromosome.setRandom(getRandom());
		newPopulation.add(chromosome);
	}

	/**
	 * @return the bufferized new population
	 */
	public ArrayList<BasicChromosome> getNewPopulation() {
		return newPopulation;
	}
	
	/**
	 * Resets the buffer, you don't want the population to grow till your memory overflows
	 */
	public void reset() { //TODO: should call this at initialization
		newPopulation = new ArrayList<BasicChromosome>(population.getSize());
	}
	
	public int bufferSize() {
		return newPopulation.size();
	}
	
	/**
	 * sorts the the new population buffer
	 */
	public void sortNewPopulation() {
		Collections.sort(newPopulation, new ChromosomeComparator(0));
	}

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}
}
