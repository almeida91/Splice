package ga.parallel;

import ga.Population;

public class CalculateFitnessWorker extends Thread {
	private AtomicDouble sum;
	private Population population;
	private int begin, end;
	
	public CalculateFitnessWorker(Population population, int begin, int end, AtomicDouble sum) {
		this.population = population;
		this.begin = begin;
		this.end = end;
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for (int i = begin; i < end; i++) {
			sum.add(population.get(i).calculateFitness());
		}
	}
	
	public double getSum() {
		return sum.getValue();
	}
}
