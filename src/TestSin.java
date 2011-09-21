import ga.GeneticAlgorithm;
import ga.MaxmizeGeneticAlgorithm;
import ga.allocators.ReplaceAllocator;
import ga.selectors.TournamentSelector;


public class TestSin {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new MaxmizeGeneticAlgorithm(new SinChromosomeFactory(), new ReplaceAllocator(), new TournamentSelector(3));
		ga.setGenerationSize(10000);
		ga.execute();
		System.out.println(ga.getBest());
	}
}
