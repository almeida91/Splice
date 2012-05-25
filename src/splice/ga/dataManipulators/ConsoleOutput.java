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

import splice.ga.DataManipulator;
import splice.ga.Population;

/**
 * Prints each generation data into the default output stream
 * @author igor
 *
 */
public class ConsoleOutput extends DataManipulator {
	
	@Override
	public void engineAppendData(int generation) throws Exception {
		System.out.println("Generation #" + generation + " fitness: "
				+ getPopulation().getFitnessAverage() + " max: "
				+ getPopulation().getMaximum().getFitness() + " min: "
				+ getPopulation().getMinimum().getFitness() + " pop size: "
				+ getPopulation().getSize());
	}

	@Override
	public void saveData() { }
}
