/*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
* OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
* THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
* DEALINGS IN THE SOFTWARE.
*/
package splice.cga.stopConditions;


import splice.cga.CgaStopCondition;

/**
 * Stops after a number of generations has been executed like {@link splice.ga.stopConditions.Generations}
 */
public class GenerationsStopCondition extends CgaStopCondition {
    private int stop;

    /**
     * Default constructor
     * @param stop the number of generations to run
     */
    public GenerationsStopCondition(int stop) {
        this.stop = stop;
    }

    @Override
    protected boolean engineStop(int iteration) {
        return iteration >= stop;
    }
}
