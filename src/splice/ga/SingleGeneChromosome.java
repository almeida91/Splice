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

/**
 * This class contains a single gene, it is useful when you want to store
 * just a single information. You could also use the Chromosome class
 * but it contains loops and checks that are not necessary when you have
 * just a single gene.
 * @author igor
 *
 * @param <T>
 */
@SuppressWarnings("rawtypes")
public abstract class SingleGeneChromosome<T extends Gene> extends BasicChromosome implements SingleGeneContainer<T> {
	private T gene;
	private Crossover<T> crossover;
	private Mutator<T> mutator;
	
	protected abstract SingleGeneChromosome<T> getNew();
	
	@Override
	public void setGene(T gene) {
		this.gene = gene;
	}
	
	public T getGene() {
		return gene;
	}
	
	@Override
	public void setCrossover(Crossover<T> crossover) {
		this.crossover = crossover;
	}
	
	@Override
	public void setMutator(Mutator<T> mutator) {
		this.mutator = mutator;
	}
	
	@Override
	protected void mutate() {
		this.mutator.mutate(gene);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		SingleGeneChromosome<T> other = (SingleGeneChromosome<T>)chromosome;
		SingleGeneChromosome<T> newChromosome = getNew();
		newChromosome.gene = crossover.doCrossover(gene, other.gene);
		
		newChromosome.mutator = mutator;
		newChromosome.crossover = crossover;
		
		return newChromosome;
	}

	@Override
	public String toString() {
		return gene.toString();
	}
	
	@Override
	public void setRandom(Random random) {
		super.setRandom(random);
		gene.setRandom(random);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
        if (!(obj instanceof SingleGeneChromosome))
            return false;

		SingleGeneChromosome<T> o = (SingleGeneChromosome<T>)obj;

		return o.gene.equals(gene);
	}
}
