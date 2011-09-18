package ga;

public class GenerationData {
	private Chromossome bestChromossome, worstChromossome;
	private Population population;
	private double fitnessAverage;
	private int generation;

	public Chromossome getBestChromossome() {
		return bestChromossome;
	}

	public void setBestChromossome(Chromossome bestChromossome) {
		this.bestChromossome = bestChromossome;
	}

	public Chromossome getWorstChromossome() {
		return worstChromossome;
	}

	public void setWorstChromossome(Chromossome worstChromossome) {
		this.worstChromossome = worstChromossome;
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
