import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        Scanner input = new Scanner(System.in);
        String value, userInput;
        String[] temp, temp1;
        ArrayList <Task> arrList = new ArrayList <Task>();

        while (true) {
            try {
                value = input.nextLine();
                try {
                    if (value.equals("bye")) {
                        System.out.println("Bye. See you soon again!");
                        break;
                    }
                    if ((value.length() == 0) | value.startsWith(" ")) {
                        throw new DukeException("The task cannot be empty!\n" +
                                "Please enter another input");
                    }
                } catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
                if (value.startsWith("todo")) {
                    try {
                        userInput = value.replaceFirst("todo", "");
                        if (userInput.length() == 0) {
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty\n" +
                                    "Please enter another todo with description!");
                        }
                        Todo todo = new Todo(userInput);
                        arrList.add(todo);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(todo.getStatusIcon());
                        System.out.println("Now you have " + arrList.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (value.startsWith("deadline")) {
                    try {
                        userInput = value.replaceFirst("deadline", "");
                        if (userInput.length() == 0) {
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n" +
                                    "Please enter another deadline with description");
                        }
                        temp = userInput.split("/", 2);
                        temp1 = temp[1].split(" ", 2);
                        Deadline deadline = new Deadline(temp[0], temp1[1]);
                        arrList.add(deadline);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(deadline.getStatusIcon());
                        System.out.println("Now you have " + arrList.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (value.startsWith("event")) {
                    try {
                        userInput = value.replaceFirst("event", "");
                        if (userInput.length() == 0) {
                            throw new DukeException("☹ OOPS!!! The description of a event cannot be empty.\n" +
                                    "Please enter another event with description");
                        }
                        temp = userInput.split("/", 2);
                        temp1 = temp[1].split(" ", 2);
                        Events events = new Events(temp[0], temp1[1]);
                        arrList.add(events);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(events.getStatusIcon());
                        System.out.println("Now you have " + arrList.size() + " tasks in the list.");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                    }
                } else if (value.startsWith("list")) {
                    System.out.println("Here are the tasks in your list");
                    for (int i = 0; i < arrList.size(); i++) {
                        System.out.println((i + 1) + "." + arrList.get(i).getStatusIcon());
                    }
                } else if (value.startsWith("done")) {
                    temp = value.split(" ", 2);
                    int index = Integer.parseInt(temp[1]) - 1;
                    if (index < 0 | index >= arrList.size()) {
                        System.out.println("No elements in the list. Invalid");
                    } else {
                        arrList.get(index).TaskDone();
                        System.out.println(arrList.get(index).getStatusIcon());
                    }
                } else {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
