package w222_shortest_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 4/12/15.
 */
public class EdgeWeightedDigraph {
    private List<DirectedEdge>[] adjacencyList;
    private int numEdges;

    public EdgeWeightedDigraph(int numVertices) {
        adjacencyList = (List<DirectedEdge>[]) new List[numVertices];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        numEdges = 0;
    }

    public void addEdge(DirectedEdge e) {
        adjacencyList[e.from()].add(e);
        numEdges++;
    }

    public Iterable<DirectedEdge> adjacent(int vertex) {
        return adjacencyList[vertex];
    }

    public int numVertices() {
        return adjacencyList.length;
    }

    public int numEdges() {
        return numEdges;
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> edges = new ArrayList<>();
        for (List<DirectedEdge> list: adjacencyList) {
            edges.addAll(list);
        }
        return edges;
    }

    public static void main(String[] args) {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(3);
        graph.addEdge(new DirectedEdge(0, 2, 5));
        graph.addEdge(new DirectedEdge(1, 2, 3));
        graph.addEdge(new DirectedEdge(1, 0, 2));
        System.out.println(graph.edges());
    }
}
