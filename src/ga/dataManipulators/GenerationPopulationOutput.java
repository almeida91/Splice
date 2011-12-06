package ga.dataManipulators;

import java.io.IOException;

import ga.BasicChromosome;
import ga.GenerationData;

/**
 * Save the whole generation fitness to a specified file
 * @author dev01
 *
 */
public class GenerationPopulationOutput extends GenerationDataFileOutput {
	private int step, counter;
	
	/**
	 * @param step defines at which number of generations it will save the population data
	 * @throws IOException 
	 */
	public GenerationPopulationOutput(String path, int step) throws IOException {
		super(path);
		this.step = step;
		this.counter = -1;
	}
	
	public GenerationPopulationOutput(String path) throws IOException {
		this(path, 1);
	}
	
	@Override
	public void appendData(GenerationData data) throws Exception {
		counter += 1;
		if (counter % step == 0) {
			for (BasicChromosome chromosome : data.getPopulation().getChromosomes()) {
				writer.append(chromosome.getFitness() + " ");
			}
			writer.append('\n');
		}
	}
}
