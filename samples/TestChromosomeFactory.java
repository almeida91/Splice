
import ga.Chromosome;
import ga.ChromosomeFactory;


public class TestChromosomeFactory extends ChromosomeFactory {
	@Override
	public Chromosome getRandomChromosome() {
		return new TestChromosome(getRandom().nextInt(100),getRandom().nextInt(100));
	}
}
