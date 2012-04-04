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

/**
 * Base class for the generation data log/manipulation logic
 * @author igor
 *
 */
public abstract class DataManipulator implements PopulationManipulator {
	/**
	 * Appends a new generation to the execution data
	 * @param data the data of a given generation
	 * @throws Exception
	 */
	public abstract void appendData(int generation) throws Exception;
	/**
	 * Saves the input
	 * @throws Exception
	 */
	public abstract void saveData() throws Exception;
}
