import ga.Chromossome;
import ga.RandomUtil;

public class TestChromossome extends Chromossome {
	long a, b;

	public TestChromossome(long a, long b) {
		this.a = a;
		this.b = b;
	}
	
	public TestChromossome() {
		this(0,0);
	}

	public TestChromossome(int a, int b) {
		this((long) a, (long) b);
	}

	@Override
	protected double fitness() {
		double dist = Math.abs(Math.abs(a) - Math.abs(b));
		return 1 / (dist + 1);
	}

	@Override
	public Chromossome crossover(Chromossome genome) {
		TestChromossome otherGenome = (TestChromossome) genome;
		TestChromossome newGenome = new TestChromossome();

		long r1, r2, l1, l2;

		r1 = a >> 32;
		l1 = a ^ (r1 << 32);
		r2 = otherGenome.a >> 32;
		l2 = otherGenome.a ^ (r2 << 32);

		newGenome.a = l1 ^ r2;

		r1 = b >> 32;
		l1 = b ^ (r1 << 32);
		r2 = otherGenome.b >> 32;
		l2 = otherGenome.b ^ (r2 << 32);

		newGenome.b = l2 ^ r1;

		return newGenome;
	}

	@Override
	public void mutate() {
		if (RandomUtil.getRandom().nextBoolean())
			if (RandomUtil.getRandom().nextBoolean())
				a += 1;
			else
				a -= 1;
		else if (RandomUtil.getRandom().nextBoolean())
			b += 1;
		else
			b -= 1;
	}

	@Override
	public String toString() {
		return "a = " + a + "\nb = " + b + "\nfitness = " + fitness();
	}
}
