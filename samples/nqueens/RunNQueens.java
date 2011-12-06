package nqueens;

import ga.MaxmizeGeneticAlgorithm;
import ga.allocators.ElitismAllocator;
import ga.selectors.TournamentSelector;

public class RunNQueens {
	public static void main(String[] args) {
		MaxmizeGeneticAlgorithm ga = new MaxmizeGeneticAlgorithm(new NQueensChromosomeFactory(8), new ElitismAllocator(0.3), new TournamentSelector(5));
		ga.execute();
		System.out.println(ga.getBest());
	}
}
