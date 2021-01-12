package HashMap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static HashMap.TopKFrequentWords_692.topKFrequentCountingSort;
import static HashMap.TopKFrequentWords_692.topKFrequentPriorityQueue;
import static org.junit.Assert.assertEquals;

/**
 * Created on 1/11/21.
 */
public class TopKFrequentWords_692Test {

    private static final String[] nums1 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    private static final int k1 = 4;

    private static final List<String> res1 = new ArrayList<String>() {{
        add("the");
        add("is");
        add("sunny");
        add("day");
    }};


    private static final String[] nums2 = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
    private static final int k2 = 2;
    private static final List<String> res2 = new ArrayList<String>() {{
        add("i");
        add("love");
    }};

    @Test
    public void test1() {

        assertEquals(res1, topKFrequentPriorityQueue(nums1, k1));
        assertEquals(res2, topKFrequentPriorityQueue(nums2, k2));
    }

    @Test
    public void test2() {
        assertEquals(res1, topKFrequentCountingSort(nums1, k1));
        assertEquals(res2, topKFrequentCountingSort(nums2, k2));
    }

}