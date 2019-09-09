//A-MoorOOP
// deals with interactions with the user

import java.util.Scanner;

/**
 * Ui class is one that deals with the interactions with the user.
 * For instance printing out the welcome, bye, hello, add task,
 * completed task and delete task message.
 */
public class Ui {
    protected String value;
    protected Scanner input = new Scanner(System.in);

    /**
     * Returns a String userInput that commands a certain action from Duke.
     *
     * @return the user's input.
     */
    public String askForInput() {
        value = input.nextLine();
        return value;
    }

    /**
     * Prints out the Duke welcome message when the program starts.
     */
    public void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Prints out Hello message.
     */
    public void sayHello() {
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
    }

    /**
     * Prints out the Bye message.
     */
    public void sayBye() {
        System.out.println("Bye. See you soon again!");
    }

    /**
     * Prints out the addTask message and informs the user the number of list in the array.
     *
     * @param description the task that have to be added to the list.
     * @param size the number of elements in the list.
     */
    public void addTaskMessage(String description, int size) {
        System.out.println("Got it. I've added this task: \n" + description);
        System.out.println("Now you have " + size + " tasks in your list.");
    }

    /**
     * Prints out the completedTask message.
     *
     * @param description the task that have to be added to the list.
     */
    public void completedTaskMessage(String description) {
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(description);
    }

    /**
     * Prints out the deleted message and informs the user the number of list in the array.
     *
     * @param description the task that have to be added to the list.
     * @param size the number of elements in the list.
     */
    public void deletedMessage (String description, int size) {
        System.out.println("Noted. I've removed this task:");
        System.out.println(description);
        System.out.println("Now you have " + size + " tasks in your list.");
    }

    /**
     * Prints out the exception message.
     *
     * @param exception an error when the user inputs the wrong input format.
     */
    public void showLoadingError(DukeException exception) {
        System.out.println(exception.getMessage());
    }

    /**
     * Prints out the found message when the keyword is found in the list.
     */
    public void foundMessage() {
        System.out.println("Here are the matching tasks in your list:");
    }
}
