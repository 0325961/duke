//A-Inheritance

/**
 * Deadline class that extends from Task Class. Contains the date and time
 * and the letter in String to represent deadline.
 */
public class Deadline extends Task {

    protected String by;
    protected String symbol;

    /**
     * Constructor that initializes description and by which is the date and time.
     *
     * @param description which is a String that user inputs.
     * @param by which is a String that contains the date and time.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.symbol = "D";
    }

    /**
     * Returns a String description.
     *
     * @return description which is the name of task that user input.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a String that states the status icon.
     *
     * @return the status icon to user.
     */
    @Override
    public String getStatusIcon() {
        return "[D]" + "[" + super.getStatusIcon()+ "]" +  getDescription() + " (by: " +  by + ")";
    }

    /**
     * Returns a String that contain "D" which means deadline.
     *
     * @return the String "D".
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    /**
     * Return a String of date and time of deadline.
     *
     * @return the String for the deadline's time and date.
     */
    @Override
    public String getWhen() {
        return by;
    }
}
