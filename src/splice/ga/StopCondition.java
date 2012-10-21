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

import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;

/**
 * defines how the genetic algorithm should stop
 * @author igor
 *
 */
public abstract class StopCondition extends PopulationManipulator implements ProblemTypeComponent, InitializeComponent {
	private ProblemType problemType;
	
	/**
	 * Defines when the GA may stop based on a defined condition
	 * @param generation current generation's number
	 * @return true if the condition has been met
	 */
	public abstract boolean stop(int generation);

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}

    @Override
    public void initialize() {
        return;
    }
}
