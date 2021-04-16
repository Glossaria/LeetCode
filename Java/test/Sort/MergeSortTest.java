package Sort;

import org.junit.Test;

import java.util.Arrays;

import static Sort.MergeSort.mergeSort;
import static Utils.SortUtils.generateRandomArray;
import static org.junit.Assert.assertArrayEquals;

public class MergeSortTest {

    @Test
    public void testMergeSort(){
        int[] case1 = generateRandomArray(11);
        int[] case2 = generateRandomArray(11);
        Arrays.sort(case1);
        Arrays.sort(case2);
        int[] mergedArray = new int[case1.length + case2.length];
        System.arraycopy( case1, 0, mergedArray, 0, case1.length);
        System.arraycopy( case2, 0, mergedArray, case1.length, case2.length );
        int[] res = mergeSort(case1, case2);
        Arrays.sort(mergedArray);
        assertArrayEquals(res, mergedArray);
    }

    @Test
    public void testMultipleTimes(){
        for(int i = 0; i < 10; i++){
            int[] case1 = generateRandomArray(80);
            int[] case2 = generateRandomArray(100);
            Arrays.sort(case1);
            Arrays.sort(case2);

            int[] mergedArray = new int[case1.length + case2.length];
            System.arraycopy( case1, 0, mergedArray, 0, case1.length);
            System.arraycopy( case2, 0, mergedArray, case1.length, case2.length );

            int[] res = mergeSort(case1, case2);
            Arrays.sort(mergedArray);

            assertArrayEquals(res, mergedArray);
        }
    }
}