
import ga.GeneticAlgorithm;
import ga.MaxmizeGeneticAlgorithm;
import ga.allocators.ReplaceAllocator;
import ga.selectors.TournamentSelector;
import ga.stopConditions.MinimumBestFitnessCondition;

public class Test {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new MaxmizeGeneticAlgorithm(
				new TestChromosomeFactory(),
				new ReplaceAllocator(), 
				new TournamentSelector(3));
		ga.setStopCondition(new MinimumBestFitnessCondition(1.0));
		ga.execute();
		System.out.println(ga.getBest());
		System.out.println(ga.getWorst());
		/*
		 * TestGenome g = new TestGenome(); for (int i = 0; i < 10; i++) {
		 * g=(TestGenome)g.getRandomGenome(); System.out.println(g); }
		 */
	}
}