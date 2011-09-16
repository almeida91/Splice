package ga.dataManipulators;

import ga.DataManipulator;
import ga.GenerationData;

public class ConsoleOutput extends DataManipulator {
	@Override
	public void appendData(GenerationData data) {
		System.out.println("Generation #" + data.getGeneration() + " fitness: "
				+ data.getFitnessAverage() + " best: "
				+ data.getBestGenome().getFitness() + " worst: "
				+ data.getWorstGenome().getFitness() + " pop size: "
				+ data.getPopulation().getGenomes().size());
	}

	@Override
	public void saveData() { }

}
