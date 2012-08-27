import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitismAllocator;
import splice.ga.selectors.MinimizeTournamentSelector;
import splice.ga.stopConditions.Convergence;
import splice.ga.stopConditions.Generations;

public class RunOneZero {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(new OneZeroChromosomeFactory(255), new ElitismAllocator(0.3), new MinimizeTournamentSelector());
		ga.setStopCondition(new Generations(100));
		ga.execute();
		
		System.out.println();
		System.out.println(ga.getPopulation().getMaximum());
		System.out.println(ga.getPopulation().getMinimum());
		System.out.println(ga.getPopulation().getChromosomesSet().size());
	}
}
