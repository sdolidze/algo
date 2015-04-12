package w221_minimum_spanning_trees;

import w111_union_find.UnionFind;
import w111_union_find.WeightedQuickUnionWithPassCompression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by sandro on 4/11/15.
 */
public class Kruskal {
    private List<Edge> mst;

    public Kruskal(EdgeWeightedGraph graph) {
        mst = new ArrayList<>();
        Edge[] edges = new Edge[graph.numEdges()];
        Iterator<Edge> it = graph.edges().iterator();
        for (int i = 0; i < edges.length; i++) {
            edges[i] = it.next();
        }
        Arrays.sort(edges);
        UnionFind uf = new WeightedQuickUnionWithPassCompression(graph.numEdges());
        for (int i = 0; i < edges.length; i++) {
            if (mst.size() == graph.numVertices() - 1) {
                break;
            }
            int v = edges[i].either(), w = edges[i].other(v);
            if (!uf.connected(v, w)) {
                uf.union(v, w);
                mst.add(edges[i]);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
