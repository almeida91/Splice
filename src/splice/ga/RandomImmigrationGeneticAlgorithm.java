package splice.ga;

/**
 * @author igor
 */
public class RandomImmigrationGeneticAlgorithm extends GeneticAlgorithm {
    private double immigrationRate = 0.1;
    private int mod, frequency = 100;

    /**
     * Default constructor
     *
     * @param factory   the factory from the initial chromosomes will come
     * @param allocator the new population allocator
     * @param selector  the crossover candidates selector
     */
    public RandomImmigrationGeneticAlgorithm(ChromosomeFactory<?> factory, PopulationAllocator allocator, Selector selector) {
        super(factory, allocator, selector);
    }

    @Override
    public void initialize() {
        super.initialize();
        mod = 0;
    }

    @Override
    protected void doGeneration(int i) {
        mod = i % frequency;
        if (mod == 0) {
            for (int j = 0; j < getPopulationSize() * immigrationRate; j++) {
                getAllocator().append(getFactory().generateChromosome());
            }
        }
        super.doGeneration(i);
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getImmigrationRate() {
        return immigrationRate;
    }

    public void setImmigrationRate(double immigrationRate) {
        this.immigrationRate = immigrationRate;
    }
}
