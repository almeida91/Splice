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

import splice.InitializeComponent;
import splice.RandomUtil;

/**
 * Base class for chromosomes, it doesn't support the mutator/crossover
 * interfaces. You may find it easier to customize the behavior of a single
 * individual using this class as you have to implement by yourself the logic
 * behind the crossover and mutation. It is also good when you need a better
 * performance as it makes fewer abstractions than its derivatives.
 * Besides the fitness value, by default no other
 * value is hold by this class.
 * 
 * @author Igor Almeida
 * 
 */
public abstract class BasicChromosome implements Comparable<BasicChromosome>, InitializeComponent, Cloneable {
	double fitness = Double.MIN_VALUE;
    private long fitnessBits;
	private boolean calculated = false;

	/**
	 * Implementation of the fitness function
	 * 
	 * @return the fitness for the chromosome
	 */
    protected abstract double fitness();

	/**
	 * Implementation of the chromosome's mutation logic
	 */
	protected abstract void mutate();

	/**
	 * Performs the chromosome's crossover with a given chromosome
	 * 
	 * @param chromosome other chromosome to make crossover with
	 * @return one child of the crossover operation
	 */
	public abstract BasicChromosome crossover(BasicChromosome chromosome);

    public BasicChromosome clone() {
        try {
            return (BasicChromosome)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

	/**
	 * Calculate the chromosome's fitness
	 * @return fitness value as calculated by #{fitness()}
	 */
	public final double calculateFitness() {
		if (calculated)
			return fitness;

        fitness = fitness();

		// checks if is a NaN
		if (fitness != fitness)
			throw new NumberFormatException("The fitness can't be a NaN");

        fitnessBits = Double.doubleToLongBits(fitness);
		calculated = true;

		return fitness;
	}

	public double getFitness() {
		return fitness;
	}

    public long getFitnessBits() {
        return fitnessBits;
    }

    public void resetFitness() {
        fitness = Double.MIN_VALUE;
    }
	
	@Override
	public void initialize() { }

	@Override
	public int compareTo(BasicChromosome o) {
		if (fitness == o.fitness)
			return 0;
		if (fitness > o.fitness)
			return 1;
		return -1;
	}

	public Comparator<BasicChromosome> getComparator() {
		return new ChromosomeFitnessComparator(fitness);
	}

	/**
	 * Mutates the chromosome with a given probability
	 * @param chance the probability of mutation
	 */
	public void mutate(double chance) {
		if (RandomUtil.getRandom().nextDouble() < chance)
			mutate();
	}

    public String toString() {
        return Double.toString(fitness());
    }
}
