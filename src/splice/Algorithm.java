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
 * Defines a new Algorithm compatible with Splice's API
 */
public interface Algorithm {
    /**
     * Start the main optimization logic.
     * It usually contains the main loop which iterates through the steps.
     *
     * @throws Exception sometimes the algorithm may contain some kind of error handling, like the data manipulators
     */
    public void execute() throws Exception;

    /**
     * Returns the time required by the last time the logic in {@link #execute()} method required
     *
     * @return the time in milliseconds
     */
    public double getLastTime();
}
