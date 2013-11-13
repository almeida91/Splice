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

package splice.ga.crossovers;

import splice.RandomUtil;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

/**
 * @author igor
 */
public class UniformBinaryCrossover extends MaskBinaryCrossover {
    private int length = 0;

    public UniformBinaryCrossover() {
        super(null);
    }

    private void generateMasks() {
        StringBuilder o1 = new StringBuilder(length),
                      o2 = new StringBuilder(length);

        final char one = '1',
                   zero = '0';

        for (int i = 0; i < length; i++) {
            if (RandomUtil.getRandom().nextBoolean()) {
                o1.append(one);
                o2.append(zero);
            }
            else {
                o1.append(zero);
                o2.append(one);
            }
        }

        aMask = new BigInteger(o1.toString(), 2);
        bMask = new BigInteger(o2.toString(), 2);
    }

    @Override
    public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
        /*
         * this logic defines when reset the crossover mask
         * if length is set to zero, then it is the first chromosome of the pair
         * else it is the second, so no mask needs to be generated and the length is again set to zero for the next
         * chromosome pair
         */
        if (length == 0) {
            length = a.getLength();
            generateMasks();
        } else {
            length = 0;
        }


        return super.doCrossover(a, b);
    }
}
