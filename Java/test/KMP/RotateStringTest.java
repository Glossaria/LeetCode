package KMP;

import org.junit.Assert;
import org.junit.Test;

import static KMP.RotateString.rotateString;

public class RotateStringTest {

    @Test
    public void testRotateString(){
        String s1 = "123456";
        String s2 = "612345";
        String s3 = "5612345";
        String s4 = "561234";

        Assert.assertEquals(rotateString(s1, s2), true);
        Assert.assertEquals(rotateString(s1, s3), false);
        Assert.assertEquals(rotateString(s1, s4), true);

    }
}