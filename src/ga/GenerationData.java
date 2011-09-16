package ga;

public class GenerationData {
	private Genome bestGenome, worstGenome;
	private Population population;
	private double fitnessAverage;
	private int generation;

	public Genome getBestGenome() {
		return bestGenome;
	}

	public void setBestGenome(Genome bestGenome) {
		this.bestGenome = bestGenome;
	}

	public Genome getWorstGenome() {
		return worstGenome;
	}

	public void setWorstGenome(Genome worstGenome) {
		this.worstGenome = worstGenome;
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
