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

import splice.InitializeComponent;

/**
 * This class defines the structure for the factories that produces
 * chromosomes to fill the population
 * 
 * @author igor
 * 
 */
@SuppressWarnings("rawtypes")
public abstract class ChromosomeFactory<T extends Gene> implements InitializeComponent {
	private ChromosomeType type;
	private Mutator<T> mutator;
	private Crossover<T> crossover;
    private Gene<?> gene;
    private int size;
	
	/**
	 * This method is used to fill the population with new individuals.
	 * @return new random chromosome
	 */
	public abstract BasicChromosome getRandomChromosome();



    /**
     * Finds which kind of chromosome will be generated
     * @param chromosome a chromosome with random values, it usually comes from #{getRandomChromosome}
     */
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

            if (type == ChromosomeType.SINGLE) {
                Gene<?> gene = generateGene();
                gene.initialize();
                ((SingleGeneChromosome)chromosome).setGene(gene);
            } else if (type == ChromosomeType.NORMAL) {
                Gene<?>[] genes = new Gene<?>[size];

                for (int i = 0; i < size; i++) {
                    genes[i] = generateGene();
                    genes[i].initialize();
                }

                ((Chromosome)chromosome).setGenes(genes);
            }
		}

		return chromosome;
	}

    private Gene<?> generateGene() {
        Gene<?> g = null;

        try {
            g = gene.clone();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return g;
    }

    public void initialize() { }

	public Mutator<T> getMutator() {
		return mutator;
	}

	public void setMutator(Mutator<T> mutator) {
		this.mutator = mutator;
	}

	public Crossover<T> getCrossover() {
		return crossover;
	}

	public void setCrossover(Crossover<T> crossover) {
		this.crossover = crossover;
	}

    public ChromosomeType getChromosomeType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setGene(Gene<?> gene) {
        this.gene = gene;
    }
}
