/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga;

import ga.dataManipulators.ConsoleOutput;
import ga.exceptionHandlers.ErrorStream;
import ga.stopConditions.Generations;

import java.io.PrintStream;
import java.util.Random;

/**
 * Base class for a genetic algorithm
 * @author igor
 *
 */
public class GeneticAlgorithm implements RandomComponent {
	private int pSize = 100;
	private double mRate = 0.2;
	private double fitnessSum;

	private Population population = new Population();

	private Selector selector;
	private PopulationAllocator allocator;
	private ChromosomeFactory factory;
	private DataManipulator dataManipulator = new ConsoleOutput();
	private StopCondition stopCondition = new Generations(2000);
	private ExceptionHandler handler = new ErrorStream();
	
	private Random random = new Random();
	
	/**
	 * Default constructor
	 * @param factory the factory from the initial chromosomes will come
	 * @param allocator the new population allocator
	 * @param selector the crossover candidates selector
	 */
	public GeneticAlgorithm(ChromosomeFactory factory,
			PopulationAllocator allocator, Selector selector) {
		this.allocator = allocator;
		this.selector = selector;
		this.factory = factory;
	}

	/**
	 * executes the genetic algorithm
	 */
	public void execute() {
		setRandomGenerator(selector);
		setRandomGenerator(allocator);
		setRandomGenerator(factory);
		
		factory.initialize();
		
		population.setSize(pSize);
		population.setFactory(factory);
		setRandomGenerator(population);
		population.initialize();

		setPopulationManipulator(allocator);
		setPopulationManipulator(selector);
		setPopulationManipulator(stopCondition);
		setPopulationManipulator(dataManipulator);
		
		try {
			int i = 0;
			do {
				population.calculateFitnessSum();
				
				allocator.reset();
				selector.beforeGeneration();
				doGeneneration();
				allocator.allocate();
				
				dataManipulator.appendData(i);
				i++;
			} while (!stopCondition.stop(i));
			dataManipulator.saveData();
			population.calculateFitnessSum();
		} catch (Exception ex) {
			handler.handle(ex);
		}
	}
	
	/**
	 * runs the generation's logic, can be overloaded in case of some need
	 */
	protected void doGeneneration() {
		BasicChromosome a, b, c;

		for (int i = 0; i < getPopulationSize(); i += 2) {
			a = getChromosome();
			b = getChromosome();
			
			c = crossover(a, b);
			mutate(c);
			allocator.append(c);

			c = crossover(a, b);
			mutate(c);
			allocator.append(c);
		}
	}
	
	private void setRandomGenerator(RandomComponent component) {
		component.setRandom(random);
	}
	
	private void setPopulationManipulator(PopulationManipulator manipulator) {
		manipulator.setPopulation(population);
	}

	public int getPopulationSize() {
		return pSize;
	}

	public double getMutationRate() {
		return mRate;
	}

	protected double getFitnessSum() {
		return fitnessSum;
	}

	protected void setFitnessSum(double fitnessSum) {
		this.fitnessSum = fitnessSum;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	protected BasicChromosome getChromosome() {
		return selector.getChromosome();
	}

	protected void mutate(BasicChromosome g) {
		g.mutate(mRate);
	}
	
	protected BasicChromosome crossover(BasicChromosome a, BasicChromosome b) {
		BasicChromosome c = a.crossover(b);
		c.setRandom(random);
		return c;
	}

	public void setPopulationSize(int size) {
		pSize = size;
	}

	public void setMutationRate(double rate) {
		mRate = rate;
	}

	public void setDataManipulator(DataManipulator dataManipulator) {
		this.dataManipulator = dataManipulator;
	}

	public StopCondition getStopCondition() {
		return stopCondition;
	}

	public void setStopCondition(StopCondition stopCondition) {
		this.stopCondition = stopCondition;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
	public void setExceptionHandler(ExceptionHandler handler) {
		this.handler = handler;
	}
}