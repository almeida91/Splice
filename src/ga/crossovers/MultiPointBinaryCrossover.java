package ga.crossovers;

import java.math.BigInteger;

import ga.Crossover;
import ga.genes.BinaryGene;


public class MultiPointBinaryCrossover implements Crossover<BinaryGene> {
	private int points;
	private int length = 0;
	private BigInteger aMask, bMask;
	
	public MultiPointBinaryCrossover(int points) {
		this.points = points;
	}
	
	private void generateMasks() {
		
	}
	
	@Override
	public BinaryGene doCrossover(BinaryGene a, BinaryGene b) {
		if (a.getLength() != length) {
			length = a.getLength();
			generateMasks();
		}
		
		BigInteger value = a.getValue().and(aMask).xor(b.getValue().and(bMask));
		
		// TODO: how return if it's an abstract type?
				
		return null;
	}
}
