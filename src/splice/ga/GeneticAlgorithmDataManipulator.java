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

import splice.DataManipulator;

/**
 * Base class for the generation data log/manipulation logic
 * @author igor
 *
 */
public abstract class GeneticAlgorithmDataManipulator extends PopulationManipulator implements DataManipulator {
	/**
	 * Appends a new generation to the execution data
	 * @param generation current generation to save data
	 * @throws Exception mainly IO exceptions due to the manipulations that might be done inside the class
	 */
	protected abstract void engineAppendData(int generation) throws Exception;

    /**
	 * Saves the input
	 * @throws Exception may throw an exception
	 */
	public abstract void saveData() throws Exception;

    /**
     * Appends a information to the manipulator, it should be noted that when an exception is thrown by #{engineAppendData}
     * it will no stop the genetic algorithm's execution, but will log it using the provided handler
     * @param generation current generation
     */
	public void appendData(int generation) throws Exception {
		engineAppendData(generation);
	}
}
