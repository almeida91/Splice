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

import java.util.Random;

@SuppressWarnings("rawtypes")
public abstract class Chromosome<T extends Gene> extends BasicChromosome implements GeneContainer<T> {
	private T[] genes;
	private Crossover<T> crossover;
	private Mutator<T> mutator;
	
	protected abstract Chromosome getNew();
	
	public T get(int i) {
		return genes[i];
	}
	
	public void setCrossover(Crossover<T> crossover) {
		this.crossover = crossover;
	}
	
	public void setMutator(Mutator<T> mutator) {
		this.mutator = mutator;
	}
	
	public void setGenes(T[] genes) {
		this.genes = genes;
	}
	
	@Override
	protected void mutate() {
        for (T gene : genes) {
            mutator.mutate(gene);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		Chromosome newChromosome = getNew();
		Chromosome other = (Chromosome)chromosome;
		
		newChromosome.crossover = crossover;
		newChromosome.mutator = mutator;
		newChromosome.genes = new Gene[genes.length];
		
		for (int i = 0; i < genes.length; i++) {
			newChromosome.genes[i] = this.crossover.doCrossover(this.genes[i], (T)(other.get(i)));
		}
		
		return newChromosome;
	}

	@Override
	public void setRandom(Random random) {
		super.setRandom(random);
		for (Gene g : genes)
			g.setRandom(random);
	}
	
	@Override
	public String toString() {
		String s = "[";
		for (Gene g : genes)
			s += g + ", ";
		s += "]";
		return s;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
        if (!(obj instanceof Chromosome))
            return false;

		Chromosome<T> o = (Chromosome<T>)obj;
		
		for (int i = 0; i < genes.length; i++) {
			if (!genes[i].equals(o.genes[i]))
				return false;
		}
		
		return true;
	}
}
