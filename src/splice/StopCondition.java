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
 * Defines when an algorithm will stop.
 * Like {@link DataManipulator} it may have conditions that makes required to every algorithm implement its
 * own.
 */
public interface StopCondition extends ProblemTypeComponent {
    /**
     * The condition's implementation.
     *
     * @param iteration the current execution iteration.
     * @return true if the algorithm has reached its condition.
     */
    public boolean stop(int iteration);

    /**
     *
     * @return true if the stop condition can be used in any algorithm
     */
    public boolean isCommonUsage();
}
