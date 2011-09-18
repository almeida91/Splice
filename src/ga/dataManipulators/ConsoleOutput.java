package ga.dataManipulators;

import ga.DataManipulator;
import ga.GenerationData;

public class ConsoleOutput extends DataManipulator {
	@Override
	public void appendData(GenerationData data) throws Exception {
		System.out.println("Generation #" + data.getGeneration() + " fitness: "
				+ data.getFitnessAverage() + " best: "
				+ data.getBestChromossome().getFitness() + " worst: "
				+ data.getWorstChromossome().getFitness() + " pop size: "
				+ data.getPopulation().getChromossomes().size());
	}

	@Override
	public void saveData() { }

}
