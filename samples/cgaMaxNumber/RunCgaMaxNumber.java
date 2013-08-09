package cgaMaxNumber;

import splice.cga.CompactGeneticAlgorithm;

public class RunCgaMaxNumber {
    public static void main(String[] args) throws Exception {
        CompactGeneticAlgorithm cga = new CompactGeneticAlgorithm(new MaxNumberChromosome(), 8);
        cga.setPopulationSize(100);
        cga.getProblemType().setMinimization();
        cga.execute();
    }
}
