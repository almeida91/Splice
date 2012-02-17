package ga.parallel;

public class AtomicDouble {
	private volatile double value;
	
	public AtomicDouble(double value) {
		this.value = value;
	}
	
	public void increment() {
		value++;
	}
	
	public void add(double value) {
		this.value += value;
	}
	
	public double getValue() {
		return value;
	}
}
