package HashMap;

import org.junit.Test;

import static HashMap.SubarraySumEqualsK_560.subarraySum1;
import static HashMap.SubarraySumEqualsK_560.subarraySum2;
import static org.junit.Assert.*;

/**
 * Created by Glossaria on 1/10/21.
 */
public class SubarraySumEqualsK_560Test {
    int[] nums1 = new int[]{1, 1, 1};
    int k1 = 2;

    int[] nums2 = new int[]{1, -1, 0};
    int k2 = 0;

    int[] nums3 = new int[]{1, 2, 3, 4, 5, 6, 7};
    int k3 = 5;

    @Test
    public void testSubArraySum1() {
        assertEquals(subarraySum1(nums1, k1), 2);
        assertEquals(subarraySum1(nums2, k2), 3);
        assertEquals(subarraySum1(nums3, k3), 2);
    }

    @Test
    public void testSubArraySum2() {
        assertEquals(subarraySum2(nums1, k1), 2);
        assertEquals(subarraySum2(nums2, k2), 3);
        assertEquals(subarraySum2(nums3, k3), 2);
    }
}