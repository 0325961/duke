//A-Classes
//A-JavaDoc

/**
 * Task class that changes the symbol (tick and cross) when the task is
 * deem as done or not by the user. It also contain a method to change
 * the boolean value of isDone.
 */
public class Task {
    protected String description;
    protected boolean isDone;
    protected String symbol;
    protected String when;

    /**
     * Constructor to initialize description.
     * @param description a String that contain the task that user input.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.symbol = "symbol";
        this.when = "when";
    }

    /**
     * Returns a string which is either a tick or a cross.
     * Method that returns a tick symbol when is true and returns
     * a cross when it is false.
     *
     * @return a String which contain a tick or cross symbol.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Changes the boolean value from false to true when task is done.
     *
     * @return boolean value for isDone as true.
     */
    public boolean TaskDone () {
        return isDone = true;
    }

    /**
     * Updates the task whenever there is a new user input.
     *
     * @param userInput a String that contains user input.
     * @param userSymbol a String that contains either a tick/cross.
     */
    public void updateDescription(String userInput, String userSymbol) {
        description = userInput;
    }

    /**
     * Return the task required.
     *
     * @return a String that contain the task that user input.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Return the symbol to determine the type of the user's input.
     *
     * @return a String which contains "E"/"T"/"D".
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Return the date of the deadline.
     *
     * @return a String of the date of the deadline.
     */
    public String getWhen() {
        return when;
    }
}
