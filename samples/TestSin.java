
import ga.GeneticAlgorithm;
import ga.MaxmizeGeneticAlgorithm;
import ga.allocators.ElitismAllocator;
import ga.selectors.TournamentSelector;
import ga.stopConditions.Convergence;

public class TestSin {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new MaxmizeGeneticAlgorithm(
				new SinChromosomeFactory(),
				new ElitismAllocator(0.3),
				new TournamentSelector(3));
		ga.setStopCondition(new Convergence(100,0.9));
		
		ga.execute();
		System.out.println(ga.getBest());
	}
}
