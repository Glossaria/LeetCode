package Sort;

import static Utils.SortUtils.swap;

/**
 * Created on 1/26/21.
 */
public class ShellSort {

    public static int[] shellSort(int[] arr) {
        int knuth = 1;

        while (knuth <= arr.length) {
            knuth = knuth * 3 + 1;
        }

        for (int gap = (knuth - 1) / 3; gap > 0; gap = (gap - 1) / 3) {

            for (int i = gap; i < gap * 2; i++) {

                for (int j = i; j > gap - 1; j -= gap) {

                    if (arr[j] > arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }

                }
            }
        }
        return arr;
    }
}
