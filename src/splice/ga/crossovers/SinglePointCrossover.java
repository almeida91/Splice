package splice.ga.crossovers;

import splice.ga.Crossover;
import splice.ga.genes.ListGene;

/**
 * @author igor
 */
public class SinglePointCrossover<T> implements Crossover<ListGene<T>> {
    @Override
    public ListGene<T> doCrossover(ListGene<T> a, ListGene<T> b) {
        ListGene<T> gene = (ListGene<T>) a.clone();
        int i, size = a.getSize();

        for (i = 0; i < size / 2; i++) {
            gene.set(i, a.get(i));
        }

        for (; i < size; i++) {
            gene.set(i, b.get(i));
        }

        return gene;
    }
}
