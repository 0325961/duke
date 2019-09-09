//A-MoorOOP
//Contain task list - operations to add/delete tasks in the list
//A-JavaDoc

import java.util.ArrayList;

/**
 * TaskList class that contain the task list and includes
 * operation such as add/delete task in the list.
 */
public class TaskList {
    protected ArrayList<Task> arrList;

    /**
     * Constructor to initialize an arrayList of Task class called temp.
     *
     * @param temp an arrList containing all the tasks.
     */
    public TaskList(ArrayList<Task> temp) {
        this.arrList = temp;
    }

    /**
     * Returns arrList when getTask is called.
     *
     * @return the arrList.
     */
    public ArrayList<Task> getTask() {
        return arrList;
    }

    /**
     * Adds the entered task into the arrList.
     *
     * @param temp an arrList containing all the tasks.
     */
    public void addTask(Task temp) {
        arrList.add(temp);
    }

    /**
     * Removes the entered task from the arrList.
     *
     * @param index index of the element in the arrList that have to be removed.
     */
    public void removeTask(int index) {
        arrList.remove(index);
    }
}
