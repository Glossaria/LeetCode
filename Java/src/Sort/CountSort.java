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

}
