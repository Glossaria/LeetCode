package HashMap;

import org.junit.Test;
import static HashMap.TopKFrequentElements_347.topKFrequent1;
import static HashMap.TopKFrequentElements_347.topKFrequent2;
import static org.junit.Assert.*;

/**
 * Created on 1/11/21.
 */
public class TopKFrequentElements_347Test {
    private static final int[] nums1 = new int[]{1, 1, 1, 2, 2, 3};
    private static final int k1 = 2;

    @Test
    public void test1() {
        int[] res1 = new int[]{2,1};
        assertArrayEquals(res1, topKFrequent1(nums1, k1));
    }

    @Test
    public void test2() {
        int[] res1 = new int[]{1,2};
        assertArrayEquals(res1, topKFrequent2(nums1, k1));
    }
}