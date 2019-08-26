public class Events extends Task {
    protected String dateAndTime;


    public Events(String description, String dateAndTime) {
        super(description);
        this.dateAndTime = dateAndTime;
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
    //public String printOut() {
      //  return "[E]" + "[" + getStatusIcon() + "]" + description + " (by: " + dateAndTime +")";
    //}
}
