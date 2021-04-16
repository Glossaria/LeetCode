package Sort;

import static Utils.SortUtils.swap;

/**
 * Created on 1/26/21.
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right){
        if(left >= right) return ;
        int pivot = partition(arr, left, right);
        quickSort(arr, 0,pivot - 1);
        quickSort(arr, pivot + 1, right);

    }

    private static int partition(int[] arr,
                                 int leftIdx,
                                 int rightIdx){

        int pivot = arr[rightIdx];
        int left = leftIdx;
        int right = rightIdx - 1;

        while (left < right){
            while(left <= right && arr[left] <= pivot) left++;
            while (left <= right && arr[right] > pivot) right--;
            if(left < right) swap(arr, left,right);
        }

        if(arr[left] > arr[rightIdx]){
            swap(arr, left, rightIdx);
        }
        return left;
    }
}
