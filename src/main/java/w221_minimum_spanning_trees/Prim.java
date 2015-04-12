package w221_minimum_spanning_trees;

import w141_priority_queue.BinaryHeapPriorityQueue;
import w141_priority_queue.PriorityQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandro on 4/11/15.
 */
public class Prim {
    private boolean[] marked;
    private PriorityQueue<Edge> pq;
    private List<Edge> mst;

    public Prim(EdgeWeightedGraph graph) {
        marked = new boolean[graph.numVertices()];
        pq = new BinaryHeapPriorityQueue<>(graph.numEdges());
        mst = new ArrayList<>();
        visit(graph, 0);

        while (pq.isEmpty() && mst.size() < graph.numVertices() - 1) {
            Edge cur = pq.delMax();
            int v = cur.either(), w = cur.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.add(cur);
            if (!marked[v]) {
                visit(graph, v);
            }
            if (!marked[w]) {
                visit(graph, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph graph, int vertex) {
        marked[vertex] = true;
        for (Edge edge: graph.adjacent(vertex)) {
            if (!marked[edge.other(vertex)]) {
                pq.insert(edge);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
