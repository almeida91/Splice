package util;

import splice.ga.Crossover;
import splice.ga.genes.BinaryGene;

/**
 * A mock crossover for tests purposes
 * @author igor
 */
public class MockCrossover implements Crossover<BinaryGene> {
    private boolean called = false;
    private int timesCalled = 0;

    @Override
    public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
        called = true;
        timesCalled++;
        return new BinaryGene(a.getValue());
    }

    public boolean isCalled() {
        return called;
    }

    public int getTimesCalled() {
        return timesCalled;
    }
}
