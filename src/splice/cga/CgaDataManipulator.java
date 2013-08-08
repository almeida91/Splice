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

import splice.DataManipulator;
import splice.exceptions.DataNotSetException;

/**
 * CGA {@link DataManipulator} implementation
 */
public abstract class CgaDataManipulator extends ContextManipulator implements DataManipulator {
    @Override
    public void appendData(int iteration) throws Exception {
        if (!isDataSet())
            throw new DataNotSetException();
        else
            reset();

        engineAppendData(iteration);
    }

    @Override
    public abstract void saveData() throws Exception;

    /**
     * To be called inside {@link #appendData(int)}.
     * @param iteration current iteration
     * @throws Exception usually an IO exception
     */
    protected abstract void engineAppendData(int iteration) throws Exception;
}
