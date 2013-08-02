package splice.ga.mutators;

import splice.RandomUtil;
import splice.ga.Mutator;
import splice.ga.genes.IntegerListGene;

/**
 * @author igor
 */
public class RandomIntegerMutator implements Mutator<IntegerListGene> {
    private int max;

    public RandomIntegerMutator(int max) {
        this.max = max;
    }

    public RandomIntegerMutator() {
        max = Integer.MAX_VALUE;
    }

    @Override
    public void mutate(IntegerListGene gene) {
        gene.set(RandomUtil.getRandom().nextInt(gene.getSize()), RandomUtil.getRandom().nextInt(max));
    }
}
