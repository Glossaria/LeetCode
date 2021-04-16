package Sort;

/**
 * Created on 1/26/21.
 * for cases which have a boundary value with each value appeared multiple times
 */
public class CountSort {

    public static int[] countSort(int[] arr, int boundary){
        int[] counter = new int[boundary];
        for( int e : arr){
            counter[e]++;
        }
        int[] res = new int[arr.length];
        int j = 0, i = 0;

        while(i < res.length ){
            while( counter[j]-- > 0){
                res[i++] = j;
            }
            j++;
        }
        return res;
    }

    public static int[] countSort(int[] arr){

        int min = findMin(arr);
        int max = findMax(arr);
        int[] counter = new int[max - min + 1];

        for( int e : arr){
            counter[e - min]++;
        }
        int[] res = new int[arr.length];
        int j = 0, i = 0;

        while(i < res.length ){
            while( counter[j]-- > 0){
                res[i++] = j + min;
            }
            j++;
        }
        return res;
    }

    private static int findMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for( int e : arr){
            min = Math.min(e, min);
        }
        return min;
    }

    private static int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for( int e : arr){
            max = Math.max(e, max);
        }
        return max;
    }
}
