package Sort;

import org.junit.Test;

import java.util.Arrays;

import static Sort.ShellSort.shellSort;
import static Utils.SortUtils.generateRandomArray;
import static org.junit.Assert.*;

/**
 * Created on 1/28/21.
 */
public class ShellSortTest {

    @Test
    public void testSelectionSort() {
        for (int i = 0; i <= 10; i++) {
            int[] arr = generateRandomArray(10);
            int[] curArray = arr;
            Arrays.sort(curArray);
            assertArrayEquals(curArray, shellSort(arr));
        }
    }
}