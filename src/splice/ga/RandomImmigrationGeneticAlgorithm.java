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

/**
 * @author igor
 */
public class RandomImmigrationGeneticAlgorithm extends GeneticAlgorithm {
    private double immigrationRate = 0.1;
    private int mod, frequency = 100;

    /**
     * Default constructor
     *
     * @param factory   the factory from the initial chromosomes will come
     * @param allocator the new population allocator
     * @param selector  the crossover candidates selector
     */
    public RandomImmigrationGeneticAlgorithm(ChromosomeFactory<?> factory, PopulationAllocator allocator, Selector selector) {
        super(factory, allocator, selector);
    }

    @Override
    public void initialize() throws Exception {
        super.initialize();
        mod = 0;
    }

    @Override
    protected void doGeneration(int i) {
        mod = i % frequency;
        if (mod == 0) {
            for (int j = 0; j < getPopulationSize() * immigrationRate; j++) {
                getAllocator().append(getFactory().generateChromosome());
            }
        }
        super.doGeneration(i);
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getImmigrationRate() {
        return immigrationRate;
    }

    public void setImmigrationRate(double immigrationRate) {
        this.immigrationRate = immigrationRate;
    }
}
