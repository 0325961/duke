//A-Inheritance

public class Deadline extends Task {

    protected String by;
    protected String symbol;
    protected String when;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
        this.symbol = "D";
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String getStatusIcon() {
        return "[D]" + "[" + super.getStatusIcon()+ "]" +  getDescription() + " (by: " +  by + ")";
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getWhen() {
        return by;
    }
}
