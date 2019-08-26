public class Deadline extends Task {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }
    public String getDescription() {
        return description;
    }

    @Override
    public String getStatusIcon() {
        return "[D]" + "[" + super.getStatusIcon()+ "]" +  getDescription() + " (by: " +  by + ")";
    }

    //public String printOut() {
      //  return "[D]" + "[" + getStatusIcon() + "]" + " (by: " +  by + ")";
    //}
}
