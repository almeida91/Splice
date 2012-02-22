package nqueens;

import ga.GeneticAlgorithm;
import ga.allocators.ElitismAllocator;
import ga.selectors.TournamentSelector;

public class RunNQueens {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(new NQueensChromosomeFactory(8), new ElitismAllocator(0.3), new TournamentSelector(5));
		ga.execute();
		System.out.println(ga.getPopulation().getMaximum());
	}
}
