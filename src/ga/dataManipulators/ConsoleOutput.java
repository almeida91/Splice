package ga.dataManipulators;

import ga.DataManipulator;
import ga.GenerationData;

/**
 * Prints each generation data into the default output stream
 * @author igor
 *
 */
public class ConsoleOutput extends DataManipulator {
	@Override
	public void appendData(GenerationData data) throws Exception {
		System.out.println("Generation #" + data.getGeneration() + " fitness: "
				+ data.getFitnessAverage() + " best: "
				+ data.getBestChromosome().getFitness() + " worst: "
				+ data.getWorstChromosome().getFitness() + " pop size: "
				+ data.getPopulation().getChromosomes().size());
	}

	@Override
	public void saveData() { }

}
