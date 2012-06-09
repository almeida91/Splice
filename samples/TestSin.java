
import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitismAllocator;
import splice.ga.dataManipulators.GenerationPopulationOutput;
import splice.ga.selectors.TournamentSelector;
import splice.ga.stopConditions.Generations;

public class TestSin {
	public static void main(String[] args) throws Exception {
		GeneticAlgorithm ga = new GeneticAlgorithm(
				new SinChromosomeFactory(),
				new ElitismAllocator(0.3),
				new TournamentSelector(3));
		ga.setStopCondition(new Generations(1000));
		ga.setDataManipulator(new GenerationPopulationOutput("/Users/igor/test"));
		
		double begin = System.currentTimeMillis();
		ga.execute();
		double end = System.currentTimeMillis();
		System.out.println((end - begin) / 1000 + " s");
		System.out.println(ga.getPopulation().getMaximum());
	}
}
