package ga;

public interface InitializeComponent {
	/**
	 * Holds any logic to be done before the GA's execution.
	 * It should be noted that when this is called there's a Random instance setted while this is not true in the constructor
	 */
	public void initialize();
}
