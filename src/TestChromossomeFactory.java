import ga.Chromossome;
import ga.ChromossomeFactory;
import ga.RandomUtil;


public class TestChromossomeFactory extends ChromossomeFactory {
	@Override
	public Chromossome getRandomChromossome() {
		return new TestChromossome(RandomUtil.getRandom().nextInt(100),RandomUtil.getRandom().nextInt(100));
	}
}
