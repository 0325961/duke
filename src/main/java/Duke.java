import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {

    static ArrayList <Task> arrList = new ArrayList <Task>();

    public static void main(String[] args) throws IOException {
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
        int index;

        Scanner scan = new Scanner(System.in);
        FileWriter file = null;
        try {
            file = new FileWriter("output.txt");

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
                                throw new DukeException("\u2639 OOPS!!! The description of a todo cannot be empty\n" +
                                        "Please enter another todo with description!");
                            }
                            Todo todo = new Todo(userInput);
                            arrList.add(todo);
                            System.out.println("Got it. I've added this task: ");
                            System.out.println(todo.getStatusIcon());
                            System.out.println("Now you have " + arrList.size() + " tasks in the list.");
                            file.write("T | 0 | " + userInput + "\n");
                        } catch (DukeException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (value.startsWith("delete")) {
                        userInput = value.replaceFirst("delete", "");
                        userInput = userInput.replaceAll(" ", "");
                        index = Integer.parseInt(userInput);
                        System.out.println("Noted. I've removed this task: ");
                        System.out.println(arrList.get(index-1).getStatusIcon());
                        arrList.remove(index-1);
                        System.out.println("Now you have " + arrList.size() + " tasks in the list");
                    }
                    else if (value.startsWith("deadline")) {
                        try {
                            userInput = value.replaceFirst("deadline", "");
                            if (userInput.length() == 0) {
                                throw new DukeException("\u2639 OOPS!!! The description of a deadline cannot be empty.\n" +
                                        "Please enter another deadline with description");
                            }
                            temp = userInput.split("/", 2);
                            temp1 = temp[1].split(" ", 2);
                            Deadline deadline = new Deadline(temp[0], temp1[1]);
                            arrList.add(deadline);
                            System.out.println("Got it. I've added this task: ");
                            System.out.println(deadline.getStatusIcon());
                            System.out.println("Now you have " + arrList.size() + " tasks in the list.");
                            file.write("D | 0 | " + temp[0] + " | " + temp1[1] + "\n");
                        } catch (DukeException e) {
                            System.out.println(e.getMessage());
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
                            Events events = new Events(temp[0], temp1[1]);
                            arrList.add(events);
                            System.out.println("Got it. I've added this task:");
                            System.out.println(events.getStatusIcon());
                            System.out.println("Now you have " + arrList.size() + " tasks in the list.");
                            file.write("E | 0 | " + temp[0] + " | " + temp1[1] + "\n");
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
                        index = Integer.parseInt(temp[1]) - 1;
                        if (index < 0 | index >= arrList.size()) {
                            System.out.println("No elements in the list. Invalid");
                        } else {
                            arrList.get(index).TaskDone();
                            System.out.println(arrList.get(index).getStatusIcon());
                            file.close();
                            file = new FileWriter("output.txt");
                            for (int i = 0; i < arrList.size(); i ++ ) {
                                file.write(arrList.get(i).getSymbol() + " | " + arrList.get(i).isDone + " | " + arrList.get(i).description + " | " + arrList.get(i).getWhen() + "\n");
                            }
                        }
                    } else {
                        throw new DukeException("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(");
                    }
                } catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            if (file != null) {
                file.close();
            }
        }
    }
}
