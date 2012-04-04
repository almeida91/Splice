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

@SuppressWarnings("rawtypes")
public abstract class Chromosome<T extends Gene> extends BasicChromosome implements GeneContainer<T> {
	private T[] genes;
	private Crossover<T> crossover;
	private Mutator<T> mutator;
	
	protected abstract Chromosome getNew();
	
	public Chromosome(T[] genes, Crossover<T> crossover, Mutator<T> mutator) {
		this.genes = genes;
		this.crossover = crossover;
		this.mutator = mutator;
	}
	
	public T get(int i) {
		return genes[i];
	}
	
	public void setCrossovers(Crossover<T> crossover) {
		this.crossover = crossover;
	}
	
	public void setMutators(Mutator<T> mutator) {
		this.mutator = mutator;
	}
	
	public void setGenes(T[] genes) {
		this.genes = genes;
	}
	
	@Override
	protected void mutate() {
		for (int i = 0; i < genes.length; i++) {
			mutator.mutate(genes[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		Chromosome newChromsome = getNew();
		Chromosome other = (Chromosome)chromosome;
		
		newChromsome.crossover = crossover;
		newChromsome.mutator = mutator;
		newChromsome.genes = new Gene[genes.length];
		
		for (int i = 0; i < genes.length; i++) {
			newChromsome.genes[i] = this.crossover.doCrossover(this.genes[i], (T)(other.get(i)));
		}
		return null;
	}

}
