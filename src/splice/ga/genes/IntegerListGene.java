package splice.ga.genes;

import splice.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author igor
 */
public class IntegerListGene extends ListGene<Integer> {
    private int size, max = Integer.MAX_VALUE;

    public IntegerListGene(List<Integer> value) {
        super(value);
    }

    public IntegerListGene(int size) {
        this(null);
        this.size = size;
    }

    public IntegerListGene(int size, int max) {
        this(size);
        this.max = max;
    }

    @Override
    public void initialize() {
        if (hasSet()) {
            super.initialize();
        }
        else {
            Random random = RandomUtil.getRandom();
            ArrayList<Integer> value = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                value.add(random.nextInt(max));
            }

            setValue(value);
        }
    }
}
