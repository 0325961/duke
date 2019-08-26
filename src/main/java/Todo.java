public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String getStatusIcon() {
        return "[T]" + "[" + super.getStatusIcon()+ "]" + description;
    }

    //public String printOut() {
      //  return "[T]" + "[" + getStatusIcon() + "]" + description;
    //}
}
