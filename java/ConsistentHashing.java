import java.util.*;

class ConsistentHashing {
    private final SortedMap<Integer, String> ring = new TreeMap<>();
    private final int replicas = 3;

    public void addServer(String server) {
        for (int i = 0; i < replicas; i++) {
            int hash = (server + i).hashCode();
            ring.put(hash, server);
        }
    }

    public String getServer(String key) {
        if (ring.isEmpty()) return null;

        int hash = key.hashCode();
        SortedMap<Integer, String> tail = ring.tailMap(hash);

        int nodeHash = tail.isEmpty() ? ring.firstKey() : tail.firstKey();
        return ring.get(nodeHash);
    }

    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing();
        ch.addServer("Server1");
        ch.addServer("Server2");

        System.out.println(ch.getServer("User123"));
    }
}
