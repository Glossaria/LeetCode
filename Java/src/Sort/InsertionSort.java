package Sort;

import static Utils.SortUtils.swap;

/**
 * Created on 1/26/21.
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }

        return arr;
    }

}
