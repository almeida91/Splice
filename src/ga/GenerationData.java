package ga;

/**
 * The information produced in a single generation
 * @author igor
 *
 */
public class GenerationData {
	private Chromosome bestChromosome, worstChromosome;
	private Population population;
	private double fitnessAverage;
	private int generation;

	public Chromosome getBestChromosome() {
		return bestChromosome;
	}

	public void setBestChromosome(Chromosome bestChromosome) {
		this.bestChromosome = bestChromosome;
	}

	public Chromosome getWorstChromosome() {
		return worstChromosome;
	}

	public void setWorstChromosome(Chromosome worstChromosome) {
		this.worstChromosome = worstChromosome;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	public double getFitnessAverage() {
		return fitnessAverage;
	}

	public void setFitnessAverage(double fitnessAverage) {
		this.fitnessAverage = fitnessAverage;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

}
