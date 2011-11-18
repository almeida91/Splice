
import ga.Chromosome;
import ga.ChromosomeFactory;


public class SinChromosomeFactory extends ChromosomeFactory {

	@Override
	public Chromosome getRandomChromosome() {
		return new SinChromosome(getRandom().nextDouble(), getRandom().nextDouble());
	}

}
