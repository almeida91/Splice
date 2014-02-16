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

package splice.ga.selectors;

import splice.RandomUtil;
import splice.ga.BasicChromosome;
import splice.ga.Selector;


/**
 * Selects a chromosome based on the roulette selection
 * @author igor
 *
 */
public class RouletteSelector extends Selector {
	@Override
	public BasicChromosome getChromosome() {
		int i;
		double aux = 0;
		double limit = RandomUtil.getRandom().nextDouble() * getPopulation().getFitnessSum();

		for (i = 0; i < getPopulation().getSize() & aux < limit; ++i) {
			aux += getPopulation().get(i).getFitness();
		}

		return getPopulation().get(i == 0 ? i : i - 1);
	}

	@Override
	public void beforeGeneration() {
		getPopulation().sort();
	}

	@Override
	public void initialize() {
		getProblemType().setMaximization();
	}
}
