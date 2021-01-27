package Sort;

import static Utils.SortUtils.swap;

/**
 * Created on 1/26/21.
 */


public class SelectionSort {
    //every time find the smallest value and swap with the front one
    //O(n^2)
    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }

        }

        return arr;
    }

    // every time find the smallest and largest number and swap with the front and end
    //O(n^2)
    public static int[] selectionMinMaxSort(int[] arr) {
        for (int i = 0, k = arr.length - 1; i < arr.length && i <= k; i++, k--) {
            int minIndex = i, maxIndex = k;

            for (int j = i; j <= k; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                } else if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
            if (maxIndex != k) {
                swap(arr, k, maxIndex);
            }
        }
        return arr;
    }

}
