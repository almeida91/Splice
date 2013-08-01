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

import java.util.*;

import splice.InitializeComponent;
import splice.RandomUtil;

/**
 * The chromosome's collection
 * @author igor
 *
 */
public class Population implements InitializeComponent {
	/**
	 * this contains all the chromosomes
	 */
	private ArrayList<BasicChromosome> chromosomes;
	/**
	 * the sum of all fitnesses it's used in roulette selection and in the average calculation
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
	private ChromosomeFactory<?> factory;

	/**
	 * Calculates the chromosome's fitness as well their averages
     * @throws Exception to be used when you have some kind of complex fitness function that throws something
     * so the exception will be propagated
     */
	public void calculateFitnessSum() throws Exception {
		fitnessSum = 0;
        for (BasicChromosome chromosome : chromosomes) {
            fitnessSum += chromosome.calculateFitness();
        }
		fitnessAverage = fitnessSum / chromosomes.size();
	}

	public void initialize() {
		chromosomes = new ArrayList<BasicChromosome>(size);

		for (int i = 0; i < size; i++) {
			chromosomes.add(factory.generateChromosome());
		}
	}
	
	/**
	 * Sorts the population based on the chromosome's comparator
	 */
	public void sort() {
		Collections.sort(chromosomes, new ChromosomeComparator(0));
	}
	
	/**
	 * Searches the chromosome with highest fitness value
	 * @return the chromosome with maximum fitness
	 */
	public BasicChromosome getMaximum() {
		double fitness = 0;
		BasicChromosome chromosome = null;
		for (BasicChromosome g : chromosomes) {
			if (g.getFitness() >= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}
	
	/**
	 * Searches the chromosome with the population's lowest fitness
	 * @return the chromosome with minimum fitness
	 */
	public BasicChromosome getMinimum() {
		BasicChromosome chromosome = getRandomChromosome();
		double fitness = chromosome.getFitness();
		for (BasicChromosome g : chromosomes) {
			if (g.getFitness() <= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}
	
	/**
	 * @return the chromosome's collection
	 */
	public ArrayList<BasicChromosome> getChromosomes() {
		return chromosomes;
	}
        
    public void setChromosomes(ArrayList<BasicChromosome> x) {
        this.chromosomes = x;
    }
	
	public Set<BasicChromosome> getChromosomesSet() {
		TreeSet<BasicChromosome> set = new TreeSet<BasicChromosome>();
		set.addAll(chromosomes);
		return set;
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
		return this.get(RandomUtil.getRandom().nextInt(getSize()));
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public void setFactory(ChromosomeFactory<?> factory) {
		this.factory = factory;
	}

	public ChromosomeFactory<?> getFactory() {
		return factory;
	}
}
