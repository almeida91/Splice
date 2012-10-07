/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice;

/**
 * Defines if the given problem's optimization is looking for the maximum or minimum
 */
public class ProblemType {
	private boolean maximization, minimization;

	public void setMaximization() {
		maximization = true;
		minimization = false;
	}
	
	public void setMinimization() {
		maximization = false;
		minimization = true;
	}

	public boolean isMaximization() {
		return maximization;
	}

	public boolean isMinimization() {
		return minimization;
	}
}
