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

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class DoublyLinkedList<K, V> {
        private final Node<K, V> head;
        private final Node<K, V> tail;

        DoublyLinkedList() {
            head = new Node<>(null, null);
            tail = new Node<>(null, null);
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        void moveToFront(Node<K, V> node) {
            remove(node);
            addFirst(node);
        }

        Node<K, V> removeLast() {
            Node<K, V> last = tail.prev;
            remove(last);
            return last;
        }

        void remove(Node<K, V> node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.get(1);       
        cache.put(3, "C"); 

        System.out.println(cache.get(2)); 
        System.out.println(cache.get(1)); 
        System.out.println(cache.get(3)); 
    }
}
