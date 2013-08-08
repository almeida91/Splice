/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package splice.cga.dataManipulator;

import splice.cga.CgaDataManipulator;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * Similar to {@link splice.ga.dataManipulators.ConsoleOutput} but to {@link splice.cga.CompactGeneticAlgorithm}
 */
public class ConsoleOutput extends CgaDataManipulator {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public void saveData() throws Exception {
        writer.flush();
    }

    @Override
    protected void engineAppendData(int iteration) throws Exception {
        writer.append("Generation #")
        .append(Integer.toString(iteration))
        .append(" winner: ")
        .append(Double.toString(getWinnerFitness()))
        .append(" loser: ")
        .append(Double.toString(getLoserFitness()))
        .append(" best: ")
        .append(Double.toString(getBestFitness()))
        .append("\n");
    }
}
