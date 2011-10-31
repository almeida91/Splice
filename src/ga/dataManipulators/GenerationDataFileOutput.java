package ga.dataManipulators;

import ga.DataManipulator;
import ga.GenerationData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves the generation data into a txt file
 * @author igor
 *
 */
public class GenerationDataFileOutput extends DataManipulator {
	protected BufferedWriter writer;

	public GenerationDataFileOutput(String path) throws IOException {
		writer = new BufferedWriter(new FileWriter(path));
	}

	@Override
	public void appendData(GenerationData data) throws Exception {
		writer.append(data.getFitnessAverage() + " "
				+ data.getBestChromosome().getFitness() + " "
				+ data.getWorstChromosome().getFitness() + "\n");
	}

	@Override
	public void saveData() throws Exception {
		writer.close();
	}
}
