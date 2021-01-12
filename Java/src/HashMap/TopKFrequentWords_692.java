package HashMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 1/11/21.
 */
public class TopKFrequentWords_692 {
    public static List<String> topKFrequentPriorityQueue(String[] words, int k) {
        Map<String, Integer> counter = Stream.of(words)
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));

        Queue<String> pq = new PriorityQueue<>(
                (w1, w2) -> counter.get(w1).equals(counter.get(w2)) ?
                        w2.compareTo(w1) : counter.get(w1) - counter.get(w2));

        counter.forEach((word, count) -> {
            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        });

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.reverse(ans);

        return ans;
    }

    public static List<String> topKFrequentCountingSort(String[] words, int k) {

        Map<String, Integer> counter = Stream.of(words)
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));

        List<String> temp = new ArrayList<>(counter.keySet());

        Collections.sort(temp,
                (w1, w2) -> counter.get(w1).equals(counter.get(w2)) ?
                w1.compareTo(w2) : counter.get(w2) - counter.get(w1));

        return temp.subList(0, k);

    }
}
