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
import splice.StopCondition;

/**
 * defines how the genetic algorithm should stop
 * @author igor
 *
 */
public abstract class GeneticAlgorithmStopCondition extends PopulationManipulator implements ProblemTypeComponent, InitializeComponent, StopCondition {
	private ProblemType problemType;
	
	/**
	 * Defines when the GA may stop based on a defined condition
	 * @param generation current generation's number
	 * @return true if the condition has been met
	 */
	public abstract boolean stop(int generation);

	public ProblemType getProblemType() {
		return problemType;
	}

	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}

    @Override
    public void initialize() {
        return;
    }
}
