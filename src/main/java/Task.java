import java.util.ArrayList;

public class Task {
    protected String description;
    protected boolean isDone;
    protected String symbol;
    protected String when;
    
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.symbol = "symbol";
        this.when = "when";
    }
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public boolean TaskDone () {
        return isDone = true;
    }
    public void updateDescription(String userInput, String userSymbol) {
        description = userInput;
    }
    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getWhen() {
        return when;
    }
}
