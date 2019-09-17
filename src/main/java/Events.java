//A-Inheritance
//A-JavaDoc


/**
 * Events class that extends from Task class. Contains the date and time
 *  and the letter "E" to represent events.
 */
public class Events extends Task {
    protected String dateAndTime;
    protected String symbol;

    /**
     * Constructor to initialize description and dateAndTime.
     *
     * @param description a String that contain the task that user input.
     * @param dateAndTime s String that contain both the date and time.
     */
    public Events(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        this.symbol = "E";
    }

    /**
     * Returns the date and time of the event.
     *
     * @return a String that contains both the date and time.
     */
    public String getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Return the task that the user inputs.
     *
     * @return a String that is the task that is entered by user.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the statusIcon.
     *
     * @return String to states the statusIcon.
     */
    @Override
    public String getStatusIcon() {
        return "[E]" + "[" + super.getStatusIcon() + "]" + getDescription() + " (at: " + dateAndTime +")";
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
     * Return the date and time when the event is at.
     *
     * @return String which contains the date and time together.
     */
    @Override
    public String getWhen() {
        return dateAndTime;
    }
}
