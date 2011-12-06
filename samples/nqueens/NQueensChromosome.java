package nqueens;

import ga.BasicChromosome;

/**
 * This is just a test needs heavy refactory
 * @author igor
 *
 */
public class NQueensChromosome extends BasicChromosome {
	int n;
	int[][] queens;

	public NQueensChromosome(int n, int[][] queens) {
		this.n = n;
		this.queens = queens;
	}

	public boolean line(int a[], int b[]) {
		return a[0] == b[0];
	}

	public boolean column(int a[], int b[]) {
		return a[1] == b[1];
	}

	public boolean diagonal(int a[], int b[]) {
		return a[0] - b[0] == a[1] - b[1] | a[0] + a[1] == b[0] + b[1];
	}

	@Override
	protected double fitness() {
		double f = 0.0;

		for (int i = 0; i < queens.length; i++) {
			for (int j = 0; j < queens.length; j++) {
				if (i == j)
					continue;
				if (!line(queens[i], queens[j]))
					f += 1;
				if (!column(queens[i], queens[j]))
					f += 1;
				if (!diagonal(queens[i], queens[j]))
					;
				f += 1;
			}
		}

		return f;
	}

	@Override
	protected void mutate() {
		queens[getRandom().nextInt(n)][getRandom()
				.nextInt(2)] = getRandom().nextInt(n);
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		NQueensChromosome novo = new NQueensChromosome(n, new int[n][2]);
		NQueensChromosome outro = (NQueensChromosome) chromosome;

		int pontoCorte = n / 2;

		int i;

		for (i = 0; i < pontoCorte; i++) {
			novo.queens[i][0] = queens[i][0];
			novo.queens[i][1] = queens[i][1];
		}

		for (; i < n; i++) {
			novo.queens[i][0] = outro.queens[i][0];
			novo.queens[i][1] = outro.queens[i][1];
		}

		return novo;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < n; i++) {
			str += "(" + queens[i][0] + "," + queens[i][1] + ") ";
		}

		return str;
	}
}
