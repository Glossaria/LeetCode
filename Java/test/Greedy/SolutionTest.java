package Greedy;

import org.junit.Test;

import static Greedy.Solution.minMeetingRooms;
import static org.junit.Assert.*;

/**
 * Created on 1/28/21.
 */
public class SolutionTest {

    @Test
    public void testMinMeetingRooms() {
        int[][] arr = {{1, 2}, {3, 4}};
        assertEquals(1, minMeetingRooms(arr));
    }

    @Test
    public void testMinMeetingRooms2() {
        int[][] arr = {{1, 2}, {3, 4}, {3, 4}, {2, 7}};
        assertEquals(3, minMeetingRooms(arr));
    }

}