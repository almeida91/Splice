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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves the generation data into a txt file
 * @author igor
 *
 */
public class GenerationDataFileOutput extends DataManipulator {
	protected BufferedWriter writer;

	public GenerationDataFileOutput(String path) throws IOException {
		writer = new BufferedWriter(new FileWriter(path));
	}

	@Override
	public void appendData(GenerationData data) throws Exception {
		writer.append(data.getFitnessAverage() + " "
				+ data.getBestChromosome().getFitness() + " "
				+ data.getWorstChromosome().getFitness() + "\n");
	}

	@Override
	public void saveData() throws Exception {
		writer.close();
	}
}
