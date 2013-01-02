package util;

import splice.ga.Mutator;
import splice.ga.genes.BinaryGene;

import java.util.Random;

/**
 * @author igor
 */
public class MockMutator implements Mutator<BinaryGene> {
    private boolean called = false;
    private int timesCalled = 0;

    @Override
    public void mutate(BinaryGene gene) {
        called = true;
        timesCalled++;
    }

    public boolean isCalled() {
        return called;
    }

    public int getTimesCalled() {
        return timesCalled;
    }
}
