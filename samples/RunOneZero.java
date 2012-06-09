import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitismAllocator;
import splice.ga.selectors.MinimizeTournametSelector;
import splice.ga.stopConditions.Convergence;
import splice.ga.stopConditions.Generations;

public class RunOneZero {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(new OneZeroChromosomeFactory(Integer.MAX_VALUE), new ElitismAllocator(0.3), new MinimizeTournametSelector());
		ga.setStopCondition(new Generations(100));
		ga.execute();
		
		System.out.println();
		System.out.println(ga.getPopulation().getMaximum());
		System.out.println(ga.getPopulation().getMinimum());
	}
}
