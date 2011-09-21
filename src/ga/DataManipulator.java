package ga;

/**
 * Base class for the generation data log/manipulation logic
 * @author igor
 *
 */
public abstract class DataManipulator {
	/**
	 * Appends a new generation to the execution data
	 * @param data the data of a given generation
	 * @throws Exception
	 */
	public abstract void appendData(GenerationData data) throws Exception;
	/**
	 * Saves the input
	 * @throws Exception
	 */
	public abstract void saveData() throws Exception;
}
