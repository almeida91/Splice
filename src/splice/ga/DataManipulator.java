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

import splice.ExceptionHandler;

/**
 * Base class for the generation data log/manipulation logic
 * @author igor
 *
 */
public abstract class DataManipulator extends PopulationManipulator {
	private ExceptionHandler handler;
	
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
	
	public void setHandler(ExceptionHandler handler) {
		this.handler = handler;
	}
	
	public ExceptionHandler getHandler() {
		return handler;
	}
	
	public void appendData(int generation) {
		try {
			engineAppendData(generation);
		} catch (Exception e) {
			handler.handle(e);
		}
	}
}
