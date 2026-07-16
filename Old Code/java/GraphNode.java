import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

class GraphNode {
    int val;
    List<GraphNode> neighbors = new ArrayList<>();
    GraphNode(int val) { this.val = val; }
}

class GraphCloner {
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) return null;
        Map<GraphNode, GraphNode> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private GraphNode dfs(GraphNode node, Map<GraphNode, GraphNode> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        GraphNode clone = new GraphNode(node.val);
        visited.put(node, clone);
        for (GraphNode neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, visited));
        }
        return clone;
    }
}
