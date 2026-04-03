import java.util.*;
import java.util.stream.*;

class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3,4};
        int k = 2;

        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        PriorityQueue<Map.Entry<Integer, Long>> pq =
                new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Long> entry : freqMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        Collections.reverse(result);
        System.out.println(result);
    }
}
