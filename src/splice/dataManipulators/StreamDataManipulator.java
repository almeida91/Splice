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

package splice.dataManipulators;

import splice.DataManipulator;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 06/11/13
 * Time: 00:54
 * To change this template use File | Settings | File Templates.
 */
public class StreamDataManipulator extends DataManipulator {
    private BufferedWriter writer;
    private boolean flushToSave = false;

    public StreamDataManipulator(OutputStream out, boolean flushToSave) {
        this.writer = new BufferedWriter(new OutputStreamWriter(out));
        this.flushToSave = flushToSave;
    }

    public StreamDataManipulator(OutputStream out) {
        this(out, false);
    }

    @Override
    protected void saveData() throws Exception {
        if (flushToSave)
            writer.flush();
        else
            writer.close();
    }

    @Override
    protected void appendData(String data) throws Exception {
        writer.append(data);
    }
}
