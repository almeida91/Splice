import ga.Genome;
import ga.GenomeFactory;
import ga.RandomUtil;


public class TestGenomeFactory extends GenomeFactory {
	@Override
	public Genome getRandomGenome() {
		return new TestGenome(RandomUtil.getRandom().nextInt(100),RandomUtil.getRandom().nextInt(100));
	}
}
