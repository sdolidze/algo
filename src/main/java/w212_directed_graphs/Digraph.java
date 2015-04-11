package w212_directed_graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 3/20/15.
 */
public class Digraph {
    private List<Integer>[] vertices;
    private int edges;

    public Digraph(int numVertices) {
        vertices = new List[numVertices];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to) {
        vertices[from].add(to);
        edges++;
    }

    public Digraph reverse() {
        Digraph reversed = new Digraph(vertices());
        for (int vertex = 0; vertex < vertices.length; vertex++) {
            for (int neighbor: adjacent(vertex)) {
                reversed.addEdge(neighbor, vertex);
            }
        }
        return reversed;
    }

    public Iterable<Integer> adjacent(int vertex) {
        return vertices[vertex];
    }

    public int vertices() {
        return vertices.length;
    }

    public int edges() {
        return edges;
    }
}
