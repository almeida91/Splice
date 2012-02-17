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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The chromosome's collection
 * @author igor
 *
 */
public class Population implements RandomComponent, InitializeComponent {
	/**
	 * this contains all the chromosomes
	 */
	private ArrayList<BasicChromosome> chromosomes;
	/**
	 * the sum of all fitnesses it's used in roullette selection and in the average calculation
	 */
	protected double fitnessSum;
	/**
	 * population's average fitness
	 */
	protected double fitnessAverage;
	/**
	 * population's size
	 */
	private int size;
	/**
	 * the factory to fill the initial population
	 */
	private ChromosomeFactory factory;
	private Random random;

	/**
	 * Calculates the chromosome's fitness as well their averages
	 */
	public void calculateFitnessSum() throws Exception {
		fitnessSum = 0;
		for (int i = 0; i < chromosomes.size(); i++) {
			fitnessSum += chromosomes.get(i).calculateFitness();
		}
		fitnessAverage = fitnessSum / chromosomes.size();
	}

	/**
	 * 
	 */
	public void initialize() {
		BasicChromosome chromosome;
		chromosomes = new ArrayList<BasicChromosome>(size);

		for (int i = 0; i < size; i++) {
			chromosome = factory.getRandomChromosome();
			chromosome.setRandom(random);
			chromosomes.add(chromosome);
		}
	}
	
	/**
	 * Sorts the population based on the chromosome's comparator
	 */
	public void sort() {
		Collections.sort(chromosomes, new ChromosomeComparator(0));
	}

	/**
	 * @return the chromosome's collection
	 */
	public ArrayList<BasicChromosome> getChromosomes() {
		return chromosomes;
	}

	public double getFitnessSum() {
		return fitnessSum;
	}

	public double getFitnessAverage() {
		return fitnessAverage;
	}

	public int getSize() {
		return chromosomes.size();
	}

	public BasicChromosome get(int i) {
		return chromosomes.get(i);
	}
	
	public BasicChromosome getRandomChromosome() {
		return this.get(getRandom().nextInt(getSize()));
	}
	
	public Random getRandom() {
		return random;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setFactory(ChromosomeFactory factory) {
		this.factory = factory;
	}
}
