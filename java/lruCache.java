import java.util.*;

class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true); // access order = true
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public int getValue(int key) {
        return getOrDefault(key, -1);
    }

    public void putValue(int key, int value) {
        put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.putValue(1, 10);
        cache.putValue(2, 20);
        cache.getValue(1);
        cache.putValue(3, 30);

        System.out.println(cache); // {1=10, 3=30}
    }
}
