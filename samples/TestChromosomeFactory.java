
import ga.BasicChromosome;
import ga.ChromosomeFactory;


public class TestChromosomeFactory extends ChromosomeFactory {
	@Override
	public BasicChromosome getRandomChromosome() {
		return new TestChromosome(getRandom().nextInt(100),getRandom().nextInt(100));
	}
}
