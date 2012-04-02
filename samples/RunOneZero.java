import ga.GeneticAlgorithm;
import ga.allocators.ReplaceAllocator;
import ga.selectors.MinimizeTournametSelector;
import ga.stopConditions.Generations;

public class RunOneZero {
	public static void main(String[] args) {
		GeneticAlgorithm ga = new GeneticAlgorithm(new OneZeroChromosomeFactory(1000), new ReplaceAllocator(), new MinimizeTournametSelector());
		ga.setStopCondition(new Generations(1000));
		ga.execute();
	}
}
