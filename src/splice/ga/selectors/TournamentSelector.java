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

import splice.ga.BasicChromosome;
import splice.ga.Selector;


/**
 * Selects a chromosome using a k-sized deterministic tournament
 *
 * @author igor
 */
public class TournamentSelector extends Selector {
    private int k;

    /**
     * @param size the tournament size
     */
    public TournamentSelector(int size) {
        k = size;
    }

    @Override
    public BasicChromosome getChromosome() {
        BasicChromosome chromosome = getPopulation().getRandomChromosome(), temp;

        if (getProblemType().isMaximization()) {
            for (int i = 0; i < k - 1; i++) {
                temp = getPopulation().getRandomChromosome();

                if (temp.getFitness() > chromosome.getFitness()) {
                    chromosome = temp;
                }
            }
        }

        if (getProblemType().isMinimization()) {
            for (int i = 0; i < k - 1; i++) {
                temp = getPopulation().getRandomChromosome();

                if (temp.getFitness() < chromosome.getFitness()) {
                    chromosome = temp;
                }
            }
        }

        return chromosome;
    }

    @Override
    public void beforeGeneration() {
    }

    @Override
    public void initialize() {
        if (getProblemType().isUnset()) {
            getProblemType().setMaximization();
        }
    }
}
