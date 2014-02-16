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

import java.util.Arrays;


public class ProbabilisticTournamentSelector extends Selector {
    private BasicChromosome[] candidates;
    private int size;

    public ProbabilisticTournamentSelector(int size) {
        this.size = size;
    }

    @Override
    public BasicChromosome getChromosome() {
        double sum = 0;
        candidates = new BasicChromosome[size];

        int i;
        for (i = 0; i < size; i++) {
            candidates[i] = getPopulation().getRandomChromosome();
            sum += candidates[i].getFitness();
        }

        Arrays.sort(candidates);

        double aux = 0;
        double limit = RandomUtil.getRandom().nextDouble() * sum;

        for (i = 0; i < size & aux < limit; ++i) {
            aux += candidates[i].getFitness();
        }

        return candidates[i == 0 ? i : i - 1];
    }

    @Override
    public void beforeGeneration() {

    }

    @Override
    public void initialize() throws Exception {
        getProblemType().setMaximization();
    }
}