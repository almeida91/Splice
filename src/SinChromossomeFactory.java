import ga.Chromossome;
import ga.ChromossomeFactory;
import ga.RandomUtil;


public class SinChromossomeFactory extends ChromossomeFactory {

	@Override
	public Chromossome getRandomChromossome() {
		return new SinChromossome(RandomUtil.getRandom().nextDouble(), RandomUtil.getRandom().nextDouble());
	}

}
