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

package splice.cga.dataFormatters;

import splice.cga.CgaDataFormatter;

/**
 * Similar to {@link splice.ga.dataFormatters.LabeledGeneration} but to {@link splice.cga.CompactGeneticAlgorithm}
 */
public class LabeledIteration extends CgaDataFormatter {
    private StringBuilder builder = new StringBuilder();

    public String doFormat(int iteration) {
        builder.append("Generation #")
        .append(Integer.toString(iteration))
        .append(" winner: ")
        .append(Double.toString(getWinnerFitness()))
        .append(" loser: ")
        .append(Double.toString(getLoserFitness()))
        .append(" best: ")
        .append(Double.toString(getBestFitness()))
        .append("\n");

        String ret = builder.toString();
        builder.delete(0, builder.length());

        return ret;
    }
}
