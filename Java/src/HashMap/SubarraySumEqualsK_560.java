package HashMap;

import java.util.HashMap;
import java.util.Map;

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
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            preSum += nums[i];

            if(map.containsKey(preSum - k)){
                count += map.get(preSum - k);
            }

        }
        return count;
    }
}
