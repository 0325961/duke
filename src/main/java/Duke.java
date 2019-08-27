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
        level1(value);
    }
}




//level1(value);
//level2(value);
//level3(value);
//level3WithUseOfClass(value);
//level4(value);
//level5();
