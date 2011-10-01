package ga;

import ga.dataManipulators.ConsoleOutput;
import ga.stopConditions.GenerationsCondition;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Base class for a genetic algorithm
 * @author igor
 *
 */
public abstract class GeneticAlgorithm {
	private int pSize = 100;
	private double mRate = 0.2;
	private double cRate = 0.8;

	private double fitnessSum;

	private Population population;

	private Selector selector;
	private PopulationAllocator allocator;

	private ChromosomeFactory factory;
	private DataManipulator manipulator = new ConsoleOutput();
	private StopCondition stopCondition = new GenerationsCondition(2000);
	
	private PrintStream errorStream = System.err;

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
	 * Executes a single generation logic
	 * @return the new genomes to be added to the population
	 */
	protected abstract ArrayList<Chromosome> doGeneneration();
	/**
	 * @return the population's best chromosome
	 */
	public abstract Chromosome getBest();
	/**
	 * @return the population's worst chromosome
	 */
	public abstract Chromosome getWorst();

	/**
	 * executes the genetic algorithm
	 */
	public void execute() {
		population = new Population(pSize, factory);
		population.initializePopulation();

		GenerationData data = new GenerationData();

		try {
			int i = 0;
			do {
				allocator.setPopulation(population);
				selector.setPopulation(population);

				population.calculateFitnessSum();
				allocator.allocate(doGeneneration());

				data.setPopulation(population);
				data.setBestChromosome(getBest());
				data.setWorstChromosome(getWorst());
				data.setGeneration(i);
				data.setFitnessAverage(population.getFitnessAverage());

				manipulator.appendData(data);
				i++;
			} while (!stopCondition.stop(data));
			manipulator.saveData();
		} catch (Exception ex) {
			errorStream.println("Some errors have ocurred that prevented the execution");
			ex.printStackTrace(errorStream);
		}
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

	protected Chromosome getChromosome() {
		return selector.getChromosome();
	}

	protected void mutate(Chromosome g) {
		g.mutate(mRate);
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
}
