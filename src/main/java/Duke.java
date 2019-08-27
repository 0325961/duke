import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void level3(String userInput) {
        ArrayList<Task> arrList = new ArrayList<Task>();
        Scanner input = new Scanner(System.in);

        while(true) {
            String[] splitted = userInput.split(" ", 2);

            if (splitted[0].equals("done")) {
                int index = Integer.parseInt(splitted[1]) - 1;
                //update status
                arrList.get(index).TaskDone();
                System.out.println("Nice! I've marked this task as done: ");
                // PRINT OUT THE DONE TASK : System.out.println("[" + )
                System.out.println("[" + arrList.get(index).getStatusIcon() + "]" + arrList.get(index).getDescription());
            }
            else if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (userInput.equals("list")) {
                //print out the list
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < arrList.size(); i ++) {
                    System.out.println((i+1) + ".[" + arrList.get(i).getStatusIcon() + "]" + arrList.get(i).getDescription());
                }
            }
            else {
                Task tempTask = new Task(userInput);
                arrList.add(tempTask);
                System.out.println("added: " + userInput);
            }
            userInput = input.nextLine();
        }
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
        level3(value);
    }
}
