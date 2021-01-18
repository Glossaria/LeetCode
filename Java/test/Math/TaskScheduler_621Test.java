package Math;

import org.junit.Test;

import static Math.TaskScheduler_621.leastInterval1;
import static org.junit.Assert.*;

/**
 * Created on 1/17/21.
 */
public class TaskScheduler_621Test {

    char[] task = new char[]{'A','A','A','B','B','B'};
    int n = 2;

    @Test
    public void testTaskScheduler1(){
        assertEquals(leastInterval1(task, n), 8);
    }

}