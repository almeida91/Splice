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

public class MinimizeGeneticAlgorithm extends GeneticAlgorithm {
	public MinimizeGeneticAlgorithm(ChromosomeFactory factory,
			PopulationAllocator allocator, MinimizeSelector selector) {
		super(factory, allocator, selector);
	}

	@Override
	public BasicChromosome getBest() {
		BasicChromosome chromosome = getPopulation().getRandomChromosome();
		double fitness = chromosome.getFitness();
		for (BasicChromosome g : getPopulation().getChromosomes()) {
			if (g.getFitness() <= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}

	@Override
	public BasicChromosome getWorst() {
		double fitness = 0;
		BasicChromosome chromosome = null;
		for (BasicChromosome g : getPopulation().getChromosomes()) {
			if (g.getFitness() >= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}

}
