/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga;

import java.util.Random;

import splice.ExceptionHandler;
import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;
import splice.RandomComponent;

import splice.ga.dataManipulators.ConsoleOutput;
import splice.ga.exceptionHandlers.ErrorStream;
import splice.ga.stopConditions.Generations;

/**
 * Base class for a genetic algorithm
 * @author igor
 *
 */
public class GeneticAlgorithm implements RandomComponent, InitializeComponent {
	private int populationSize = 100;
	private double mutationRate = 0.2;
	private double fitnessSum;
	private double lastTime = 0;
	private boolean initPopulation = true;

	private Population population = new Population();

	private Selector selector;
	private PopulationAllocator allocator;
	private ChromosomeFactory<?> factory;
	private DataManipulator dataManipulator = new ConsoleOutput();
	private StopCondition stopCondition = new Generations(2000);
	private ExceptionHandler handler = new ErrorStream();
	private ProblemType problemType = new ProblemType();
	
	private Random random = new Random();
	
	/**
	 * Default constructor
	 * @param factory the factory from the initial chromosomes will come
	 * @param allocator the new population allocator
	 * @param selector the crossover candidates selector
	 */
	public GeneticAlgorithm(ChromosomeFactory<?> factory,
			PopulationAllocator allocator, Selector selector) {
		this.allocator = allocator;
		this.selector = selector;
		this.factory = factory;
		
		problemType.setMaxmization();
	}

	/**
	 * executes the genetic algorithm
	 */
	public void execute() {
		initialize();
		
		double begin = System.currentTimeMillis();
		
		try {
			int i = 0;
			do {
				population.calculateFitnessSum();
				dataManipulator.appendData(i);
				
				allocator.reset();
				selector.beforeGeneration();
				doGeneneration(i);
				allocator.allocate();
				
				i++;
			} while (!stopCondition.stop(i));
			dataManipulator.saveData();
			population.calculateFitnessSum();
		} catch (Exception ex) {
			handler.handle(ex);
		}
		
		double end = System.currentTimeMillis();
		
		lastTime = end - begin;
	}
	
	/**
	 * runs the generation's logic, can be overloaded in case of some need
	 */
	protected void doGeneneration(int i) {
		BasicChromosome a, b, c;

		while (!allocator.complete()) {
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
	
	public void initialize() {
		dataManipulator.setHandler(handler);
		
		setRandomGenerator(selector);
		setRandomGenerator(allocator);
		setRandomGenerator(factory);
		setRandomGenerator(population);
		
		factory.initialize();
		
		if (initPopulation) {
			population.setSize(populationSize);
			population.setFactory(factory);
			population.initialize();
		}

		setPopulationManipulator(allocator);
		setPopulationManipulator(selector);
		setPopulationManipulator(stopCondition);
		setPopulationManipulator(dataManipulator);
		
		setProblemType(allocator);
		setProblemType(stopCondition);
		setProblemType(selector);
		
		allocator.initialize();
		selector.initialize();
	}
	
	private void setProblemType(ProblemTypeComponent component) {
		component.setProblemType(problemType);
	}
	
	private void setRandomGenerator(RandomComponent component) {
		component.setRandom(random);
	}
	
	private void setPopulationManipulator(PopulationManipulator manipulator) {
		manipulator.setPopulation(population);
	}

	public int getPopulationSize() {
		return populationSize;
	}

	public double getMutationRate() {
		return mutationRate;
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
		g.mutate(mutationRate);
	}
	
	protected BasicChromosome crossover(BasicChromosome a, BasicChromosome b) {
		BasicChromosome c = a.crossover(b);
		c.setRandom(random);
		return c;
	}

	public void setPopulationSize(int size) {
		populationSize = size;
	}

	public void setMutationRate(double rate) {
		mutationRate = rate;
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

	/**
	 * With this you can use a predefined chromosome set,
	 * just remember to call this before execute
	 * @param initPopulation
	 */
	public void setInitPopulation(boolean initPopulation) {
		this.initPopulation = initPopulation;
	}

	/**
	 * Returns the last execution time in milliseconds 
	 */
	public double getLastTime() {
		return this.lastTime;
	}
}