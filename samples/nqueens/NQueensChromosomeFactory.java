package nqueens;

import splice.ga.BasicChromosome;
import splice.ga.ChromosomeFactory;

public class NQueensChromosomeFactory extends ChromosomeFactory {
	private int n;

	public NQueensChromosomeFactory(int n) {
		this.n = n;
	}

	@Override
	public BasicChromosome getRandomChromosome() {
		int[][] queens = new int[n][2];

		for (int i = 0; i < n; i++) {
			queens[i][0] = getRandom().nextInt(n);
			queens[i][1] = getRandom().nextInt(n);
		}

		return new NQueensChromosome(n, queens);
	}

}
