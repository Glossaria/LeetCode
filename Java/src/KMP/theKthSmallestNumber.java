package KMP;

import static Utils.SortUtils.swap;

public class theKthSmallestNumber {
    public static int findKthSmallestNumber(int[] arr, int left, int right, int kth){
        if(left == right) return arr[left];
        int pivot = arr[left + (int)(Math.random() * (right - left + 1))];
        int[] range = partition(arr, left, right, pivot);

        if(kth >= range[0] && kth <= range[1]){
            return arr[kth];
        }else if(kth < range[0]){
            return findKthSmallestNumber(arr, left, range[0] - 1, kth);
        }else{
            return findKthSmallestNumber(arr, range[1] + 1, right, kth);
        }
    }

    public static int[] partition(int[] arr, int left, int right, int pivot) {
        int less = left - 1;
        int more = right + 1;
        int cur = left;

        while(cur < more){
           if(arr[cur] < pivot){
               swap(arr, ++less, cur++);
           }else if(arr[cur] > pivot){
               swap(arr, cur++, --more);
           }else{
               cur++;
           }
        }
        return new int[]{less + 1, more - 1};
    }
}
