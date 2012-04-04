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


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import splice.ga.DataManipulator;
import splice.ga.Population;

/**
 * Saves the generation data into a txt file
 * @author igor
 *
 */
public class GenerationDataFileOutput extends DataManipulator {
	protected BufferedWriter writer;
	protected Population population; 

	public GenerationDataFileOutput(String path) throws IOException {
		writer = new BufferedWriter(new FileWriter(path));
	}

	@Override
	public void appendData(int generation) throws Exception {
		writer.append(population.getFitnessAverage() + " "
				+ population.getMaximum().getFitness() + " "
				+ population.getMinimum().getFitness() + "\n");
	}

	@Override
	public void saveData() throws Exception {
		writer.close();
	}

	@Override
	public void setPopulation(Population population) {
		this.population = population;
	}

	@Override
	public Population getPopulation() {
		return population;
	}
}
