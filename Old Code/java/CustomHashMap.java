import java.util.LinkedList;

public class CustomHashMap<K, V> {

    class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry<K, V>>[] buckets;
    private int capacity = 16;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[capacity];
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // update existing key
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;

        buckets[index].removeIf(entry -> entry.key.equals(key));
        size--;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("apple", 10); // update

        System.out.println("apple = " + map.get("apple"));
        System.out.println("banana = " + map.get("banana"));
        System.out.println("size = " + map.size());
    }
}
