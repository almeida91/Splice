package splice.cga;

import splice.DataManipulator;
import splice.exceptions.DataNotSetException;

public abstract class CgaDataManipulator extends ContextManipulator implements DataManipulator {
    @Override
    public void appendData(int iteration) throws Exception {
        if (!isDataSet())
            throw new DataNotSetException();
        else
            reset();

        engineAppendData(iteration);
    }

    @Override
    public abstract void saveData() throws Exception;

    protected abstract void engineAppendData(int iteration) throws Exception;
}
