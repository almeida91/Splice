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

import splice.ExceptionHandler;
import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;

import splice.ga.dataManipulators.ConsoleOutput;
import splice.ga.exceptionHandlers.ErrorStream;
import splice.ga.stopConditions.Generations;

/**
 * Base class for a genetic algorithm
 * @author igor
 *
 */
public class GeneticAlgorithm implements InitializeComponent {
	private int populationSize = 100;
	private double mutationRate = 0.2;
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
	
	/**
	 * Default constructor
	 * @param factory the factory from the initial chromosomes will come
	 * @param allocator the new population allocator
	 * @param selector the crossover candidates selector
	 */
	public GeneticAlgorithm(ChromosomeFactory<?> factory, PopulationAllocator allocator, Selector selector) {
		this.allocator = allocator;
		this.selector = selector;
		this.factory = factory;
	}

	/**
	 * executes the genetic algorithm
	 */
	public void execute() {
		initialize();
		
		double begin = System.currentTimeMillis();
		
		try {
			int i = 1;
			do {
				population.calculateFitnessSum();
				dataManipulator.appendData(i);
				
				allocator.reset();
				selector.beforeGeneration();
				doGeneration(i);
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
     * @param generation current generation, it may be used for some algorithms that do some task at every n-generations
     */
	protected void doGeneration(int generation) {
		BasicChromosome a, b;

		while (!allocator.complete()) {
			a = getChromosome();
			b = getChromosome();

            reproduce(a, b);
            reproduce(b, a);
		}
	}

    private void reproduce(BasicChromosome a, BasicChromosome b) {
        BasicChromosome c = a.crossover(b);
        c.mutate(mutationRate);
        allocator.append(c);
    }

    public void initialize() {
		dataManipulator.setHandler(handler);
		
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

        if (problemType.isUnset())
            problemType.setMaximization();
	}
	
	private void setProblemType(ProblemTypeComponent component) {
		component.setProblemType(problemType);
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

    public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	protected BasicChromosome getChromosome() {
		return selector.getChromosome();
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

	public void setExceptionHandler(ExceptionHandler handler) {
		this.handler = handler;
	}

    protected PopulationAllocator getAllocator() {
        return allocator;
    }

    protected ChromosomeFactory<?> getFactory() {
        return factory;
    }

    /**
	 * With this you can use a predefined chromosome set,
	 * just remember to call this before execute
	 * @param initPopulation initial set for the population
	 */
	public void setInitPopulation(boolean initPopulation) {
		this.initPopulation = initPopulation;
	}

	/**
	 * @return the last execution time in milliseconds
     */
	public double getLastTime() {
		return this.lastTime;
	}
}