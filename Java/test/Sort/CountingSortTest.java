package Sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static Sort.CountSort.countSort;
import static Utils.SortUtils.generateRandomArray;

public class CountingSortTest {

    @Test
    public void testCountSort() {

        for (int i = 0; i < 100; i++) {
            int boundary = 40;
            int[] test1 = generateRandomArray(100, boundary);
            int[] expect = new int[test1.length];
            System.arraycopy(test1, 0, expect, 0, test1.length);
            Arrays.sort(expect);
            Assert.assertArrayEquals(countSort(test1, boundary),expect );
        }

    }

}