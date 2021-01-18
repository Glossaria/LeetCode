package Math;

import java.util.Arrays;

/**
 * Created on 1/17/21.
 */
public class TaskScheduler_621 {

    public static int leastInterval1(char[] tasks, int n) {
        int[] arr = new int[26];

        for (char c : tasks) {
            arr[c - 'A']++;
        }

        Arrays.sort(arr);
        int max = arr[25] - 1;
        int total = max * n;

        for (int i = 24; i >= 0; i--) {
            total -= Math.min(max, arr[i]);
        }
        return total > 0 ? tasks.length + total : tasks.length;
    }

}
