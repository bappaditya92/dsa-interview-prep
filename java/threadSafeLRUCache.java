import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> {

    private final int capacity;
    private final HashMap<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> dll;
    private final ReentrantLock lock = new ReentrantLock();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList<>();
    }

    public V get(K key) {
        lock.lock();
        try {
            Node<K, V> node = map.get(key);
            if (node == null) return null;

            dll.moveToFront(node);
            return node.value;
        } finally {
            lock.unlock();
        }
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                dll.moveToFront(node);
                return;
            }

            if (map.size() == capacity) {
                Node<K, V> lru = dll.removeLast();
                map.remove(lru.key);
            }

            Node<K, V> newNode = new Node<>(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        } finally {
            lock.unlock();
        }
    }


    }
}
