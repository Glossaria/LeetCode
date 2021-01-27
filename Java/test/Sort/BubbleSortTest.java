package Sort;

import org.junit.Test;

import java.util.Arrays;

import static Sort.BubbleSort.bubbleSort;
import static Utils.SortUtils.generateRandomArray;
import static org.junit.Assert.*;

/**
 * Created on 1/26/21.
 */
public class BubbleSortTest {

    @Test
    public void testSelectionSort() {
        for(int i = 0; i <= 10 ; i++){
            int[] arr = generateRandomArray(100);
            int[] curArray = arr;
            Arrays.sort(curArray);
            assertArrayEquals(curArray, bubbleSort(arr));

        }
    }

    @Test
    public void testSelectionSort2() {
        int[] curArray = {1,2,3,4,5,6,7,8,9};
        int[] arr = {9,3,4,5,8,1,2,6,7};
        assertArrayEquals(curArray, bubbleSort(arr));

    }
}