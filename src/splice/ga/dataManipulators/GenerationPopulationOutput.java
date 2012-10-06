/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.dataManipulators;

import java.io.IOException;

import splice.ga.BasicChromosome;


/**
 * Save the whole generation fitness to a specified file
 * @author dev01
 *
 */
public class GenerationPopulationOutput extends GenerationDataFileOutput {
	private int step, counter;
	
	/**
	 * @param path where you want to save the file
     * @param step defines at which number of generations it will save the population data
	 * @throws IOException may throw on some stream error
	 */
	public GenerationPopulationOutput(String path, int step) throws IOException {
		super(path);
		this.step = step;
		this.counter = -1;
	}
	
	public GenerationPopulationOutput(String path) throws IOException {
		this(path, 1);
	}
	
	@Override
	public void engineAppendData(int generation) throws Exception {
		counter += 1;
		if (counter % step == 0) {
			for (BasicChromosome chromosome : getPopulation().getChromosomes()) {
                writer.append(String.valueOf(chromosome.getFitness())).append(" ");
			}
			writer.append('\n');
		}
	}
}
