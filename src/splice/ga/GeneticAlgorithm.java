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

import splice.*;
import splice.exceptions.IncompatibleComponentException;
import splice.ga.dataFormatters.LabeledGeneration;

import java.util.Random;

/**
 * Base class for a genetic algorithm
 *
 * @author igor
 */
public class GeneticAlgorithm extends Algorithm {
    private int populationSize = 100;
    private double mutationRate = 0.2;
    private double crossoverRate = 0.8;
    private boolean initPopulation = true;

    private Population population = new Population();

    private Selector selector;
    private PopulationAllocator allocator;
    private ChromosomeFactory<?> factory;

    private Random random;

    /**
     * Default constructor
     *
     * @param factory   the factory from the initial chromosomes will come
     * @param allocator the new population allocator
     * @param selector  the crossover candidates selector
     */
    public GeneticAlgorithm(ChromosomeFactory<?> factory, PopulationAllocator allocator, Selector selector) {
        this.allocator = allocator;
        this.selector = selector;
        this.factory = factory;

        setDefaultFormatter(new LabeledGeneration());
    }

    public GeneticAlgorithm(BasicChromosome chromosome, PopulationAllocator allocator, Selector selector) {
        this(new DefaultChromosomeFactory(chromosome), allocator, selector);
    }

    protected void iteration(int i) throws Exception {
        population.calculateFitnessSum();

        allocator.reset();
        selector.beforeGeneration();

        doGeneration(i);
        allocator.allocate();
    }

    /**
     * runs the generation's logic, can be overridden in case of some need
     *
     * @param generation current generation, it may be used for some algorithms that do some task at every n-generations
     */
    protected void doGeneration(int generation) {
        BasicChromosome a, b;

        while (!allocator.complete()) {
            a = getChromosome();
            b = getChromosome();

            reproduce(a, b);
            reproduce(b, a);
        }
    }

    private void reproduce(BasicChromosome a, BasicChromosome b) {
        BasicChromosome c;

        if (random.nextDouble() < crossoverRate) {
            c = a.crossover(b);
        }
        else {
            c = a.clone();
        }

        c.mutate(mutationRate);
        allocator.append(c);
    }

    public void initialize() throws Exception {
        random = RandomUtil.getRandom();

        factory.initialize();

        if (initPopulation) {
            population.setSize(populationSize);
            population.setFactory(factory);
            population.initialize();
        }

        setPopulationManipulator(allocator);
        setPopulationManipulator(selector);

        if (!getStopCondition().isCommonUsage()) {
            try {
                setPopulationManipulator((GeneticAlgorithmStopCondition)getStopCondition());
            }
            catch (Exception ex) {
                throw new IncompatibleComponentException();
            }
        }

        try {
            setPopulationManipulator((GeneticAlgorithmDataFormatter)getFormatter());
        }
        catch (Exception ex) {
            throw new IncompatibleComponentException();
        }

        setProblemType(allocator);
        setProblemType(selector);

        allocator.initialize();
        selector.initialize();
    }

    private void setPopulationManipulator(PopulationManipulator manipulator) {
        manipulator.setPopulation(population);
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
        this.population = population;
    }

    protected BasicChromosome getChromosome() {
        return selector.getChromosome();
    }

    public void setPopulationSize(int size) {
        populationSize = size;
    }

    public void setMutationRate(double rate) {
        mutationRate = rate;
    }

    protected PopulationAllocator getAllocator() {
        return allocator;
    }

    protected ChromosomeFactory<?> getFactory() {
        return factory;
    }

    public double getCrossoverRate() {
        return crossoverRate;
    }

    public void setCrossoverRate(double crossoverRate) {
        this.crossoverRate = crossoverRate;
    }

    /**
     * With this you can use a predefined chromosome set,
     * just remember to call this before {@link #execute()}
     *
     * @param initPopulation initial set for the population
     */
    public void setInitPopulation(boolean initPopulation) {
        this.initPopulation = initPopulation;
    }


}