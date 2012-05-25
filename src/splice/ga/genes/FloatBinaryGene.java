package splice.ga.genes;

import java.math.BigDecimal;

import splice.ga.Gene;

public class FloatBinaryGene extends Gene<BigDecimal>{

	private int length;
	
	public FloatBinaryGene(BigDecimal value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	public int getLength() {
		return length;
	}

	protected void setLength(int length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return this.getValue().toString();
	}
	
}
