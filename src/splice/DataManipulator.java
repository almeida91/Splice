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

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class DataManipulator extends Thread {
    private ConcurrentLinkedQueue<String> queue;
    private boolean done = false;

    /**
     * Saves the input
     * @throws Exception may throw an exception
     */
    protected abstract void saveData() throws Exception;

    protected abstract void appendData(String data) throws Exception;

    @Override
    public void run() {
        try {
            while (!done || queue.size() > 0) {
                if (queue.size() > 0)
                    appendData(queue.poll());
            }

            saveData();
        }
        catch (Exception ex) {
            // TODO: must manipulate those exceptions in some way
        }
    }

    public void setDone() {
        done = true;
    }

    public ConcurrentLinkedQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(ConcurrentLinkedQueue<String> queue) {
        this.queue = queue;
    }
}