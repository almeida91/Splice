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
public abstract class ChromosomeFactory implements RandomComponent, InitializeComponent {
	private Random random;
	private ChromosomeType type;
	private Gene[] genes;
	private Mutator[] mutators;
	private Crossover[] crossovers;
	
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
	
	public BasicChromosome generateChromosome() {
		if (type == ChromosomeType.NORMAL) {
			Chromosome c = (Chromosome)getRandomChromosome();
			
			return c;
		}
		else if (type == ChromosomeType.SINGLE) {
			SingleGeneChromosome<?> c = (SingleGeneChromosome<?>)getRandomChromosome();
			
			return c;
		}
		
		return getRandomChromosome();
	}

	public void initialize() { }

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
}
