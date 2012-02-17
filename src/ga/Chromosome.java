package ga;

@SuppressWarnings("rawtypes")
public abstract class Chromosome extends BasicChromosome {
	private Gene[] genes;
	private Crossover<Gene>[] crossovers;
	private Mutator<Gene>[] mutators;
	
	protected abstract Chromosome getNew();
	
	public Chromosome(Gene[] genes, Crossover<Gene>[] crossovers, Mutator<Gene>[] mutators) {
		this.genes = genes;
		this.crossovers = crossovers;
		this.mutators = mutators;
	}
	
	public Gene get(int i) {
		return genes[i];
	}
	
	@Override
	protected void mutate() {
		for (int i = 0; i < genes.length; i++) {
			mutators[i].mutate(genes[i]);
		}
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		Chromosome newChromsome = getNew();
		Chromosome other = (Chromosome)chromosome;
		
		newChromsome.crossovers = crossovers;
		newChromsome.mutators = mutators;
		newChromsome.genes = new Gene[genes.length];
		
		for (int i = 0; i < genes.length; i++) {
			newChromsome.genes[i] = this.crossovers[i].doCrossover(this.genes[i], other.genes[i]);
		}
		
		return null;
	}

}
