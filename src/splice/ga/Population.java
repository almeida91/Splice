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

import java.util.*;

import splice.InitializeComponent;

/**
 * The chromosome's collection
 *
 * @author igor
 */
public class Population implements InitializeComponent {
    /**
     * this contains all the chromosomes
     */
    private ArrayList<BasicChromosome> chromosomes;
    /**
     * the sum of all fitnesses it's used in roulette selection and in the average calculation
     */
    protected double fitnessSum;
    /**
     * population's average fitness
     */
    protected double fitnessAverage;
    /**
     * population's size
     */
    private int size;
    /**
     * the factory to fill the initial population
     */
    private ChromosomeFactory<?> factory;

    private boolean sorted = false;

    private Random random;

    /**
     * Calculates the chromosome's fitness as well their averages
     *
     * @throws Exception to be used when you have some kind of complex fitness function that throws something
     *                   so the exception will be propagated
     */
    public void calculateFitnessSum() throws Exception {
        calculateFitnessSum(true);
    }
    
    public void calculateFitnessSum(boolean precise) throw Exception {
        int size = precise ? chromosomes.size() : chromosomes.size() / 3;
        
        fitnessSum = 0;
        for (int i = 0; i < size; i++) {
            fitnessSum += chromosomes.get(i).calculateFitness();
        }
        
        if (!precise) {
            fitnessSum *= 3;
        }
        
        fitnessAverage = fitnessSum / chromosomes.size();
    }

    public void initialize() {
        chromosomes = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            chromosomes.add(i, factory.generateChromosome());
        }
    }

    /**
     * Sorts the population based on the chromosome's comparator.
     *
     */
    public void sort() {
        if (sorted)
            return;

//        int N = chromosomes.size();
//        BasicChromosome[] aux = new BasicChromosome[N];
//
//        for (int n = 1; n < N; n *= 2) {
//            for (int i = 0; i < N - n; i += n + n) {
//                int hi = Math.min(i + n + n - 1, N - 1);
//
//                for (int k = i; k <= hi; k++) {
//                    aux[k] = chromosomes.get(k);
//                }
//
//                // merge
//                int x = i, y = i + n;
//                for (int k = i; k <= hi; k++) {
//                    if (!(y > hi) && aux[y].fitness < aux[x].fitness) {
//                        chromosomes.set(k, aux[y++]);
//                    } else {
//                        chromosomes.set(k, aux[x++]);
//                    }
//                }
//            }
//        }

        Collections.sort(chromosomes);

        sorted = true;
    }

    /**
     * Searches the chromosome with highest fitness value
     *
     * @return the chromosome with maximum fitness
     */
    public BasicChromosome getMaximum() {
        if (sorted)
            return chromosomes.get(chromosomes.size() - 1);

        double fitness = 0;
        BasicChromosome chromosome = null;
        for (BasicChromosome g : chromosomes) {
            if (g.getFitness() >= fitness) {
                fitness = g.getFitness();
                chromosome = g;
            }
        }
        return chromosome;
    }

    /**
     * Searches the chromosome with the population's lowest fitness
     *
     * @return the chromosome with minimum fitness
     */
    public BasicChromosome getMinimum() {
        if (sorted)
            return chromosomes.get(0);

        BasicChromosome chromosome = getRandomChromosome();
        double fitness = chromosome.getFitness();
        for (BasicChromosome g : chromosomes) {
            if (g.getFitness() <= fitness) {
                fitness = g.getFitness();
                chromosome = g;
            }
        }
        return chromosome;
    }

    /**
     * @return the chromosome's collection
     */
    public ArrayList<BasicChromosome> getChromosomes() {
        return chromosomes;
    }

    public void setChromosomes(ArrayList<BasicChromosome> x) {
        this.chromosomes = x;
    }

    public Set<BasicChromosome> getChromosomesSet() {
        TreeSet<BasicChromosome> set = new TreeSet<>();
        set.addAll(chromosomes);
        return set;
    }

    public double getFitnessSum() {
        return fitnessSum;
    }

    public double getFitnessAverage() {
        return fitnessAverage;
    }

    public int getSize() {
        return chromosomes.size();
    }

    public BasicChromosome get(int i) {
        return chromosomes.get(i);
    }

    public BasicChromosome getRandomChromosome() {
        return this.get(random.nextInt(getSize()));
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFactory(ChromosomeFactory<?> factory) {
        this.factory = factory;
    }

    public ChromosomeFactory<?> getFactory() {
        return factory;
    }

    public void printChromosomes() {
        for (BasicChromosome c : chromosomes)
            System.out.println(c.toString());
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}
