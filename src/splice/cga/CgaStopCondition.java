/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package splice.cga;

import splice.ProblemType;
import splice.StopCondition;
import splice.exceptions.DataNotSetException;

/**
 * Compact Genetic Algorithm {@link StopCondition} implementation
 */
public abstract class CgaStopCondition extends ContextManipulator implements StopCondition {
    private ProblemType problemType;

    /**
     * Implement this to define your own stop condition
     * @param iteration iteration number
     * @return true if the condition has been reached
     */
    protected abstract boolean engineStop(int iteration);

    @Override
    public boolean stop(int iteration) {
        if (!isDataSet())
            throw new DataNotSetException();
        else
            reset();

        return engineStop(iteration);
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }
}
