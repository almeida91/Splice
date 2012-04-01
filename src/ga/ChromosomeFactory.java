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

import java.util.Random;

/**
 * This class defines the structure for the factories that produces
 * chromosomes to fill the population
 * 
 * @author igor
 * 
 */
@SuppressWarnings("rawtypes")
public abstract class ChromosomeFactory<T extends Gene> implements RandomComponent, InitializeComponent {
	private Random random;
	private ChromosomeType type;
	private Mutator<T> mutator;
	private Crossover<T> crossover;
	
	/**
	 * Generates a new random chromosome
	 * @return
	 */
	public abstract BasicChromosome getRandomChromosome();
	
	private void checkType(BasicChromosome chromosome) {
		if (type != null)
			return;
		if (chromosome instanceof Chromosome)
			type = ChromosomeType.NORMAL;
		else if(chromosome instanceof SingleGeneChromosome)
			type = ChromosomeType.SINGLE;
		else
			type = ChromosomeType.BASIC;
	}
	
	@SuppressWarnings("unchecked")
	public BasicChromosome generateChromosome() {
		BasicChromosome chromosome = getRandomChromosome();
		checkType(chromosome);
		
		if (type == ChromosomeType.NORMAL || type == ChromosomeType.SINGLE) {
			GeneContainer<T> c = (GeneContainer<T>)chromosome;
			c.setCrossover(crossover);
			c.setMutator(mutator);
		}			
		
		return chromosome;
	}

	public void initialize() { }

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public Mutator<T> getMutator() {
		return mutator;
	}

	public void setMutator(Mutator<T> mutator) {
		this.mutator = mutator;
		this.mutator.setRandom(random);
	}

	public Crossover<T> getCrossover() {
		return crossover;
	}

	public void setCrossover(Crossover<T> crossover) {
		this.crossover = crossover;
	}
}
