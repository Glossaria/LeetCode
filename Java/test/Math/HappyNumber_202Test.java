package Math;

import org.junit.Test;

import static Math.HappyNumber_202.isHappy;
import static Math.HappyNumber_202.isHappy2;
import static org.junit.Assert.*;

/**
 * Created on 1/17/21.
 */
public class HappyNumber_202Test {
    private static final int num = 19;

    @Test
    public void testHappyNum1(){
        assertEquals(isHappy(19), true);
    }

    @Test
    public void testHappyNum2(){
        assertEquals(isHappy2(19), true);
    }

}