import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void level4(String userInput) {
        ArrayList<Task> task = new ArrayList<Task>();
        Scanner input = new Scanner(System.in);

        while(true) {
            String[] temp = userInput.split(" ", 2);
            if (temp[0].equals("todo")) {
                Todo tempTask = new Todo(temp[1]);
                System.out.println("Got it. I've added this task:");
                task.add(tempTask);
                System.out.println(tempTask.getStatusIcon()+ "\n" + "Now you have " + task.size() + " task in the list");
            }
            else if (temp[0].equals("deadline")) {
                String[] temp1 = temp[1].split("/", 2);
                String[] temp2 = temp1[1].split(" ", 2);
                Deadline tempTask = new Deadline(temp1[0], temp2[1]);
                System.out.println("Got it. I've added this task:");
                task.add(tempTask);
                System.out.println(tempTask.getStatusIcon()+ "\n" +
                        "Now you have " + task.size() + " task in the list");
            }
            else if (temp[0].equals("event")) {
                String[] temp1 = temp[1].split("/", 2);
                String[] temp2 = temp1[1].split(" ", 2);
                Events tempTask = new Events(temp1[0], temp2[1]);
                System.out.println("Got it. I've added this task:");
                task.add(tempTask);
                System.out.println(tempTask.getStatusIcon() + "\n" +
                        "Now you have " + task.size() + " task in the list");
            }
            else if (temp[0].equals("done")) {
                int index = Integer.parseInt(temp[1]) - 1;
                task.get(index).TaskDone();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(task.get(index).getStatusIcon());
            }
            else if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (userInput.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < task.size(); i ++) {
                    System.out.println((i+1) + task.get(i).getStatusIcon());
                }
            }
            else {
                Task tempTask = new Task(userInput);
                task.add(tempTask);
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
        level4(value);
    }
}
