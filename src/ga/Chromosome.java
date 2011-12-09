package ga;

@SuppressWarnings("rawtypes")
public abstract class Chromosome extends BasicChromosome {
	private Gene[] genes;
	private Crossover[] crossovers;
	private Mutator[] mutators;

	@SuppressWarnings("unchecked")
	@Override
	protected void mutate() {
		for (int i = 0; i < genes.length; i++) {
			mutators[i].mutate(genes[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		Chromosome newChromsome = null;
		Chromosome other = (Chromosome)chromosome;
		
		try {
			newChromsome = this.getClass().newInstance();
		} catch (Exception ex) { }
		
		newChromsome.crossovers = crossovers;
		newChromsome.mutators = mutators;
		newChromsome.genes = new Gene[genes.length];
		
		for (int i = 0; i < genes.length; i++) {
			newChromsome.genes[i] = this.crossovers[i].doCrossover(this.genes[i], other.genes[i]);
		}
		
		return null;
	}

}
