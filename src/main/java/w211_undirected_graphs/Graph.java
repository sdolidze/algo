package w211_undirected_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 3/20/15.
 */
public class Graph {
    // probably linked list is more efficient
    private List<Integer>[] vertices;

    public Graph(int numVertices) {
        vertices = new List[numVertices];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        vertices[from].add(to);
        vertices[to].add(from);
    }

    public Iterable<Integer> adjacent(int vertex) {
        return vertices[vertex];
    }

    public int vertices() {
        return vertices.length;
    }

    public int edges() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
