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

package splice.ga.genes;

import java.util.*;

import splice.RandomUtil;
import splice.ga.Gene;

/**
 * 
 * @author igor
 *
 * @param <T>
 */
public class ListGene<T> extends Gene<List<T>> {
    private Set<T> set;
    private int itemsFromSet;
    private boolean unique = true;

	public ListGene(List<T> value) {
		super(value);
	}

    public ListGene(Set<T> set, int itemsFromSet, boolean unique) {
        super(null);
        this.set = set;
        this.itemsFromSet = itemsFromSet;
        this.unique = unique;
    }

    public ListGene(Set<T> set) {
        this(set, set.size(), true);
    }

    public T get(int i) {
		return getValue().get(i);
	}
	
	public void set(int i, T value) {
		getValue().set(i, value);
	}
	
	public int getSize() {
		return getValue().size();
	}

    public boolean hasSet() {
        return set != null;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public void initialize() {
        if (hasSet()) {
            List<T> listFromSet = new ArrayList<>(set.size());
            listFromSet.addAll(set);

            if (unique) {
                assert itemsFromSet <= set.size();

                Collections.shuffle(listFromSet, RandomUtil.getRandom());
                setValue(listFromSet);

                int remove = set.size() - itemsFromSet;

                if (itemsFromSet < set.size()) {
                    for (int i = 0; i < remove; i++) {
                        getValue().remove(0);
                    }
                }
            }
            else {
                Random random = RandomUtil.getRandom();
                setValue(new ArrayList<T>(itemsFromSet));

                for (int i = 0; i < itemsFromSet; i++) {
                    getValue().add(listFromSet.get(random.nextInt(set.size())));
                }
            }
        }
    }
}
