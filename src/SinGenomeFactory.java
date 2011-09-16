import ga.Genome;
import ga.GenomeFactory;
import ga.RandomUtil;


public class SinGenomeFactory extends GenomeFactory {

	@Override
	public Genome getRandomGenome() {
		return new SinGenome(RandomUtil.getRandom().nextDouble(), RandomUtil.getRandom().nextDouble());
	}

}
