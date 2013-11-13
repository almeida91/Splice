/*
 * Copyright (C) 2012 Igor de Almeida
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

import splice.RandomUtil;
import splice.ga.BasicChromosome;

public class SinChromosome extends BasicChromosome {
	private double x, y;

	public SinChromosome(double x, double y) {
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
	public BasicChromosome crossover(BasicChromosome chromossome) {
		return new SinChromosome(x, ((SinChromosome) chromossome).y);
	}

	@Override
	public String toString() {
		return "value = " + (x + y);
	}

}
