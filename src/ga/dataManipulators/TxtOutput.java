package ga.dataManipulators;

import ga.GenerationData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtOutput extends ConsoleOutput {
	BufferedWriter writer;

	public TxtOutput(String path) throws IOException {
		writer = new BufferedWriter(new FileWriter(path));
	}

	@Override
	public void appendData(GenerationData data) throws Exception {
		super.appendData(data);
		writer.append(data.getFitnessAverage() + " "
				+ data.getBestChromossome().getFitness() + " "
				+ data.getWorstChromossome().getFitness() + "\n");
	}
}
