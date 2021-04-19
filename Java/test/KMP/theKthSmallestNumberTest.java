package KMP;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static KMP.BFPRT.minKth;
import static KMP.theKthSmallestNumber.findKthSmallestNumber;
import static Utils.SortUtils.generateRandomArray;
import static Utils.SortUtils.printArray;

public class theKthSmallestNumberTest {
    int target = 5;
    int[] test1 = generateRandomArray(10);

    @Test
    public void testBfprk() {
        int[] copy1 = new int[test1.length];
        System.arraycopy(test1, 0, copy1, 0, test1.length);
        int res1 = minKth(copy1, target);
        Arrays.sort(test1);
        printArray(test1);
        Assert.assertEquals(res1, test1[target - 1]);
    }

    @Test
    public void testTheKthSmallestNumber(){
        int[] copy2 = new int[test1.length];
        System.arraycopy(test1, 0, copy2, 0, test1.length);
        int res2 = findKthSmallestNumber(copy2, 0, copy2.length - 1, target);
        Arrays.sort(test1);
        printArray(test1);
        Assert.assertEquals(res2, test1[target - 1]);

    }

}