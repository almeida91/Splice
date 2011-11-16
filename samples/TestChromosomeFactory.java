
import ga.Chromosome;
import ga.ChromosomeFactory;
import ga.RandomUtil;


public class TestChromosomeFactory extends ChromosomeFactory {
	@Override
	public Chromosome getRandomChromosome() {
		return new TestChromosome(RandomUtil.getRandom().nextInt(100),RandomUtil.getRandom().nextInt(100));
	}
}
