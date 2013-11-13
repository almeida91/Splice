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

package splice.cga;

import splice.RandomUtil;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

/**
 * Holds the probability for each bit in the chromosome
 */
public class ProbabilityVector {
    private double[][] vectors;
    private int popSize;
    private int[] sizes;

    /**
     * Creates a default probability vector
     *
     * @param size the array size
     * @return an array that all values are 0.5
     */
    private double[] fillProbabilities(int size) {
        double v[] = new double[size];

        for (int i = 0; i < size; i++) {
            v[i] = 0.5f;
        }

        return v;
    }

    public ProbabilityVector(int[] sizes, int populationSize) {
        this.sizes = sizes;
        this.vectors = new double[sizes.length][];
        this.popSize = populationSize;
        for (int i = 0; i < sizes.length; i++) {
            vectors[i] = fillProbabilities(sizes[i]);
        }
    }

    /**
     *
     * @param size the solution size in bits
     * @param populationSize the size of the population
     */
    public ProbabilityVector(int size, int populationSize) {
        this(new int[]{size}, populationSize);
    }

    /**
     * Updates the probabilities based on the result of the generation
     *
     * @param winner the chromosome that has the higher fitness in the pair
     * @param loser the lower fitness in the pair
     * @param vectorPos which vector should be updated
     */
    public void update(BinaryGene winner, BinaryGene loser, int vectorPos) {
        boolean w, l;

        for (int i = 0; i < sizes[vectorPos]; i++) {
            w = winner.getValue().testBit(i);
            l = loser.getValue().testBit(i);

            if (w != l) {
                if (w)
                    vectors[vectorPos][i] += 1.0 / popSize;
                else
                    vectors[vectorPos][i] -= 1.0 / popSize;
            }
        }
    }

    public void update(BinaryGene[] winner, BinaryGene[] loser) {
        for (int i = 0; i < winner.length; i++) {
            update(winner[i], loser[i], i);
        }
    }

    /**
     * Generates a gene based on the current probabilities
     *
     * @return a gene where each bit is chosen random by the given probability
     */
    public BinaryGene generateGene(int vectorPos) {
        BigInteger bigInt = new BigInteger(sizes[vectorPos], RandomUtil.getRandom());

        for (int i = 0; i < sizes[vectorPos]; i++) {
            if (RandomUtil.getRandom().nextDouble() < vectors[vectorPos][i])
                bigInt = bigInt.setBit(i);
        }

        return new BinaryGene(bigInt);
    }

    public BinaryGene[] generateGenes() {
        BinaryGene[] g = new BinaryGene[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            g[i] = generateGene(i);
        }

        return g;
    }
}
