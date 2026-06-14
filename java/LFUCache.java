import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    private final int capacity;
    private int minFreq;

    private Map<Integer, Node> cache;
    private Map<Integer, LinkedHashSet<Integer>> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!cache.containsKey(key)) {
            return -1;
        }

        updateFrequency(cache.get(key));

        return cache.get(key).value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        if (cache.containsKey(key)) {

            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);

            return;
        }

        if (cache.size() >= capacity) {

            int evictKey =
                    freqMap.get(minFreq)
                            .iterator()
                            .next();

            freqMap.get(minFreq)
                    .remove(evictKey);

            cache.remove(evictKey);
        }

        Node node = new Node(key, value);

        cache.put(key, node);

        freqMap.computeIfAbsent(
                1,
                k -> new LinkedHashSet<>()
        ).add(key);

        minFreq = 1;
    }

    private void updateFrequency(Node node) {

        int freq = node.freq;

        freqMap.get(freq).remove(node.key);

        if (freq == minFreq
                && freqMap.get(freq).isEmpty()) {

            minFreq++;
        }

        node.freq++;

        freqMap.computeIfAbsent(
                node.freq,
                k -> new LinkedHashSet<>()
        ).add(node.key);
    }
}
