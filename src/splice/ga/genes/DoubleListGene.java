package splice.ga.genes;

import splice.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author igor
 */
public class DoubleListGene extends ListGene<Double> {
    private int size, max = Integer.MAX_VALUE;

    public DoubleListGene(List<Double> value) {
        super(value);
    }

    public DoubleListGene(int size) {
        this(null);
        this.size = size;
    }

    public DoubleListGene(int size, int max){
        this(size);
        this.max = max;
    }

    @Override
    public void initialize() {
        Random random = RandomUtil.getRandom();
        ArrayList<Double> value = new ArrayList<Double>();

        for (int i = 0; i < size; i++) {
            value.add((double)random.nextInt(max - 1) + random.nextDouble());
        }

        setValue(value);
    }
}
