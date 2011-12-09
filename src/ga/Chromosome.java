package ga;

public abstract class Chromosome extends BasicChromosome {
	private Gene[] genes;
	private Crossover[] crossovers;
	private Mutator[] mutators;

	@Override
	protected void mutate() {
		for (int i = 0; i < genes.length; i++) {
			mutators[i].mutate(genes[i]);
		}
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		// TODO Auto-generated method stub
		return null;
	}

}
