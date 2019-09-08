//A-Exceptions

import java.util.InputMismatchException;
import java.util.Scanner;

public class DukeException extends InputMismatchException {
    public DukeException(String errorMsg) {
        super(errorMsg);
    }
}
