/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.dataFormatters;

import splice.ga.GeneticAlgorithmDataFormatter;

/**
 * Prints each generation data into the default output stream
 * @author igor
 *
 */
public class LabeledGeneration extends GeneticAlgorithmDataFormatter {
    private StringBuilder builder = new StringBuilder();
	
	public String format(int generation) {
        builder.append("Generation #")
        .append(generation)
        .append(" fitness: ")
        .append(getPopulation().getFitnessAverage())
        .append(" max: ")
        .append(getPopulation().getMaximum().getFitness())
        .append(" min: ")
        .append(getPopulation().getMinimum().getFitness())
        .append(" pop size: ")
        .append(getPopulation().getSize())
        .append("\n");

        String ret = builder.toString();
        builder.delete(0, builder.length());

        return ret;
	}

}
