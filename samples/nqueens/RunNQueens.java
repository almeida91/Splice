package nqueens;

import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ElitismAllocator;
import splice.ga.selectors.TournamentSelector;
import splice.ga.stopConditions.Generations;

public class RunNQueens {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(new NQueensChromosomeFactory(8), new ElitismAllocator(0.3), new TournamentSelector(5));
		ga.setStopCondition(new Generations(1000));
		ga.execute();
		
		System.out.println(ga.getPopulation().getMaximum());
	}
}
