
import ga.Chromosome;
import ga.ChromosomeFactory;
import ga.RandomUtil;


public class SinChromosomeFactory extends ChromosomeFactory {

	@Override
	public Chromosome getRandomChromosome() {
		return new SinChromosome(RandomUtil.getRandom().nextDouble(), RandomUtil.getRandom().nextDouble());
	}

}
