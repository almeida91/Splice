package splice.cga;

import splice.ga.SingleGeneChromosome;
import splice.ga.genes.BinaryGene;

public abstract class ContextManipulator {
    private double bestFitness, winnerFitness, loserFitness;
    private boolean dataSet;

    public void setData(double best, double winner, double loser) {
        bestFitness = best;
        winnerFitness = winner;
        loserFitness = loser;

        dataSet = true;
    }

    public void setData(SingleGeneChromosome<BinaryGene> best, SingleGeneChromosome<BinaryGene> winner, SingleGeneChromosome<BinaryGene> loser) {
        bestFitness = best.getFitness();
        winnerFitness = winner.getFitness();
        loserFitness = loser.getFitness();

        dataSet = true;
    }

    protected void reset() {
        dataSet = false;
    }

    protected double getBestFitness() {
        return bestFitness;
    }

    protected double getWinnerFitness() {
        return winnerFitness;
    }

    protected double getLoserFitness() {
        return loserFitness;
    }

    public boolean isDataSet() {
        return dataSet;
    }
}
