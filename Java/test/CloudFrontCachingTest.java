import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CloudFrontCachingTest {
    List<String> list = new ArrayList<>();

    @Test
    public void test() {
        list.add("1 2");
        list.add("1 4");
        Assert.assertEquals(CloudFrontCaching.connectedSum(4, list), 3);
    }

    @Test
    public void test2() {
        list.add("1 2");
        list.add("1 4");
        list.add("1 14");
        list.add("1 13");
        Assert.assertEquals(12, CloudFrontCaching.connectedSum(14, list));
    }


    @Test
    public void test3() {
        list.add("1 2");
        list.add("1 4");

        list.add("3 5");
        list.add("5 7");
        list.add("3 6");
        list.add("6 8");
        Assert.assertEquals(7, CloudFrontCaching.connectedSum(10, list));
    }


    @Test
    public void test4() {
        list.add("1 2");
        list.add("1 4");
        list.add("3 5");
        list.add("5 7");
        list.add("9 6");
        list.add("6 8");
        Assert.assertEquals(7, CloudFrontCaching.connectedSum(10, list));
    }

}