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
import splice.ga.BasicChromosome;
import splice.ga.Chromosome;
import splice.ga.ChromosomeType;
import splice.ga.SingleGeneChromosome;
import splice.ga.genes.BinaryGene;

/**
 * This class implements the Compact GA described in "The Compact Genetic Algorithm" article by Harik et al
 */
public class CompactGeneticAlgorithm implements Algorithm, InitializeComponent, ProblemTypeComponent {
    private double lastTime = 0;
    private ProbabilityVector vector;
    private BasicChromosome a, b, best;
    private ChromosomeType chromosomeType;
    private CgaStopCondition stopCondition = new GenerationsStopCondition(100);
    private int populationSize = 100;
    private int[] solutionSize;
    private CgaDataManipulator dataManipulator = new ConsoleOutput();
    private ProblemType problemType = new ProblemType();

    /**
     * Set the chromosome's genes with values generated by the probability vector.
     */
    private void generate() {
        if (chromosomeType == ChromosomeType.SINGLE) {
            ((SingleGeneChromosome<BinaryGene>)a).setGene(vector.generateGene(0));
            a.resetFitness();
            ((SingleGeneChromosome<BinaryGene>)(b)).setGene(vector.generateGene(0));
            b.resetFitness();
        }
        else if (chromosomeType == ChromosomeType.NORMAL) {
            ((Chromosome<BinaryGene>)a).setGenes(vector.generateGenes());
            a.resetFitness();
            ((Chromosome<BinaryGene>)b).setGenes(vector.generateGenes());
            b.resetFitness();
        }
    }

    /**
     * Verifies if the given chromosome is better than the current stored and replaces it if true.
     *
     * @param chromosome a chromosome best candidate
     */
    private void setBest(BasicChromosome chromosome) {
        boolean val = chromosome.getFitness() > best.getFitness();

        if (problemType.isMinimization())
            val = !val;

        if (best.getFitness() == Double.MIN_VALUE)
            val = true;

        if (val) {
            best = chromosome.clone();
            best.calculateFitness();
        }
    }

    private void setData(BasicChromosome best, BasicChromosome winner, BasicChromosome loser) {
        stopCondition.setData(best, winner, loser);
        dataManipulator.setData(best, winner, loser);
    }

    private void update(BasicChromosome winner, BasicChromosome loser) {
        if (chromosomeType == ChromosomeType.SINGLE) {
            vector.update(((SingleGeneChromosome<BinaryGene>)winner).getGene(), ((SingleGeneChromosome<BinaryGene>)loser).getGene(), 0);
        }
        else if (chromosomeType == ChromosomeType.NORMAL) {
            vector.update(((Chromosome<BinaryGene>)winner).getGenes(), ((Chromosome<BinaryGene>)winner).getGenes());
        }
    }

    /**
     *
     * @return true if a is the winner and false if b
     */
    private boolean compete() {
        boolean val;

        val = a.getFitness() > b.getFitness();

        if (problemType.isMinimization())
            val = !val;

        return val;
    }

    /**
     *
     * @param chromosome the chromosome structure that will be applied in the algorithm
     * @param solutionSize number of bits in the chromosome
     */
    public CompactGeneticAlgorithm(SingleGeneChromosome<BinaryGene> chromosome, int solutionSize) {
        this.a = chromosome;
        this.chromosomeType = ChromosomeType.SINGLE;

        this.solutionSize = new int[1];
        this.solutionSize[0] = solutionSize;
    }

    public CompactGeneticAlgorithm(Chromosome<BinaryGene> chromosome, int[] sizes) {
        this.a = chromosome;
        this.solutionSize = sizes;
        this.chromosomeType = ChromosomeType.NORMAL;
    }

    public CompactGeneticAlgorithm(Chromosome<BinaryGene> chromosome, int chromosomeSize, int geneSize) {
        this(chromosome, null);
        int[] sizes = new int[chromosomeSize];
        for (int i = 0; i < chromosomeSize; i++)
            sizes[i] = geneSize;
        this.solutionSize = sizes;
    }

    protected void doGeneration() {
        generate();

        a.calculateFitness();
        b.calculateFitness();

        if (compete()) {
            // a is the winner
            update(a, b);
            setBest(a);
            setData(best, a, b);
        }
        else {
            // b is the winner
            update(b, a);
            setBest(b);
            setData(best, b, a);
        }
    }

    @Override
    public void execute() throws Exception {
        initialize();

        double begin = System.currentTimeMillis();

        int generation = -1;
        do {
            doGeneration();

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

        b = a.clone();
        best = a.clone();

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

    public BasicChromosome getBest() {
        return best;
    }

    @Override
    public void setProblemType(ProblemType type) {
        this.problemType = type;
    }

    @Override
    public ProblemType getProblemType() {
        return problemType;
    }
}
