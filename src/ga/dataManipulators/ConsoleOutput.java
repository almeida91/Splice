/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.dataManipulators;

import ga.DataManipulator;
import ga.GenerationData;

/**
 * Prints each generation data into the default output stream
 * @author igor
 *
 */
public class ConsoleOutput extends DataManipulator {
	@Override
	public void appendData(GenerationData data) throws Exception {
		System.out.println("Generation #" + data.getGeneration() + " fitness: "
				+ data.getFitnessAverage() + " best: "
				+ data.getBestChromosome().getFitness() + " worst: "
				+ data.getWorstChromosome().getFitness() + " pop size: "
				+ data.getPopulation().getChromosomes().size());
	}

	@Override
	public void saveData() { }

}
