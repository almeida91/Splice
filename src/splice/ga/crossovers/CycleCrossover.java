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

import splice.ga.Crossover;
import splice.ga.genes.ListGene;

import java.util.ArrayList;
import java.util.List;

public class CycleCrossover<T> implements Crossover<ListGene<T>> {
    private int index;
    private List<T> tour1 ,tour2;

    public CycleCrossover(int index) {
        this.index = index;
    }

    @Override
    public ListGene<T> doCrossover(ListGene<T> a, ListGene<T> b) {
        ListGene<T> c = (ListGene<T>) a.clone();

        if (tour2 != null) {
            c.setValue(tour2);
            tour2 = null;
        }
        else {
            tour1 = new ArrayList<>(a.getValue());
            tour2 = new ArrayList<>(b.getValue());

            List<Integer> cycleIndices = new ArrayList<>();

            cycleIndices.add(index);

            T tour2city = tour2.get(index);

            do {
                index = tour1.indexOf(tour2city);
                cycleIndices.add(index);
                tour2city = tour2.get(index);
            } while (index != cycleIndices.get(0));

            for (int i : cycleIndices) {
                tour1.set(i, b.get(i));
                tour2.set(i, a.get(i));
            }

            c.setValue(tour1);
        }

        return c;
    }
}
