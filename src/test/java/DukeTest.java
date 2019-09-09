import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DukeTest {
    @Test
    public void dummyTest(){
        Duke duke = new Duke ();
        String s1 = "Todo read book";
        String s2 = " Got it. I've added this task: \n[T][✘] read book \nNow you have 1 tasks in your list.";
        assertEquals(s1, s2);
    }
}
