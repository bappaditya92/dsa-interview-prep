import java.util.*;

public class GraphCycle {
    private final Map<Integer, List<Integer>> graph = new HashMap<>();

    public void addEdge(int u, int v) {
        graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    }

    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recursionStack = new HashSet<>();

        for (Integer node : graph.keySet()) {
            if (dfs(node, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, Set<Integer> visited, Set<Integer> stack) {
        if (stack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        stack.add(node);

        for (int neighbor : graph.getOrDefault(node, Collections.emptyList())) {
            if (dfs(neighbor, visited, stack)) return true;
        }

        stack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        GraphCycle g = new GraphCycle();
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Has Cycle...: " + g.hasCycle());
    }
}
