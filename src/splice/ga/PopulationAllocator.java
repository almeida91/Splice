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

import java.util.ArrayList;
import java.util.Collections;

import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;

/**
 * Allocates a new population set to the current population
 * 
 * @author igor
 * 
 */
public abstract class PopulationAllocator extends PopulationManipulator implements InitializeComponent, ProblemTypeComponent {
    // TODO: must be thread-safe so we can make the reproduction parallel
    private ArrayList<BasicChromosome> newPopulation;
	private Population population;
	private ProblemType problemType;

    /**
     * This method replaces the current population with other chromosomes,
     * but keeps the reference to the old population object
     *
     * @param population a list containing new chromosomes to be allocated
     */
	public void setPopulation(ArrayList<BasicChromosome> population) {
        this.population.setChromosomes(population);
	}

    /**
     * Changes the allocator's population reference
     * @param population which one will have chromosomes allocated
     */
	public void setPopulation(Population population) {
		this.population = population;
	}
	
	public Population getPopulation() {
		return this.population;
	}
	
	/**
	 * Defines the logic of how to allocate the new set
	 */
	public abstract void allocate();
	
	/**
	 * 
	 * @return true if the buffer has been filled
	 */
	public abstract boolean complete();
	
	/**
	 * Appends a chromosome to the new population
	 * @param chromosome one chromosome
	 */
	public void append(BasicChromosome chromosome) {
		newPopulation.add(chromosome);
	}

	/**
	 * @return the bufferized new population
	 */
	public ArrayList<BasicChromosome> getNewPopulation() {
		return newPopulation;
	}
	
	/**
	 * Resets the buffer, you don't want the population to grow till your memory overflows
	 */
	public void reset() { // TODO: should call this at initialization
		newPopulation = new ArrayList<>(population.getSize());
	}
	
	public int bufferSize() {
		return newPopulation.size();
	}
	
	/**
	 * sorts the the new population buffer
	 */
	public void sortNewPopulation() {
		Collections.sort(newPopulation, new ChromosomeFitnessComparator(0));
	}

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}
}
