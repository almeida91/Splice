/*
 * Copyright (C) 2013 Jean-Michel Bouchard
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
import splice.RandomUtil;

/**
 * Select a chromosone according to Linear Ranking Probability function : N / ( (N * (N+1)) / 2)
 * @author woud
 *
 */
public class LinearRankingSelector extends Selector {
	@Override
	public BasicChromosome getChromosome() {
        // Get population size.
		int i =  getPopulation().getSize();
        double limit = RandomUtil.getRandom().nextGaussian();
        double prob = 0;
        // Assuming population to be sorted.
        for(BasicChromosome individual : getPopulation().getChromosomes())
        {
            prob = linearProbabilityPerRank(i);
            
            if(prob < limit)
                return individual;
            else {
                // Divides the limit by ~2 and recursively re-try until last rank.
                limit -= prob;
                i--;
            }
        }

        // Statistically impossible to reach here but in case, return last one.
        return getPopulation().getChromosomes().get(getPopulation().getSize() - 1 );
	}

	@Override
	public void beforeGeneration() {
        // Make sure population is sorted before selecting.
        getPopulation().sort();
    }
	
	@Override
	public void initialize() { 
        getProblemType().setMaximization();
    }

    /*
     * Private helper method 
     *
     */
    private double linearProbabilityPerRank(int rank) {
        return rank / ( (rank * (rank + 1)) / 2 ); 
    }

}
