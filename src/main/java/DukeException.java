//A-Exceptions

import java.util.InputMismatchException;

/**
 * DukeException class that extends InputMismatchException.
 * It is to send the error message to the user when input
 * format is wrong.
 */
public class DukeException extends InputMismatchException {

    /**
     * Method that returns the error message to the user when input is invalid
     * @param errorMsg String error message
     */
    public DukeException(String errorMsg) {
        super(errorMsg);
    }
}
