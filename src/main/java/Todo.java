public class Todo extends Task {

    protected String symbol;
    protected String when;

    public Todo(String description) {
        super(description);
        this.symbol = "T";
    }

    @Override
    public String getStatusIcon() {
        return "[T]" + "[" + super.getStatusIcon()+ "]" + description;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String getWhen() {
        return "";
    }
}
