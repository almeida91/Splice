import ga.Genome;
import ga.RandomUtil;

public class SinGenome extends Genome {
	private double x, y;

	public SinGenome(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public double calculateFitness() {
		return fitness = Math.sin(Math.toRadians(x + y));
	}

	@Override
	protected void mutate() {
		if (RandomUtil.getRandom().nextBoolean())
			if (RandomUtil.getRandom().nextBoolean())
				y -= 0.1;
			else
				y += 0.1;
		else if (RandomUtil.getRandom().nextBoolean())
			x -= 0.1;
		else
			x += 0.1;
	}

	@Override
	public Genome crossover(Genome genome) {
		return new SinGenome(x, ((SinGenome) genome).y);
	}

	@Override
	public String toString() {
		return "value = " + (x + y);
	}

}
