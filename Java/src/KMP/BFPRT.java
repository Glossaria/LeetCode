package KMP;

import static KMP.theKthSmallestNumber.partition;
import static Sort.InsertionSort.insertionSort;

public class BFPRT {
    public static int minKth(int[] input, int k) {
        int[] arr = new int[input.length];
        System.arraycopy(input, 0, arr, 0, input.length);
        return bfprt(arr, 0, arr.length - 1, k - 1);
    }

    private static int bfprt(int[] arr, int left, int right, int index) {
        if (left == right) return arr[left];

        int pivot = medianOfMedians(arr, left, right);
        int[] range = partition(arr, left, right, pivot);

        if (index >= range[0] && index <= range[1]) {
            return arr[index];
        } else if (index < range[0]) {
            return bfprt(arr, left, range[0] - 1, index);
        } else {
            return bfprt(arr, range[1] + 1, right, index);
        }

    }

    private static int medianOfMedians(int[] arr, int left, int right) {
        int size = right - left + 1;
        int offset = size % 5 == 0 ? 0 : 1;
        int[] arrM = new int[size / 5 + offset];
        for (int i = 0; i < arrM.length; i++) {
            int first = left + i * 5;
            arrM[i] = getMedian(arr, first, Math.min(right, i + 4));
        }
        return bfprt(arrM, 0, arrM.length - 1, arrM.length / 2);
    }

    private static int getMedian(int[] arr, int first, int last) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        insertionSort(temp);
        return temp[Math.max((last - first) / 2, 0)];
    }
}
