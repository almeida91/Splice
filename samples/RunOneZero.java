import ga.ChromosomeFactory;
import ga.GeneticAlgorithm;
import ga.PopulationAllocator;
import ga.Selector;
import ga.StopCondition;
import ga.allocators.ReplaceAllocator;
import ga.selectors.MinimizeTournametSelector;
import ga.stopConditions.Generations;


public class RunOneZero {
	public static void main(String[] args) {
		ChromosomeFactory factory = new OneZeroChromosomeFactory(1000);
		PopulationAllocator allocator = new ReplaceAllocator();
		Selector selector = new MinimizeTournametSelector();
		
		StopCondition stopCondition = new Generations(1000);
		
		GeneticAlgorithm ga = new GeneticAlgorithm(factory, allocator, selector);
		
		ga.setStopCondition(stopCondition);
		
		ga.execute();
		
		
	}
}
