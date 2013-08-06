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

import splice.Algorithm;
import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;
import splice.cga.dataManipulator.ConsoleOutput;
import splice.cga.stopConditions.GenerationsStopCondition;
import splice.ga.SingleGeneChromosome;
import splice.ga.genes.BinaryGene;

/**
 * This class implements the Compact GA described in "The Compact Genetic Algorithm" article by Harik et al
 */
public class CompactGeneticAlgorithm implements Algorithm, InitializeComponent, ProblemTypeComponent {
    private double lastTime = 0;
    private ProbabilityVector vector;
    private SingleGeneChromosome<BinaryGene> a, b, best;
    private CgaStopCondition stopCondition = new GenerationsStopCondition(100);
    private int populationSize = 100;
    private int solutionSize;
    private CgaDataManipulator dataManipulator = new ConsoleOutput();
    private ProblemType problemType = new ProblemType();

    private void generate() {
        a.setGene(vector.generateGene());
        a.resetFitness();
        b.setGene(vector.generateGene());
        b.resetFitness();
    }

    private void setBest(SingleGeneChromosome<BinaryGene> chromosome) {
        boolean val = chromosome.getFitness() > best.getFitness();

        if (problemType.isMinimization())
            val = !val;

        if (best.getFitness() == Double.MIN_VALUE)
            val = true;

        if (val) {
            best = (SingleGeneChromosome<BinaryGene>) chromosome.clone();
            best.calculateFitness();
        }
    }

    private void setData(SingleGeneChromosome<BinaryGene> best, SingleGeneChromosome<BinaryGene> winner, SingleGeneChromosome<BinaryGene> loser) {
        stopCondition.setData(best, winner, loser);
        dataManipulator.setData(best, winner, loser);
    }

    private boolean compete() {
        boolean val;

        if (a.getFitness() > b.getFitness())
            val = true;
        else
            val = false;

        if (problemType.isMinimization())
            val = !val;

        return val;
    }

    public CompactGeneticAlgorithm(SingleGeneChromosome<BinaryGene> chromosome, int solutionSize) {
        this.a = chromosome;
        this.solutionSize = solutionSize;
    }

    @Override
    public void execute() throws Exception {
        initialize();

        double begin = System.currentTimeMillis();

        int generation = -1;
        do {
            generate();

            a.calculateFitness();
            b.calculateFitness();

            if (compete()) {
                // a is the winner
                vector.update(a.getGene(), b.getGene());
                setBest(a);
                setData(best, a, b);
            }
            else {
                // b is the winner
                vector.update(b.getGene(), a.getGene());
                setBest(b);
                setData(best, b, a);
            }

            generation++;

            dataManipulator.appendData(generation);
        } while(!stopCondition.stop(generation));

        double end = System.currentTimeMillis();

        dataManipulator.saveData();

        lastTime = end - begin;
    }

    @Override
    public double getLastTime() {
        return lastTime;
    }

    @Override
    public void initialize() {
        if (problemType.isUnset())
            problemType.setMaximization();

        vector = new ProbabilityVector(solutionSize, populationSize);

        b = (SingleGeneChromosome<BinaryGene>) a.clone();
        best = (SingleGeneChromosome<BinaryGene>) a.clone();

    }

    public void setStopCondition(CgaStopCondition stopCondition) {
        this.stopCondition = stopCondition;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public void setDataManipulator(CgaDataManipulator dataManipulator) {
        this.dataManipulator = dataManipulator;
    }

    public SingleGeneChromosome<BinaryGene> getBest() {
        return best;
    }

    @Override
    public void setProblemType(ProblemType type) {
        this.problemType = problemType;
    }

    @Override
    public ProblemType getProblemType() {
        return problemType;
    }
}