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

    public ProblemType() {
        maximization = minimization = false;
    }

    /**
     * Assures that once defined you can't change the type, so you won't have both
     * variables set to true.
     */
    private void verify() {
        if (maximization || minimization)
            throw new RuntimeException("Problem type already defined");
    }

    /**
     * Makes the problem a maximization one.
     */
	public void setMaximization() {
        verify();
		maximization = true;
		minimization = false;
	}

    /**
     * Sets the problem to minimization.
     */
	public void setMinimization() {
        verify();
		maximization = false;
		minimization = true;
	}

    /**
     * If the optimization aims to maximize the objective function.
     *
     * @return true if it is a maximization
     */
	public boolean isMaximization() {
		return maximization;
	}

    /**
     * Like {@link #isMaximization()} but for minimization.
     *
     * @return true if it is a minimization
     */
	public boolean isMinimization() {
		return minimization;
	}

    /**
     * Verifies if the problem type has been set.
     *
     * @return true if no optimization type has been set
     */
    public boolean isUnset() {
        return !(maximization || minimization);
    }
}
