//A-Inheritance

public class Events extends Task {
    protected String dateAndTime;
    protected String symbol;
    protected String when;

    public Events(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
        this.symbol = "E";
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getStatusIcon() {
        return "[E]" + "[" + super.getStatusIcon() + "]" + getDescription() + " (at: " + dateAndTime +")";
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getWhen() {
        return dateAndTime;
    }
}
