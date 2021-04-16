package Sort;

/**
 * Created on 1/26/21.
 */
public class MergeSort {
    public static int[] mergeSort(int[] arr1, int[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1 + len2];
        int cur = 0, i = 0, j = 0;

        while( i < len1 || j < len2 ) {
            if (i >= len1) {
                res[cur++] = arr2[j++];
            } else if (j >= len2) {
                res[cur++] = arr1[i++];
            }else{
                if(arr1[i] < arr2[j]){
                    res[cur++] =  arr1[i++];
                }else{
                    res[cur++] = arr2[j++];
                }
            }
        }
        return res;
    }

}
