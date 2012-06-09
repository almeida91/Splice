package splice.ga;

public class ProblemType {
	private boolean maxmization, minimization;

	public void setMaxmization() {
		maxmization = true;
		minimization = false;
	}
	
	public void setMinimization() {
		maxmization = false;
		minimization = true;
	}

	public boolean isMaxmization() {
		return maxmization;
	}

	public boolean isMinimization() {
		return minimization;
	}
}
