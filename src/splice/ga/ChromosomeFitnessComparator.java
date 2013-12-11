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

package splice.ga;

import java.util.Comparator;

/**
 * To be used with sorting algorithms, it should be noted
 * as it is the equals method will only consider the fitness
 * of the given chromosomes. For a value comparison you
 * should use the provided equals() methods
 * @author igor
 *
 */
public class ChromosomeFitnessComparator implements Comparator<BasicChromosome> {
	private double fitness;
	
	public ChromosomeFitnessComparator(double fitness) {
		this.fitness = fitness;
	}
	
	@Override
	public int compare(BasicChromosome o1, BasicChromosome o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Object obj) {
        return obj instanceof BasicChromosome && ((BasicChromosome) obj).getFitness() == fitness;
    }
}
