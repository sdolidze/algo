package w221_minimum_spanning_trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 4/11/15.
 */
public class EdgeWeightedGraph {
    private List<Edge>[] adj;

    public EdgeWeightedGraph(int numVertices) {
        adj = (List<Edge>[]) new List[numVertices];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
    }

    public Iterable<Edge> adjacent(int vertex) {
        return adj[vertex];
    }

    public Iterable<Edge> edges() {
        return null;
    }

    public int numVertices() {
        return adj.length;
    }

    public int numEdges() {
        return -1;
    }
}
