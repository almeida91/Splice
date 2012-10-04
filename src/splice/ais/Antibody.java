package splice.ais;

import splice.InitializeComponent;
import splice.RandomComponent;

import java.util.Random;

/**
 *
 * @author igor
 */
public abstract class Antibody implements RandomComponent, InitializeComponent {
    private Random random;

    @Override
    public Random getRandom() {
        return random;
    }

    @Override
    public void setRandom(Random random) {
        this.random = random;
    }

}
