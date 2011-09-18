import ga.Chromossome;
import ga.RandomUtil;

public class SinChromossome extends Chromossome {
	private double x, y;

	public SinChromossome(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected double fitness() {
		return Math.sin(Math.toRadians(x + y));
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
	public Chromossome crossover(Chromossome genome) {
		return new SinChromossome(x, ((SinChromossome) genome).y);
	}

	@Override
	public String toString() {
		return "value = " + (x + y);
	}

}
