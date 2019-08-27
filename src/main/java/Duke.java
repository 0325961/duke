import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void level2(String userInput) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> myList = new ArrayList<String>(0);
        int i = 0;
        myList.add(userInput);
        System.out.println("added: " + userInput);

        while (!userInput.equals("bye")) {
            userInput = input.nextLine();
            if (!userInput.equals("list")) {
                System.out.println("added: " + userInput);
                i += 1;
                myList.add(userInput);
            }
            else {
                for (int a = 0; a < myList.size(); a++) {
                    System.out.println((a+1) + "." + myList.get(a));
                }
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");

        Scanner input = new Scanner(System.in);
        String value = input.nextLine();
        level2(value);
    }
}
