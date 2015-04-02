package w211_undirected_graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sandro on 3/20/15.
 */
public class DFS {
    public DFS(Graph g, int startVertex) {
        dfsAnother(g, startVertex, new HashSet<>());
    }

    private void dfs(Graph g, int vertex, Set<Integer> visited) {
        System.out.println(vertex);
        for (int neighbor: g.adjacent(vertex)) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                dfs(g, neighbor, visited);
            }
        }
    }

    private void dfsAnother(Graph g, int vertex, Set<Integer> visited) {
        visited.add(vertex);
        System.out.println(vertex);
        for (int neighbor: g.adjacent(vertex)) {
            if (!visited.contains(neighbor)) {
                dfsAnother(g, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        DFS dfs = new DFS(g, 0);
    }
}
