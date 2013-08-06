package splice.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 06/08/13
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */
public class DataNotSetException extends RuntimeException {
    public DataNotSetException() {
        super("The generation data was not set.");
    }
}
