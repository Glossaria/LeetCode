package HashMap;

import org.junit.Test;

import static HashMap.TopKFrequentElements_347.topKFrequent1;
import static HashMap.TopKFrequentElements_347.topKFrequent2;
import static HashMap.TopKFrequentElements_347.topKFrequent3;
import static org.junit.Assert.*;

/**
 * Created on 1/11/21.
 */
public class TopKFrequentElements_347Test {
    private static final int[] nums1 = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 6};
    private static final int k1 = 2;

    @Test
    public void test1() {
        int[] res = new int[]{1, 3};
        assertArrayEquals(res, topKFrequent1(nums1, k1));
    }

    @Test
    public void test2() {
        int[] res = new int[]{3, 1};
        assertArrayEquals(res, topKFrequent2(nums1, k1));
    }


    @Test
    public void test3() {
        int[] res = new int[]{3, 1};
        assertArrayEquals(res, topKFrequent3(nums1, k1));
    }


}