package ga;

import ga.dataManipulators.ConsoleOutput;

import java.io.PrintStream;
import java.util.ArrayList;

public abstract class GeneticAlgorithm {
	private int pSize = 100;
	private int gSize = 2000;
	private double mRate = 0.2;
	private double cRate = 0.8;

	private double fitnessSum;

	private Population population;

	private Selector selector;
	private PopulationAllocator allocator;

	private ChromossomeFactory factory;

	private DataManipulator manipulator = new ConsoleOutput();
	
	private PrintStream errorStream = System.err;

	public GeneticAlgorithm(ChromossomeFactory factory,
			PopulationAllocator allocator, Selector selector) {
		this.allocator = allocator;
		this.selector = selector;
		this.factory = factory;
	}

	/**
	 * 
	 * @return the new genomes to be added to the population
	 */
	protected abstract ArrayList<Chromossome> doGeneneration();
	public abstract Chromossome getBest();
	public abstract Chromossome getWorst();

	/**
	 * executes the genetic algorithm
	 */
	public void execute() {
		population = new Population(gSize, factory);
		population.initializePopulation();

		GenerationData data = new GenerationData();

		try {
			for (int i = 0; i < gSize; i++) {
				allocator.setPopulation(population);
				selector.setPopulation(population);

				population.calculateFitnessSum();
				allocator.alocate(doGeneneration());

				data.setPopulation(population);
				data.setBestChromossome(getBest());
				data.setWorstChromossome(getWorst());
				data.setGeneration(i);
				data.setFitnessAverage(population.getFitnessAverage());

				manipulator.appendData(data);
			}
			manipulator.saveData();
		} catch (Exception ex) {
			errorStream.println("Some errors have ocurred that prevented the execution");
			ex.printStackTrace(errorStream);
		}
	}

	public int getPopulationSize() {
		return pSize;
	}

	public int getGenerationSize() {
		return gSize;
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

	protected Chromossome getChromossome() {
		return selector.getChromossome();
	}

	protected void mutate(Chromossome g) {
		g.mutate(mRate);
	}

	public void setGenerationSize(int size) {
		gSize = size;
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
}
