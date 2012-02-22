
import ga.GeneticAlgorithm;
import ga.allocators.ElitismAllocator;
import ga.allocators.ReplaceAllocator;
import ga.selectors.TournamentSelector;
import ga.stopConditions.Generations;
import ga.stopConditions.MinimumBestFitness;

public class Test {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(
				new TestChromosomeFactory(),
				new ElitismAllocator(0.3), 
				new TournamentSelector(3));
		ga.setStopCondition(new Generations(100));
		ga.execute();
		/*
		 * TestGenome g = new TestGenome(); for (int i = 0; i < 10; i++) {
		 * g=(TestGenome)g.getRandomGenome(); System.out.println(g); }
		 */
		System.out.println(ga.getPopulation().getMaximum());
	}
}
