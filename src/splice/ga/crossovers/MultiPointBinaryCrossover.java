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

import java.math.BigInteger;

import splice.ga.genes.BinaryGene;

public class MultiPointBinaryCrossover extends MaskBinaryCrossover {
	private int parts;
	private int length = 0;

	public MultiPointBinaryCrossover(int points) {
        super(null);

		parts = points + 1;

        if (parts == 0)
            parts = 1;
	}
	
	public void generateMasks() {
        if (length == 0) {
            aMask = BigInteger.ZERO;
            bMask = new BigInteger("2");
            return;
        }

		StringBuilder o1 = new StringBuilder(length),
                      o2 = new StringBuilder(length);

        final char one = '1',
                   zero = '0';

        char c1 = zero,
             c2 = one;

		for (int i = 0; i < length; i++) {
            if ((i % (length / parts)) == 0) {
                if (c1 == one) {
                    c1 = zero;
                    c2 = one;
                }
                else {
                    c1 = one;
                    c2 = zero;
                }
            }

            o1.append(c1);
            o2.append(c2);
		}

        aMask = new BigInteger(o1.toString(), 2);
        bMask = new BigInteger(o2.toString(), 2);
	}



	@Override
	public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
        if (a.getLength() != length) {
            length = a.getLength();
            generateMasks();
        }

		return super.doCrossover(a,b);
	}

}
