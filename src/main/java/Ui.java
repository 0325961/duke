// deals with interactions with the user

import java.util.Scanner;

public class Ui {
    protected String value;
    protected Scanner input = new Scanner(System.in);

    public String askForInput() {
        value = input.nextLine();
        return value;
    }

    public void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    public void sayHello() {
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
    }

    public void sayBye() {
        System.out.println("Bye. See you soon again!");
    }

    public void addTaskMessage(String description, int size) {
        System.out.println("Got it. I've added this task: \n" + description);
        System.out.println("Now you have " + size + " tasks in your list.");
    }

    public void completedTaskMessage(String description) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(description);
    }

    public void deletedMessage (String description, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(description);
        System.out.println("Now you have " + size + " tasks in your list.");
    }

    public void showLoadingError(DukeException exception) {
        System.out.println(exception.getMessage());
    }

    public void foundMessage() {
        System.out.println("Here are the matching tasks in your list:");
    }
}
