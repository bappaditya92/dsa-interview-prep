import java.util.*;

public class TopKIPs {

    public static void main(String[] args) {

        String[] ips = {
                "1.1.1.1",
                "2.2.2.2",
                "1.1.1.1",
                "3.3.3.3",
                "1.1.1.1",
                "2.2.2.2"
        };

        Map<String, Integer> countMap = new HashMap<>();

        for (String ip : ips) {
            countMap.put(ip,
                    countMap.getOrDefault(ip, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                b.getValue() - a.getValue());

        pq.addAll(countMap.entrySet());

        for (int i = 0; i < 2; i++) {
            System.out.println(pq.poll());
        }
    }
}
