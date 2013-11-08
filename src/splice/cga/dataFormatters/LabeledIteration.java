/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */
package splice.cga.dataFormatters;

import splice.cga.CgaDataFormatter;

/**
 * Similar to {@link splice.ga.dataFormatters.LabeledGeneration} but to {@link splice.cga.CompactGeneticAlgorithm}
 */
public class LabeledIteration extends CgaDataFormatter {
    private StringBuilder builder = new StringBuilder();

    public String doFormat(int iteration) {
        builder.append("Generation #")
        .append(Integer.toString(iteration))
        .append(" winner: ")
        .append(Double.toString(getWinnerFitness()))
        .append(" loser: ")
        .append(Double.toString(getLoserFitness()))
        .append(" best: ")
        .append(Double.toString(getBestFitness()))
        .append("\n");

        String ret = builder.toString();
        builder.delete(0, builder.length());

        return ret;
    }
}
