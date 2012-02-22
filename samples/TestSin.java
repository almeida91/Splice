
import ga.GeneticAlgorithm;
import ga.allocators.ElitismAllocator;
import ga.selectors.TournamentSelector;
import ga.stopConditions.Generations;

public class TestSin {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(
				new SinChromosomeFactory(),
				new ElitismAllocator(0.3),
				new TournamentSelector(3));
		ga.setStopCondition(new Generations(1000));
		
		double begin = System.currentTimeMillis();
		ga.execute();
		double end = System.currentTimeMillis();
		System.out.println((end - begin) / 1000 + " s");
		System.out.println(ga.getPopulation().getMaximum());
	}
}
