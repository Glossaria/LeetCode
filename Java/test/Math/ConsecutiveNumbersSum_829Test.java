package Math;

import org.junit.Test;

import static Math.ConsecutiveNumbersSum_829.consecutiveNumbersSum1;
import static Math.ConsecutiveNumbersSum_829.consecutiveNumbersSum2;
import static org.junit.Assert.assertEquals;

/**
 * Created on 1/14/21.
 */
public class ConsecutiveNumbersSum_829Test {
    private final int num = 933320757;

    @Test
    public void consecutiveNumbersSumTest1() {
        assertEquals(16, consecutiveNumbersSum1(num));
    }

    @Test
    public void consecutiveNumbersSumTest2() {
        assertEquals(16, consecutiveNumbersSum2(num));
    }
}