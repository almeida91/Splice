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

import splice.ga.BasicChromosome;

/**
 * The context means the state of the algorithm after the chromosomes has been generated
 * and evaluated.
 */
public abstract class ContextManipulator {
    private double bestFitness, winnerFitness, loserFitness;
    private boolean dataSet;

    /**
     * Updates the fitness values
     *
     * @param best current best fitness found by the algorithm
     * @param winner winner from the last round
     * @param loser lesser fitness from the last round
     */
    public void setData(double best, double winner, double loser) {
        bestFitness = best;
        winnerFitness = winner;
        loserFitness = loser;

        dataSet = true;
    }

    /**
     * Same as {@link #setData(double, double, double)} but it extracts the fitness values from the given chromosomes.
     *
     */
    public void setData(BasicChromosome best, BasicChromosome winner, BasicChromosome loser) {
        setData(best.getFitness(), winner.getFitness(), loser.getFitness());
    }

    /**
     * Reports that the data the component contains is outdated.
     */
    protected void reset() {
        dataSet = false;
    }

    protected double getBestFitness() {
        return bestFitness;
    }

    protected double getWinnerFitness() {
        return winnerFitness;
    }

    protected double getLoserFitness() {
        return loserFitness;
    }

    public boolean isDataSet() {
        return dataSet;
    }
}
