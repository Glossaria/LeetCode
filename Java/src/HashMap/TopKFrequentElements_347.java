package HashMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Created on 1/11/21.
 */

public class TopKFrequentElements_347 {

    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> counter = IntStream.of(nums).boxed()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));

        //empty pq
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));

        counter.forEach((num, count) -> {

            if (pq.size() < k) {
                pq.offer(num);

            } else if (counter.get(pq.peek()) < count) {
                pq.poll();
                pq.offer(num);
            }
        });

        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static int[] topKFrequent2(int[] nums, int k) {

        Map<Integer, Integer> counter = IntStream.of(nums).boxed()
                .collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));

        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        counter.forEach((num, count) -> {
            freq[count].add(num);
        });

        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i > 0 && idx < k; i--) {
            for (int num : freq[i]) {
                res[idx++] = num;
            }
        }

        return res;
    }

    public static int[] topKFrequent3(int[] nums, int k) {

        Map<Integer, Integer> counter = IntStream.of(nums).boxed()
                .collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));

        Comparator<Integer> comparator = new ValueComparator(counter);
        TreeMap<Integer, Integer> result = new TreeMap<Integer, Integer>(comparator);
        result.putAll(counter);

        Collection<Integer> freq = result.keySet();

        int[] res = new int[k];
        for (int j = 0; j < k && j < result.size(); j++) {
            res[j] = (int) freq.toArray()[j];
        }
        return res;
    }

}

 class ValueComparator implements Comparator<Integer> {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public ValueComparator(Map<Integer, Integer> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(Integer s1, Integer s2) {
        if (map.get(s1) >= map.get(s2)) {
            return -1;
        } else {
            return 1;
        }
    }

 }
