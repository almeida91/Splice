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

package splice;

import splice.dataManipulators.TerminalDataManipulator;
import splice.exceptions.NoDataFormatterException;
import splice.exceptions.NoStopConditionException;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Defines a new Algorithm compatible with Splice's API
 */
public abstract class Algorithm implements InitializeComponent, ProblemTypeComponent {
    private double lastTime = 0;

    private DataManipulator dataManipulator = new TerminalDataManipulator();
    private StopCondition stopCondition;
    private DataFormatter formatter;
    private ProblemType problemType = new ProblemType();
    private ConcurrentLinkedQueue<String> queue;

    protected abstract void iteration(int i) throws Exception;

    /**
     * Start the main optimization logic.
     * It usually contains the main loop which iterates through the steps.
     *
     * @throws Exception sometimes the algorithm may contain some kind of error handling, like the data manipulators
     */
    public void execute() throws Exception {
        initialize();

        setProblemType(getProblemType());

        if (problemType.isUnset())
            problemType.setMaximization();

        queue = new ConcurrentLinkedQueue<>();

        dataManipulator.setQueue(queue);
        dataManipulator.start();

        long iterationBegin, iterationEnd;

        double begin = System.currentTimeMillis();

        int i = 1;
        do {
            iterationBegin = System.nanoTime();
            iteration(i);
            iterationEnd = System.nanoTime();

            queue.add(formatter.format(i, iterationEnd - iterationBegin));

            i++;
        } while (!stopCondition.stop(i));

        double end = System.currentTimeMillis();

        lastTime = end - begin;

        dataManipulator.setDone();
        dataManipulator.join();
    }

    protected void setProblemType(ProblemTypeComponent component) {
        component.setProblemType(problemType);
    }

    /**
     * Returns the time required by the last time the logic in {@link #execute()} method required
     *
     * @return the time in milliseconds
     */
    public double getLastTime() {
        return this.lastTime;
    }

    public StopCondition getStopCondition() {
        if (stopCondition == null)
            throw new NoStopConditionException();

        return stopCondition;
    }

    public void setStopCondition(StopCondition stopCondition) {
        this.stopCondition = stopCondition;
    }

    public void setDataManipulator(DataManipulator dataManipulator) {
        this.dataManipulator = dataManipulator;
    }

    public DataFormatter getFormatter() {
        return formatter;
    }

    public void setFormatter(DataFormatter formatter) {
        if (formatter == null)
            throw new NoDataFormatterException();

        this.formatter = formatter;
    }

    public void setDefaultFormatter(DataFormatter formatter) {
        if (this.formatter == null)
            this.formatter = formatter;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }
}
