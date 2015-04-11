package w211_undirected_graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by sandro on 4/5/15.
 */
public class ConnectedComponents {
    private int[] id;
    private boolean[] visited;
    private int count;

    ConnectedComponents(Graph graph) {
        id = new int[graph.vertices()];
        visited = new boolean[graph.vertices()];
        count = 0;
        visitAll(graph);
    }

    private void visitAll(Graph graph) {
        for (int vertex = 0; vertex < visited.length; vertex++) {
            if (!visited[vertex]) {
                dfs(graph, vertex);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int vertex) {
        visited[vertex] = true;
        id[vertex] = count;
        for (int neighbor: graph.adjacent(vertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 5);
        ConnectedComponents cc = new ConnectedComponents(g);
        System.out.println(Arrays.toString(IntStream.range(0, 7).toArray()));
        System.out.println(Arrays.toString(cc.id));

    }
}
