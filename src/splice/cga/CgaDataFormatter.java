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

import splice.DataFormatter;
import splice.DataManipulator;
import splice.exceptions.DataNotSetException;

/**
 * CGA {@link DataManipulator} implementation
 */
public abstract class CgaDataFormatter extends ContextManipulator implements DataFormatter {
    public String format(int iteration) {
        if (!isDataSet())
            throw new DataNotSetException();
        else
            reset();

        return doFormat(iteration);
    }

    public abstract String doFormat(int iteration);
}
