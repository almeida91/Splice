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

public class PartiallyMatchedCrossover<T> implements Crossover<ListGene<T>> {
    private List<T> buff, buff2;
    private int begin, end;

    public PartiallyMatchedCrossover(int begin, int end) {
        assert begin < end;

        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    private void replace(int i, List<T> list, List<T> section1, List<T> section2) {
        int index = section1.indexOf(list.get(i));

        if (index >= 0) {
            T replacement;

            do {
                replacement = section2.get(index);
                index = section1.indexOf(replacement);
            } while (index >= 0);

            list.set(i, replacement);
        }
    }

    @Override
    public ListGene<T> doCrossover(ListGene<T> a, ListGene<T> b) {
        ListGene<T> c = (ListGene<T>) a.clone();

        if (buff2 != null) {
            c.setValue(buff2);
            buff2 = null;
        }
        else {
            buff = new ArrayList<>();
            buff2 = new ArrayList<>();

            buff.addAll(a.getValue());
            buff2.addAll(b.getValue());

            for (int i = begin; i <end; i++) {
                buff.set(i, b.get(i));
                buff2.set(i, a.get(i));
            }

            for (int i = end; i != begin; i++, i %= buff.size()) {
                replace(i, buff, buff.subList(begin, end), buff2.subList(begin, end));
                replace(i, buff2, buff2.subList(begin, end), buff.subList(begin, end));
            }

            c.setValue(buff);
        }

        return c;
    }
}
