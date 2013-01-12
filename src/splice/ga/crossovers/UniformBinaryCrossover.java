package splice.ga.crossovers;

import splice.RandomUtil;
import splice.ga.genes.BinaryGene;

import java.math.BigInteger;

/**
 * @author igor
 */
public class UniformBinaryCrossover extends MaskBinaryCrossover {
    private int length = 0;

    public UniformBinaryCrossover() {
        super(null);
    }

    private void generateMasks() {
        StringBuilder o1 = new StringBuilder(length),
                      o2 = new StringBuilder(length);

        final char one = '1',
                   zero = '0';

        for (int i = 0; i < length; i++) {
            if (RandomUtil.getRandom().nextBoolean()) {
                o1.append(one);
                o2.append(zero);
            }
            else {
                o1.append(zero);
                o2.append(one);
            }
        }

        aMask = new BigInteger(o1.toString(), 2);
        bMask = new BigInteger(o2.toString(), 2);
    }

    @Override
    public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
        if (length == 0) {
            length = a.getLength();
            generateMasks();
        } else {
            length = 0;
        }


        return super.doCrossover(a, b);
    }
}
