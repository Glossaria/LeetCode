package Sort;

import org.junit.Test;

import java.util.Arrays;

import static Sort.InsertionSort.insertionSort;
import static Utils.SortUtils.generateRandomArray;
import static org.junit.Assert.*;

/**
 * Created on 1/27/21.
 */
public class InsertionSortTest {

    @Test
    public void testInsertionSort() {
        for (int i = 0; i <= 10; i++) {
            int[] arr = generateRandomArray(100);
            int[] curArray = arr;
            Arrays.sort(curArray);
            assertArrayEquals(curArray, insertionSort(arr));
        }
    }

}