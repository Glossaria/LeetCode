package Sort;

import org.junit.Test;

import java.util.Arrays;

import static Sort.QuickSort.quickSort;
import static Utils.SortUtils.generateRandomArray;
import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort(){
        for(int i = 0; i < 10; i++){
            int[] case1 = generateRandomArray(100);
            int[] mergedArray = new int[case1.length];
            System.arraycopy( case1, 0, mergedArray, 0, case1.length);
            quickSort(case1, 0, case1.length - 1);
            Arrays.sort(mergedArray);
            assertArrayEquals(case1, mergedArray);
        }
    }
}