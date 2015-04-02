package w211_undirected_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sandro on 3/20/15.
 */
public class GraphPrime<T> {
    private Map<T, List<T>> vertices;

    public GraphPrime() {
        vertices = new HashMap<>();
    }

    public void addEdge(T from, T to) {
        vertices.putIfAbsent(from, new ArrayList<T>());
        vertices.get(from).add(to);

        vertices.putIfAbsent(to, new ArrayList<T>());
        vertices.get(to).add(from);
    }

    public Iterable<T> adjacent(T vertex) {
        return vertices.get(vertex);
    }

    public int vertices() {
        return vertices.size();
    }

    public int edges() {
        throw new UnsupportedOperationException();
    }
}
