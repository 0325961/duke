//A-MoorOOP
//A-JavaDoc

import jdk.dynalink.linker.support.SimpleLinkRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Parser class that deals with making sense of the user's input.
 */
public class Parser {

    private Ui ui;
    private TaskList list;

    /**
     * Constructor to initialize Ui class(temp1) and TaskList class(temp2).
     *
     * @param temp1 Ui class.
     * @param temp2 TaskList class.
     */
    public Parser(Ui temp1, TaskList temp2) {
        this.ui = temp1;
        this.list = temp2;
    }

    /**
     * This method of parse will run the program base on the user's command (ie add to
     * list when it is deadline, events... while done will mark the task as done and
     * delete will remove the task from the list.
     *
     * @param value the user's input.
     * @throws DukeException If user's input does not have description and when the
     * user enter invaild inputs.
     */
    public void parse(String value) throws DukeException {
        String userInput;
        String[] temp, temp1;
        boolean toContinue = true;
        while (toContinue) {
            try {
                value = ui.askForInput();
                if (value.startsWith("todo")) {
                    try {
                        userInput = value.replaceFirst("todo", "");
                        if (userInput.length() == 0) {
                            throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty\n" +
                                    "Please enter another todo with description!");
                        }
                        Todo todo = new Todo(userInput);
                        list.addTask(todo);
                        ui.addTaskMessage(todo.getStatusIcon(), list.getTask().size());
                        //file.write("T | 0 | " + userInput + "\n");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (value.startsWith("bye")) {
                    ui.sayBye();
                    toContinue = false;
                } else if (value.startsWith("delete"))  {
                        userInput = value.replaceFirst("delete", "");
                        userInput = userInput.replaceAll(" ", "");
                        int index = Integer.parseInt(userInput);
                        ui.deletedMessage(list.getTask().get(index-1).getStatusIcon(), (list.getTask().size())-1);
                        list.removeTask(index-1);
                } else if (value.startsWith("find")) {
                    try {
                        userInput = value.replace("find", "");
                        if (userInput.length() == 0) {
                            throw new DukeException(("\u2639 OOPS!!! The description of a find cannot be empty\n" +
                                    "Please enter another find with description"));
                        }
                        int num = 1;
                        ui.foundMessage();
                        for (int i = 0; i < list.getTask().size(); i++) {
                            if (list.getTask().get(i).getDescription().contains(userInput)) {
                                System.out.println(num + "." + list.getTask().get(i).getStatusIcon());
                            }
                            num++;
                        }
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (value.startsWith("deadline")) {
                    try {
                        userInput = value.replaceFirst("deadline", "");
                        if (userInput.length() == 0) {
                            throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.\n" +
                                    "Please enter another deadline with description");
                        }
                        temp = userInput.split("/", 2);
                        temp1 = temp[1].split(" ", 2);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
                        Date date = formatter.parse(temp1[1].trim());
                        SimpleDateFormat newFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
                        String dateinString = newFormatter.format(date);
                        Deadline deadline = new Deadline(temp[0], dateinString);
                        list.addTask(deadline);
                        ui.addTaskMessage(deadline.getStatusIcon(), list.getTask().size());
                        //file.write("D | 0 | " + temp[0] + " | " + temp1[1] + "\n");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else if (value.startsWith("event")) {
                    try {
                        userInput = value.replaceFirst("event", "");
                        if (userInput.length() == 0) {
                            throw new DukeException("\u2639 OOPS!!! The description of a event cannot be empty.\n" +
                                    "Please enter another event with description");
                        }
                        temp = userInput.split("/", 2);
                        temp1 = temp[1].split(" ", 2);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HHmm");
                        Date date = formatter.parse(temp1[1].trim());
                        SimpleDateFormat newFormatter = new SimpleDateFormat("F MMMM YYYY hh:mma");
                        String dateinString = newFormatter.format(date);
                        Events events = new Events(temp[0], dateinString);
                        list.addTask(events);
                        ui.addTaskMessage(events.getStatusIcon(), list.getTask().size());
                        //file.write("E | 0 | " + temp[0] + " | " + temp1[1] + "\n");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    } catch (ParseException e) {
                      throw new DukeException("OOPS! Please enter the event as shown below:\n" +
                              "event eventName /at dd/MM/yyyy HHmm\n" +
                              "For example: event programs /at 01/02/2019 1600");
                    }
                } else if (value.startsWith("list")) {
                    System.out.println("Here are the tasks in your list:");
                    for (int i = 0; i < list.getTask().size(); i++) {
                        System.out.println((i + 1) + "." + list.getTask().get(i).getStatusIcon());
                    }
                } else if (value.startsWith("done")) {
                    temp = value.split(" ", 2);
                    int index = Integer.parseInt(temp[1]) - 1;
                    if (index < 0 | index >= list.getTask().size()) {
                        System.out.println("No elements in the list. Invalid");
                    } else {
                        list.getTask().get(index).TaskDone();
                        ui.completedTaskMessage(list.getTask().get(index).getStatusIcon());
                        //file.close();
                        //file = new FileWriter("output.txt");
                        //for (int i = 0; i < list.getTask().size(); i++) {
                        //  file.write(list.getTask().get(i).getSymbol() + " | " + list.getTask().get(i).isDone + " | " + arrList.get(i).description + " | " + arrList.get(i).getWhen() + "\n");
                        // }
                    }
                } else {
                    throw new DukeException("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
