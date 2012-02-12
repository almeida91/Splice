package ga;

/**
 * This genetic algorithm maximizes the a fitness function 
 * @author igor
 *
 */
public class MaxmizeGeneticAlgorithm extends GeneticAlgorithm {
	public MaxmizeGeneticAlgorithm(ChromosomeFactory factory,
			PopulationAllocator allocator, MaxmizeSelector selector) {
		super(factory, allocator, selector);
	}
	
	@Override
	public BasicChromosome getBest() {
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

	@Override
	public BasicChromosome getWorst() {
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
}
