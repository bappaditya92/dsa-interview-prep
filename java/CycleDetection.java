import java.util.*;

public class CycleDetection {

    private int vertices;

    private LinkedList<Integer>[] adjacencyList;

    CycleDetection(int v) {

        vertices = v;

        adjacencyList = new LinkedList[v];

        for(int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    boolean hasCycleUtil(
            int node,
            boolean[] visited,
            boolean[] recursionStack) {

        if(recursionStack[node]) {
            return true;
        }

        if(visited[node]) {
            return false;
        }

        visited[node] = true;

        recursionStack[node] = true;

        for(int neighbor : adjacencyList[node]) {

            if(hasCycleUtil(
                    neighbor,
                    visited,
                    recursionStack)) {

                return true;
            }
        }

        recursionStack[node] = false;

        return false;
    }
}
