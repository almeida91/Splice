package splice.ais;

import splice.InitializeComponent;
import splice.RandomComponent;

import java.util.Random;

/**
 * @author igor
 */
public class Population implements RandomComponent, InitializeComponent {
    private Random random;

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public void initialize() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
