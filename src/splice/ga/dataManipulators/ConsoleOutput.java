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
import java.io.OutputStreamWriter;
import splice.ga.DataManipulator;

/**
 * Prints each generation data into the default output stream
 * @author igor
 *
 */
public class ConsoleOutput extends DataManipulator {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	@Override
	public void engineAppendData(int generation) throws Exception {
                writer.append("Generation #")
                .append(Integer.toString(generation))
                .append(" fitness: ")
                .append(Double.toString(getPopulation().getFitnessAverage()))
                .append(" max: ")
                .append(Double.toString(getPopulation().getMaximum().getFitness()))
                .append(" min: ")
                .append(Double.toString(getPopulation().getMinimum().getFitness()))
                .append(" pop size: ")
                .append(Integer.toString(getPopulation().getSize()))
                .append("\n");
	}

	@Override
	public void saveData() throws Exception {
            writer.close();
        }
}
