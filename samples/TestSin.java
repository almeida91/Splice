
import ga.GeneticAlgorithm;
import ga.MaxmizeGeneticAlgorithm;
import ga.allocators.ElitismAllocator;
import ga.parallel.ParallelPopulation;
import ga.selectors.TournamentSelector;
import ga.stopConditions.Convergence;
import ga.stopConditions.Generations;

public class TestSin {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new MaxmizeGeneticAlgorithm(
				new SinChromosomeFactory(),
				new ElitismAllocator(0.3),
				new TournamentSelector(3));
		ga.setStopCondition(new Generations(1000));
		
		double begin = System.currentTimeMillis();
		ga.execute();
		double end = System.currentTimeMillis();
		System.out.println(ga.getBest());
		System.out.println((end - begin) / 1000 + " s");
	}
}
