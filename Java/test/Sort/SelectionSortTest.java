package Sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static Sort.SelectionSort.selectionMinMaxSort;
import static Sort.SelectionSort.selectionSort;
import static Utils.SortUtils.generateRandomArray;
import static org.junit.Assert.*;

/**
 * Created on 1/26/21.
 */
public class SelectionSortTest {


    @Test
    public void testSelectionSort() {

        for (int i = 0; i < 10; i++) {
            int[] arr = generateRandomArray(100);
            int[] curArray = arr;
            Arrays.sort(curArray);
            assertArrayEquals(curArray, selectionSort(arr));
        }
    }

    @Test
    public void testSelectionMinMaxSort() {

        for (int i = 0; i < 10; i++) {
            int[] arr = generateRandomArray(100);
            int[] curArray = arr;
            Arrays.sort(curArray);
            assertArrayEquals(curArray, selectionMinMaxSort(arr));
        }
    }
}