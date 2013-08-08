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

import splice.RandomUtil;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

/**
 * Holds the probability for each bit in the chromosome
 */
public class ProbabilityVector {
    private double[] vector;
    private int popSize;
    private int size;

    /**
     * Default constructor
     *
     * @param size the solution size in bits
     * @param populationSize the size of the population
     */
    public ProbabilityVector(int size, int populationSize) {
        this.size = size;
        this.vector = new double[size];

        for (int i = 0; i < size; i++) {
            this.vector[i] = 0.5f;
        }

        popSize = populationSize;
    }

    /**
     * Updates the probabilities based on the result of the generation
     *
     * @param winner the chromosome that has the higher fitness in the pair
     * @param loser the lower fitness in the pair
     */
    public void update(BinaryGene winner, BinaryGene loser) {
        boolean w, l;

        for (int i = 0; i < size; i++) {
            w = winner.getValue().testBit(i);
            l = loser.getValue().testBit(i);

            if (w != l) {
                if (w)
                    vector[i] += 1.0 / popSize;
                else
                    vector[i] -= 1.0 / popSize;
            }
        }
    }

    /**
     * Generates a gene based on the current probabilities
     *
     * @return
     */
    public BinaryGene generateGene() {
        BigInteger bigInt = new BigInteger(size, RandomUtil.getRandom());

        for (int i = 0; i < size; i++) {
            if (RandomUtil.getRandom().nextDouble() < vector[i])
                bigInt.setBit(i);
        }

        return new BinaryGene(bigInt);
    }
}
