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

import java.util.Comparator;
import java.util.Random;

/**
 * Base class for chromosomes, it doesn't support the mutator/crossover
 * interfaces. You may find it easier to customize the behavior of a single
 * individual using this class as you have to implement by yourself the logic
 * behind the crossover and mutation. It is also good when you need a better
 * performance as it makes fewer abstractions than its derivates.
 * Besides the fitness value and a Random object reference, by default no other
 * value is hold by this class.
 * 
 * @author Igor Almeida
 * 
 */
public abstract class BasicChromosome implements Comparable<BasicChromosome>, RandomComponent, InitializeComponent {
	private double fitness;
	private Random random;

	/**
	 * Implementation of the fitness function
	 * 
	 * @return
	 */
	protected abstract double fitness();

	/**
	 * Implementation of the chromosome's mutation logic
	 */
	protected abstract void mutate();

	/**
	 * Performs the chromosome's crossover with a given
	 * 
	 * @param chromosome
	 * @return
	 */
	public abstract BasicChromosome crossover(BasicChromosome chromosome);

	/**
	 * Calculate the chromosome's fitness
	 * @return
	 */
	public double calculateFitness() {
		fitness = fitness();
		return fitness;
	}

	public double getFitness() {
		return fitness;
	}
	
	@Override
	public void initialize() { }

	@Override
	public int compareTo(BasicChromosome o) {
		if (fitness == o.fitness)
			return 0;
		if (fitness > o.fitness)
			return 1;
		return -1;
	}

	public Comparator<BasicChromosome> getComparator() {
		return new ChromosomeComparator(fitness);
	}

	/**
	 * Mutates the chromosome with a given probability
	 * @param chance the probability of mutation
	 */
	public void mutate(double chance) {
		if (getRandom().nextGaussian() < chance)
			mutate();
	}

	@Override
	public void setRandom(Random random) {
		this.random = random;
	}

	@Override
	public Random getRandom() {
		return random;
	}
}
