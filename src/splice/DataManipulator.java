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
 * Defines how to save the algorithm execution data.
 * In an ideal world one should fit with every algorithm, unfortunately as every algorithm has its own format and
 * may not hold the same information we can't just pull from one algorithm to another.
 * Each class that follows this interface should also implement an internal buffer.
 */
public interface DataManipulator {
    /**
     * How every iteration data will be appended to the internal buffer.
     *
     * @param iteration current iteration number the data comes from
     * @throws Exception as it usually deals with IO exceptions are common
     */
    public void appendData(int iteration) throws Exception;

    /**
     * Saves the data that has been gathered through {@link #appendData(int)}.
     * When implementing your own you should have some kind of buffer that register the information and save it using
     * this method.
     * @throws Exception
     */
    public void saveData() throws Exception;
}
