package ga;

import ga.dataManipulators.ConsoleOutput;
import ga.stopConditions.Generations;

import java.io.PrintStream;
import java.util.Random;

/**
 * Base class for a genetic algorithm
 * @author igor
 *
 */
public abstract class GeneticAlgorithm implements RandomComponent {
	private int pSize = 100;
	private double mRate = 0.2;
	private double cRate = 1;

	private double fitnessSum;

	private Population population;

	private Selector selector;
	private PopulationAllocator allocator;

	private ChromosomeFactory factory;
	private DataManipulator manipulator = new ConsoleOutput();
	private StopCondition stopCondition = new Generations(2000);
	
	private PrintStream errorStream = System.err;
	
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
	 * @return the population's best chromosome
	 */
	public abstract BasicChromosome getBest();
	/**
	 * @return the population's worst chromosome
	 */
	public abstract BasicChromosome getWorst();

	/**
	 * executes the genetic algorithm
	 */
	public void execute() {
		setRandomGenerator(selector);
		setRandomGenerator(allocator);
		setRandomGenerator(factory);
		
		factory.initialize();
		
		population = new Population(pSize, factory);
		setRandomGenerator(population);
		population.initialize();

		GenerationData data = new GenerationData();
		
		allocator.setPopulation(population);
		selector.setPopulation(population);
		
		try {
			int i = 0;
			do {
				population.calculateFitnessSum();
				
				data.setPopulation(population);
				data.setBestChromosome(getBest());
				data.setWorstChromosome(getWorst());
				data.setGeneration(i);
				data.setFitnessAverage(population.getFitnessAverage());

				allocator.reset();
				doGeneneration();
				allocator.allocate();
				
				manipulator.appendData(data);
				
				i++;
			} while (!stopCondition.stop(data));
			manipulator.saveData();
			population.calculateFitnessSum();
		} catch (Exception ex) {
			errorStream.println("Some errors have ocurred that prevented the execution");
			ex.printStackTrace(errorStream);
		}
	}
	
	protected void doGeneneration() {
		BasicChromosome a, b, c;

		getPopulation().sort();

		for (int i = 0; i < getPopulationSize(); i++) {
			a = getChromosome();
			b = getChromosome();
			c = crossover(a, b);
			mutate(c);
			getAllocator().append(c);

			if (getRandom().nextDouble() < getCrossoverRate()) {
				c = crossover(a, b);
				mutate(c);
				getAllocator().append(c);
				i++;
			}
		}
	}

	private void setRandomGenerator(RandomComponent component) {
		component.setRandom(random);
	}

	public int getPopulationSize() {
		return pSize;
	}

	public double getMutationRate() {
		return mRate;
	}

	public double getCrossoverRate() {
		return cRate;
	}

	protected double getFitnessSum() {
		return fitnessSum;
	}

	protected void setFitnessSum(double fitnessSum) {
		this.fitnessSum = fitnessSum;
	}

	protected Population getPopulation() {
		return population;
	}

	protected void setPopulation(Population population) {
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

	public void setCrossoverRate(double rate) {
		cRate = rate;
	}

	public void setDataManipulator(DataManipulator dataManipulator) {
		manipulator = dataManipulator;
	}

	public PrintStream getErrorStream() {
		return errorStream;
	}

	public void setErrorStream(PrintStream errorStream) {
		this.errorStream = errorStream;
	}

	public StopCondition getStopCondition() {
		return stopCondition;
	}

	public void setStopCondition(StopCondition stopCondition) {
		this.stopCondition = stopCondition;
	}

	public PopulationAllocator getAllocator() {
		return allocator;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
}
