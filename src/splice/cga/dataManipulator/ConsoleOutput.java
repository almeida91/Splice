package splice.cga.dataManipulator;

import splice.cga.CgaDataManipulator;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class ConsoleOutput extends CgaDataManipulator {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
    public void saveData() throws Exception {
        writer.flush();
    }

    @Override
    protected void engineAppendData(int iteration) throws Exception {
        writer.append("Generation #")
        .append(Integer.toString(iteration))
        .append(" winner: ")
        .append(Double.toString(getWinnerFitness()))
        .append(" loser: ")
        .append(Double.toString(getLoserFitness()))
        .append(" best: ")
        .append(Double.toString(getBestFitness()))
        .append("\n");
    }
}
