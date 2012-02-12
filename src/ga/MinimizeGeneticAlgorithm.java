package ga;

public class MinimizeGeneticAlgorithm extends GeneticAlgorithm {
	public MinimizeGeneticAlgorithm(ChromosomeFactory factory,
			PopulationAllocator allocator, MinimizeSelector selector) {
		super(factory, allocator, selector);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BasicChromosome getBest() {
		BasicChromosome chromosome = getPopulation().getRandomChromosome();
		double fitness = chromosome.getFitness();
		for (BasicChromosome g : getPopulation().getChromosomes()) {
			if (g.getFitness() <= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}

	@Override
	public BasicChromosome getWorst() {
		double fitness = 0;
		BasicChromosome chromosome = null;
		for (BasicChromosome g : getPopulation().getChromosomes()) {
			if (g.getFitness() >= fitness) {
				fitness = g.getFitness();
				chromosome = g;
			}
		}
		return chromosome;
	}

}
