import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {

    public static void level1(String userInput) {
        Scanner input = new Scanner(System.in);
        while (true) {
            if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you soon.");
                break;
            }
            else
            {
                System.out.println(userInput);
            }
            userInput = input.nextLine();
        }
    }

    public static void level2(String userInput) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> myList = new ArrayList<String>(0);
        int i = 0;
        myList.add(userInput);
        System.out.println(userInput);

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

    public static void level3(String userInput) {
        Scanner input = new Scanner(System.in);
        int i = 0;
        String[] myArray = new String[100];
        boolean[] done = new boolean[100]; //sets all values to false initially

        while (true) {
            if (userInput.equals("list")) {
                for (int a = 0; a < i; a++) {
                    if (done[a] == true)
                    {
                        System.out.println(a+1 + ". " + "[✓]" + myArray[a]);
                    }
                    else {
                        System.out.println(a+1 + ". " + "[✗]" + myArray[a]);
                    }
                }
            } else if (userInput.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                break;
            }
            else {// myString == done num or a word
                String[] word = userInput.split(" ", 2);
                if (word[0].equals("done"))
                {
                    System.out.println("Nice! I've marked this task as done: ");
                    int result = Integer.parseInt(word[1]);
                    System.out.println("[✓]" + myArray[result-1]);
                    done[result-1] = true;
                }
                else {
                    System.out.println("added: " + userInput);
                    myArray[i] = userInput;
                    i += 1;
                }
            }
            userInput = input.nextLine();
        }

    }

    public static void level3WithUseOfClass(String userInput) {
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

        //level1(value);
        //level2(value);
        //level3(value);
        level3WithUseOfClass(value);
    }
}




/*
METHOD 2 (use of array instead of ArrayList) for level 2
        Scanner input = new Scanner(System.in);

        boolean toContinue = true;

        int i = 0;
        String[] myArray = new String[100];

        while (toContinue) {
            String myString = input.next();
            if (myString.equals("list")) {
                for (int a = 0; a < i; a++) {
                    System.out.println(a+1 + ". " + myArray[a]);
                }
            } else if (myString.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!\n");
                toContinue = false;
                break;
            } else {// myString != "bye" or "list"
                System.out.println("added: " + myString);
                myArray[i] = myString;
                i += 1;
            }
        }

*/


