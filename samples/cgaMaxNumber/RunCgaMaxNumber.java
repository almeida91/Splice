package cgaMaxNumber;

import splice.cga.CompactGeneticAlgorithm;
import splice.stopCondition.Iterations;

public class RunCgaMaxNumber {
    public static void main(String[] args) throws Exception {
        CompactGeneticAlgorithm cga = new CompactGeneticAlgorithm(new MaxNumberChromosome(), 16);
        cga.setPopulationSize(100);
        cga.setStopCondition(new Iterations(1000));
        cga.getProblemType().setMaximization();
        cga.execute();
    }
}
