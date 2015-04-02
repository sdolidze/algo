package w211_undirected_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 3/20/15.
 */
public class Graph {
    // maybe linked lists will be more efficient
    private List<Integer>[] vertices;

    public Graph(int numVertices) {
        vertices = new List[numVertices];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        // todo: how should I handle duplicates?
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
