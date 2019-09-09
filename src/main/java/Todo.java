//A-Inheritance

/**
 * Todo class that extends from Task class that contain the date and
 * the symbol which determines whether it is done by using a cross
 * or a tick.
 */
public class Todo extends Task {

    protected String symbol;
    protected String when;

    /**
     * Constructor to initialize the description.
     *
     * @param description a String that contains the ask that user input
     */
    public Todo(String description) {
        super(description);
        this.symbol = "T";
    }

    /**
     * Returns the statusIcon.
     *
     * @return String to states the statusIcon.
     */
    @Override
    public String getStatusIcon() {
        return "[T]" + "[" + super.getStatusIcon()+ "]" + description;
    }

    /**
     * Return the tick or cross symbol for the task.
     *
     * @return String that provides the tick or cross.
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns an empty string.
     *
     * @return String (empty).
     */
    @Override
    public String getWhen() {
        return "";
    }
}
