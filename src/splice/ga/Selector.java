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

import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;

/**
 * Selects chromosome's candidates for crossover
 * 
 * @author igor
 * 
 */
public abstract class Selector extends PopulationManipulator implements ProblemTypeComponent, InitializeComponent {
	private ProblemType problemType;
	
	/**
	 * The selection logic
	 * @return a chromosome for crossover
	 */
	public abstract BasicChromosome getChromosome();

    /**
     * Holds any logic to be called before the generation parents selection
     */
	public abstract void beforeGeneration();

	public ProblemType getProblemType() {
		return problemType;
	}
	
	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}
}
