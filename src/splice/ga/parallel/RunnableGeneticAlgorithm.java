/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.parallel;

import splice.ga.ChromosomeFactory;
import splice.ga.GeneticAlgorithm;
import splice.ga.PopulationAllocator;
import splice.ga.Selector;


/**
 * 
 * @author igor
 *
 */
public class RunnableGeneticAlgorithm extends GeneticAlgorithm implements Runnable {
	public RunnableGeneticAlgorithm(ChromosomeFactory<?> factory,
			PopulationAllocator allocator, Selector selector) {
		super(factory, allocator, selector);
	}

	@Override
	public void run() {
		execute();
	}
}
