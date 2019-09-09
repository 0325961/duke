import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    String desc = "read book";
    Task task = new Task(desc);

    @Test
    public void createTaskTest(){
        String description = task.getDescription();
        assertEquals(desc, description);
    }
}