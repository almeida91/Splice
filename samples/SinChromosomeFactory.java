
import ga.BasicChromosome;
import ga.ChromosomeFactory;


public class SinChromosomeFactory extends ChromosomeFactory {

	@Override
	public BasicChromosome getRandomChromosome() {
		return new SinChromosome(getRandom().nextDouble(), getRandom().nextDouble());
	}

}
