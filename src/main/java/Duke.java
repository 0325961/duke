import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A program that will help to manage tasks entered by users
 * such as adding, deleting, displaying and marking the task
 * as complete.
 */
public class Duke {
    //private Storage storage;
    private TaskList tasks;
    private Ui ui;

    static ArrayList<Task> arrList = new ArrayList<Task>(); //A-Collections

    public Duke() {
        ui = new Ui();
        tasks = new TaskList(arrList);
        ui.welcomeMessage();
        ui.sayHello();
        //String userInput = ui.askForInput();
        Parser parser = new Parser(ui, tasks);
        parser.parse("enter");
    }

    public static void main(String[] args) throws IOException {
        new Duke();
    }
}

