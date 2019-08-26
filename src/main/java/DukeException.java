import java.util.Scanner;

public class DukeException extends Exception {
    protected String check;
    protected boolean hasError;

    public DukeException(String check) {
        this.check = check;
        this.hasError = false;
    }

    public void getInput() {
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();
    }



    public boolean detectError() {
        return hasError = true;
    }
    public boolean getHasError() {
        return hasError;
    }

    public void checkIfKeyword(String check) {
        try {
            String[] temp = check.split(" ", 2);
            Todo tempTask = new Todo(temp[1]);
        } catch (Exception ex) {
            detectError();
            System.err.println("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }
}
