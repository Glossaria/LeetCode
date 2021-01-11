package HashMap;

/**
 * Created on 1/10/21.
 */

public class SubarraySumEqualsK_560 {
    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum2(int[] nums, int k) {
        int count = 0;
        return count;
    }
}
